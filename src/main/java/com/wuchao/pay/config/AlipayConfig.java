package com.wuchao.pay.config;

public class AlipayConfig {
    //支付宝商户号的APPID
    public static String APPID = "";

    //用支付宝密钥生成工具生成的私钥
    public static String RSA_PRIVATE_KEY = "";

    //电脑网站支付结果异步通知，可以参考异步文档，一定要是外网能访问的
    public static String notify_url = "";

    //电脑网站支付结果同步通知，用于转跳到用户自己的页面，一定要是外网能访问的
    public static String return_url = "";

    //沙箱接口，正式上线时请改用正式支付接口
    public static String URL = "https://openapi.alipaydev.com/gateway.do";

    //固定的参数
    public static String CHARSET = "UTF-8";

    //固定的参数
    public static String FORMAT = "json";

    //用支付宝密钥生成工具生成的公钥
    public static String ALIPAY_PUBLIC_KEY = "";

    //固定的参数
    public static String log_path = "/log";

    //固定的参数
    public static String SIGNTYPE = "RSA2";

    public AlipayConfig() {
    }

}
