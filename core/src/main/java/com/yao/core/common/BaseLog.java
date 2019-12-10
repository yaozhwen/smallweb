package com.yao.core.common;

import com.google.gson.Gson;
import com.yao.core.eureka.EurekaResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by yaozwsq on 2019/12/4.
 */
public class BaseLog {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

//    private static String skey = "wUbGgWr0YCuimqCq";
//    private static String ivParameter = "qjjZjdoRn40MgjHU";
//
//    /*加密*/
//    public static String loggerEn(String str){
//        String encrypt = "";
//        if(StringUtils.isBlank(str)){
//            return encrypt;
//        }
//        if("1".equals(Global.logEncrypt)){
//            try {
//                encrypt = AppEnAndDeUtils.AESencrypt(str,skey,ivParameter);
//            } catch (Exception e) {
//                e.printStackTrace();
//                encrypt=str;
//            }
//        }else {
//            encrypt=str;
//        }
//
//        return encrypt;
//    }
//
//    /*解密*/
//    public static String loggerDe(String str){
//        String decrypt = "";
//        if(StringUtils.isBlank(str)){
//            return decrypt;
//        }
//        try {
//            decrypt = AppEnAndDeUtils.AESdecrypt(str,skey,ivParameter);
//        } catch (Exception e) {
//            e.printStackTrace();
//            decrypt=str;
//        }
//        return decrypt;
//    }

    /**
     * 返回处理--int
     * @param result
     * @return
     */
    protected EurekaResponse handleInt(int result){
        EurekaResponse eurekaResult ;
        if (result!=1)
            eurekaResult = new EurekaResponse(EurekaResponse.Status.error, "00", "error");
        else
            eurekaResult =new EurekaResponse(EurekaResponse.Status.success, "88", "success");
        return eurekaResult;
    }

    /**
     * 返回处理--int
     * @param actuallResult 实际结果
     * @param expectedResult 期望结果
     * @return
     */
    protected EurekaResponse handleInt(int actuallResult,int expectedResult){
        EurekaResponse eurekaResult ;
        if (actuallResult!=expectedResult)
            eurekaResult = new EurekaResponse(EurekaResponse.Status.error, "00", "error");
        else
            eurekaResult =new EurekaResponse(EurekaResponse.Status.success, "88", "success");
        return eurekaResult;
    }


    /**
     * 返回处理--异常
     * @param errorMessage
     * @return
     */
    protected EurekaResponse error(String errorCode, String errorMessage){
        return new EurekaResponse(EurekaResponse.Status.error, errorCode==null?"00":errorCode, errorMessage==null?"error":errorMessage);
    }

    /**
     * 返回处理--Boolean
     * @param result
     * @return
     */
    protected EurekaResponse handleBoolean(Boolean result){
        EurekaResponse eurekaResult ;
        if (result==null)
            eurekaResult = new EurekaResponse(EurekaResponse.Status.error, "00", "error");
        else
            eurekaResult =new EurekaResponse(EurekaResponse.Status.success, "88", "success");
        return eurekaResult;
    }

    /**
     * 返回处理--Boolean
     * @param result
     * @return
     */
    protected EurekaResponse handleJsonResult(JsonResult result){
        EurekaResponse eurekaResult ;
        if (result==null || result.getStatus()== JsonResult.Status.error){
            eurekaResult = new EurekaResponse(EurekaResponse.Status.error, "00", result==null?"error":result.getMessage());
            return eurekaResult;
        }else {
            eurekaResult =new EurekaResponse(EurekaResponse.Status.success, "88", result.getMessage()==null?"success":result.getMessage());
            if (result.getValue()!=null)
                eurekaResult.setValue(result.getValue() instanceof String ? ((String) result.getValue()) : new Gson().toJson(result.getValue()));
            return eurekaResult;
        }
    }
}
