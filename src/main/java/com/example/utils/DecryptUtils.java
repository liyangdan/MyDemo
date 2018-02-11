package com.example.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.config.PlaceholderConfigurerSupport;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
/**
 * Created by liyangdan on 2018/1/29.
 */
public class DecryptUtils extends PropertyPlaceholderConfigurer {

    private Logger log = LoggerFactory.getLogger(DecryptUtils.class);

    //需要解密的属性
    private String[] encryptPropNames = {"jdbc.url","jdbc.username","jdbc.password"};

    /**
     * 对特定属性的属性值进行转换
     * @param propertyName 属性名称
     * @param propertyValue 属性值
     * @return
     */
    @Override
    public String convertProperty(String propertyName, String propertyValue) {
        log.info("The properties name is : {}, value is : ", propertyName, propertyValue);
        if(isEncryptProp(propertyName)){
            String decryptValue = EncryptionUtils.getDecryptString(propertyValue);
            log.info(decryptValue);
            return decryptValue;
        }else{
            return propertyValue;
        }
    }

    /**
     * 判断属性是否需要解密
     * @param propertyName
     * @return
     */
    private boolean isEncryptProp(String propertyName){
        for(String encryptPropName : encryptPropNames){
            if(StringUtils.equals(encryptPropName,propertyName)){
                return true;
            }
        }
        return false;
    }
}
