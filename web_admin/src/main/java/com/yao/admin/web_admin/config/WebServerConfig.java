package com.yao.admin.web_admin.config;

import org.apache.catalina.connector.Connector;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.File;
import java.nio.charset.Charset;

/**
 * Created by yaozwsq on 2019/12/6 15:41.
 */
@Configuration
public class WebServerConfig {

    @Autowired
    private Environment env;

    public TomcatServletWebServerFactory createTomcatServletWebServerFactory() {
        TomcatServletWebServerFactory tomcatFactory = new TomcatServletWebServerFactory();
        tomcatFactory.setPort(Integer.valueOf(env.getProperty("server.port")));
        tomcatFactory.setUriEncoding(Charset.forName("UTF-8"));
        tomcatFactory.addConnectorCustomizers(new MyTomcatConnectorCustomizer());
        String tomcatBaseDir = env.getProperty("server.yao.tomcat.basedir") + "/" + RandomStringUtils.randomAlphanumeric(10);
        tomcatFactory.setBaseDirectory(new File(tomcatBaseDir));
        return tomcatFactory;
    }
}

    class MyTomcatConnectorCustomizer implements TomcatConnectorCustomizer {
        public void customize(Connector connector) {
            Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
            protocol.setConnectionTimeout(20000);
            protocol.setKeepAliveTimeout(15000);
            protocol.setMaxKeepAliveRequests(1);
            protocol.setMaxHttpHeaderSize(8192);
            protocol.setAcceptCount(3500);
            //设置最大线程数
            protocol.setMaxThreads(2000);
            protocol.setMinSpareThreads(100);
            protocol.setCompression("on");
            protocol.setCompressionMinSize(2048);
            protocol.setDisableUploadTimeout(true);
            protocol.setSSLProtocol("TLSv1.1+TLSv1.2");
            protocol.setNoCompressionUserAgents("gozilla, traviata");
            protocol.setCompressibleMimeType("text/html,text/xml,text/javascript,text/css,text/plain");
            //设置最大连接数
            protocol.setMaxConnections(5000);

        }

    /*@Bean
    public EmbeddedServletContainerFactory createEmbeddedServletContainerFactory() {
        TomcatEmbeddedServletContainerFactory tomcatFactory = new TomcatEmbeddedServletContainerFactory();
        tomcatFactory.setPort(Integer.valueOf(env.getProperty("server.port")));
        tomcatFactory.setUriEncoding(Charset.forName("UTF-8"));
        tomcatFactory.setSessionTimeout(Integer.valueOf(env.getProperty("spring.shiro.session.expire")), TimeUnit.SECONDS);
        tomcatFactory.addConnectorCustomizers(new MyTomcatConnectorCustomizer());
        String tomcatBaseDir = env.getProperty("")+"/"+ RandomStringUtils.randomAlphanumeric(10);
        tomcatFactory.setBaseDirectory(new File(tomcatBaseDir));
        return tomcatFactory;
    }*/
}
