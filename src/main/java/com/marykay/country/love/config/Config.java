package com.marykay.country.love.config;

/**
 * Created by wanwei on 16/9/7.
 */
public class Config {
    // http port
    public int Port;
    public String AppID  = "com.marykay.china.community";
    public String Realm  = "MK.Community.Demo.api";
    public String Scope = "";


    // aws SQS
//    public String SQS_AccessKey;
//    public String SQS_SecretKey;
//    public String SQS_Queue;
//    public String Send_Email_Queue;


    // redis
//    public String RedisHost;
//    public int RedisPort;

    //aws s3
    public String S3_Url;
    public String S3_ClientID;

    public String Product_Url;


    private static Config instance;

    public static Config load() {
        if (instance != null) return instance;
        instance = new Config();
        instance.Port = 80;
        final String portEnv = System.getenv("PORT");
        if (portEnv != null) {
            instance.Port = Integer.parseInt(portEnv);
        }
        instance.S3_Url=loadEnv("S3_Url","http://community-aws-storage-core-internal-api-latest.dev.pcf-internal.mkc.io/v1/s3/");
        instance.S3_ClientID=loadEnv("S3_ClientID","265E00C3-AA98-40A2-AF99-9470ACC0C9D4");
        instance.Product_Url=loadEnv("Product_Url","https://services.ebz-chn-dev.mkaws.com/");
        return instance;
    }

    private static String loadEnv(String key, String defaultValue) {
        String value = System.getenv(key);
        return value == null ? defaultValue : value;
    }
}
