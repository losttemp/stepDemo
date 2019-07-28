package com.example.administrator.utils;
import java.security.MessageDigest;

public class Md5 {
        
         /***
         * MD5加码 生成32位md5码
         */
         /*public static String convertMD5(String inStr){
 
                   char[] a = inStr.toCharArray();
                   for (int i = 0; i < a.length; i++){
                            a[i] = (char) (a[i] ^ 't');
                   }
                   String s = new String(a);
                   return s;
 
         }*/
        
         public final static String string2MD5(String s, String charset) {
        try {
            byte[] btInput = s.getBytes(charset);
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            mdInst.update(btInput);
            byte[] md = mdInst.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < md.length; i++) {
                int val = ((int) md[i]) & 0xff;
                if (val < 16){
                   sb.append("0");
                }
                sb.append(Integer.toHexString(val));
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }
        
         /**
     * 使用MD5加字符串数据
     *
     * @param content 需要加密的数据
     * @return 加密后数据
     */
   /* public static String md5(String content) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(content.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("NoSuchAlgorithmException", e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UnsupportedEncodingException", e);
        }
 
        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10) {
                hex.append("0");
            }
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }*/
 
        
}