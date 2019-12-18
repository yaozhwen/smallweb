package com.yao.core.common;

/**
 * Created by yaozwsq on 2019/12/4.
 */
public class Constants {

    public static final String[] DATE_PATTERNS = new String[] { "yyyy", "yyyy-MM", "yyyyMM", "yyyy/MM", "yyyy-MM-dd", "yyyyMMdd", "yyyy/MM/dd", "yyyy-MM-dd HH:mm:ss", "yyyyMMddHHmmss", "yyyy/MM/dd HH:mm:ss" };

    public static final String CAPTCHA = "captcha";
    public static final String LOGINTYPE = "loginType";

    /*admin使用*/
    public static final String LOGIN_TYPE_ADMIN = "admin";
    public static final String ADMIN_SESSION_CAPTCHA = "adminCaptcha";
    public static final String ADMIN_SESSION_BEAN = "admin_session_bean";

    /*正则表达式：数字*/
    public static final String REGEX_NUMBER = "^\\d+$";
    /*正则表达式：正则校验金额，且小数点只能是2位*/
    public static final String REGEX_MONEY = "(^[1-9]([0-9]+)?(\\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\\.[0-9]([0-9])?$)";
    // 正整数
    public static final String RegExp_Integer  =  "^[0-9]*[1-9][0-9]*$";
    // 自然数(非负整数)
    public static final String Natural_Number  =  "^(([1-9]\\d*)|\\d)$";
    // 两位正小数
    public static final String RegExp_TwoDecimal =  "^(\\+)?\\d+(\\.\\d{1,2})?$";

    // 商户账号正则
    public static final String ACCOUNT_REG_EXP = "^\\d{7}$";
    // 手机号正则
    public static final String PHONE_REG_EXP = "^1([0-9])\\d{9}$";
    // 身份证号正则
    public static final String ID_REG_EXP = "^(\\d{15}$|^\\d{18}$|^\\d{17}(\\d|X|x))$";
    /*邮箱*/
    public static  final String RegExp_EMAIL= "^([a-zA-Z0-9_-])+(\\.[a-zA-Z0-9_-]+)*@([a-zA-Z0-9_-])+(\\.[a-zA-Z0-9_-]+)+$";
    /*固定电话*/
    public static final String RegExp_Telephone =  "^(([0-9]{3,4}\\-[0-9]{7,8})|(([0-9]{3,4})[0-9]{3,8}))(\\-[0-9]{3,8})?$";
    /*登录密码*/
    public static  final String REGEXP_LOGINPASSWORD =  "^(?![^a-zA-Z]+$)(?!\\D+$).{8,20}$";
    /*支付密码*/
    public static final String RegExp_PWD =  "^\\d{6}$";

    /*营业执照注册号*/
    public static  final String RegExp_businesslicense= "^[0-9A-Za-z]{1,50}$";
    /*网址*/
    public static  final String RegExp_webSite= "^(http|https):\\/\\/[\\w\\-_]+(\\.[\\w\\-_]+)+([\\w\\-\\.,@?^=%&:/~\\+#]*[\\w\\-\\@?^=%&/~\\+#])?$";
    /*ip*/
    public static  final String REG_EXP_IP= "((25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))\\.){3}(25[0-5]|2[0-4]\\d|((1\\d{2})|([1-9]?\\d)))";

    /*银行卡号*/
    public static final String RegExp_BANKCARD =  "^\\d{1,25}$";
    // 代付银行代码
    public static final String RegExp_BankCode = "^\\d{4}$";
    // 银行联行号
    public static final String RegExp_BanKUninNo =  "^\\d{12}$";

    // 短信验证码，支付密码
    public static final String RegExp_SMSCODE =  "^\\d{6}$";
    // 机构邀请码正则
    public static final String RegExp_InviteCode = "^[0-9A-Za-z]{4,6}$";
    // 客户号
    public static final String RegExp_customerNo = "^[0-9A-Za-z]{4,20}$";
    // 订单号
    public static final String RegExp_OrderNo= "^[0-9A-Za-z]{10,30}$";
    // 图形验证码规则
    public static final String RegExp_VeriCode =  "^[0-9A-Za-z]{4}$";
    // 中文名称和字母数字
    public static final String RegExp_CN_Name =  "^([a-zA-Z0-9\\u4e00-\\u9fa5\\·]{1,20})$";
    // 中文
    public static final String RegExp_CN =  "[\u4e00-\u9fa5]";
    // 公司名称
    public static final String RegExp_CompanyName =  "^.{1,50}$";
}
