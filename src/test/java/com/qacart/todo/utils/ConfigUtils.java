package com.qacart.todo.utils;

import java.util.Properties;

public class ConfigUtils {
    private final Properties properties;
    private static ConfigUtils configUtils;
   private   ConfigUtils(){
       String env = System.getProperty("env","production");
       switch (env) {
           case "PRODUCTION" ->
                   properties = PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/production.properties");
           case "LOCAL" ->
                   properties = PropertiesUtils.loadProperties("src/test/java/com/qacart/todo/config/local.properties");
           default -> throw new RuntimeException("environment is not supported");
       }

  }
  public static ConfigUtils getInstance(){
       if(configUtils == null){
           configUtils =new ConfigUtils();
       }
       return configUtils;
  }
  public  String getBaseUrl () {
      String prop = properties.getProperty("baseUrl");
      if (prop == null) {return prop;}
       else throw new RuntimeException("could not find the base url in the property file");
  }
    public  String getEmail () {
        String prop = properties.getProperty("email");
        if (prop != null) return prop;
        else throw new RuntimeException("could not find the Email in the property file");
    }
    public  String getPassword () {
        String prop = properties.getProperty("password");
        if (prop != null) return prop;
        else throw new RuntimeException("could not find the Bassword in the property file");
    }
}
