package com.example.dem.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by liyangdan on 2018/2/10.
 */
public class EncryptionUtils {

    private static Logger logger = LoggerFactory.getLogger(EncryptionUtils.class);

    //指定DES加密解密所用密钥
    private static SecretKey key;

    private static String STR_SALT = "APLUS OFFICE SYSTEM";

    private static final String GENERATOR_DES = "DES";

    private static final String ENCODING_UTF8 = "UTF-8";

    private static final int CIPHER_COUNT = 5;
    private static File file=new File("/Users/liyangdan/IdeaProjects/MyDemo//keyencode.txt");


    static {
        try {
            KeyGenerator generator = KeyGenerator.getInstance(GENERATOR_DES);
            // generator.init();//MD5
            key = generator.generateKey();
            generator = null;
        }catch (NoSuchAlgorithmException e){
            logger.warn("Cryptographic failure");
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {
        try {
            for (int i=0; i<10; i++) {
                KeyGenerator generator = KeyGenerator.getInstance(GENERATOR_DES);
                // generator.init();//MD5
                key = generator.generateKey();
                System.out.println("key==" + key);
                generator = null;
            }
        }catch (NoSuchAlgorithmException e){
            logger.warn("Cryptographic failure");
            throw new RuntimeException(e);
        }
    }


    /**
     * 对字符串进行DES加密,返回BASE64编码的加密字符串
     * @param str 需要加密的字符串
     * @return 加密后的字符串
     */
    public static String getEncryptBase64String(String str) throws IOException {
//        BASE64Encoder base64Encoder = new BASE64Encoder();

        try{
            byte[] strBytes = str.getBytes(ENCODING_UTF8);
            Cipher cipher= Cipher.getInstance(GENERATOR_DES);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptStrBytes = cipher.doFinal(strBytes);
            return Base64.encodeBase64String(encryptStrBytes);
        }catch (Exception e){
            logger.warn("Cryptographic failure");
            throw new RuntimeException(e);
        }
    }

    /**
     * 对BASE64编码的加密字符串进行解密,返回解密后的字符串
     * @param str BASE64加密字符串
     * @return 解密后的字符串
     */
    public static String getDecryptString(String str){
//        BASE64Decoder base64Decoder = new BASE64Decoder();
        try{
            byte[] strBytes = Base64.decodeBase64(str);
            Cipher cipher= Cipher.getInstance(GENERATOR_DES);
            System.out.println("GENERATOR:"+GENERATOR_DES);
            cipher.init(Cipher.DECRYPT_MODE, key);
            System.out.println("Cipher:******"+Cipher.DECRYPT_MODE);
            System.out.println("key:*****"+key);
            byte[] decryptStrBytes = cipher.doFinal(strBytes);
            System.out.println("");
            return new String(decryptStrBytes, ENCODING_UTF8);
        }catch (Exception e){
            logger.warn("Decryption failure");
            throw new RuntimeException(e);
        }
    }


}

