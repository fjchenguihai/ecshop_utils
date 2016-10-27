package com.ecshop.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TokenProcessor {
	 private static TokenProcessor instance = new TokenProcessor();  
	  
	    private long previous;  
	  
	    protected TokenProcessor() {  
	    }  
	  
	    public static TokenProcessor getInstance() {  
	        return instance;  
	    }  
	  
	    public synchronized String generateToken(String id) {  
	    	 try {  
	    		  
	             long current = System.currentTimeMillis();  
	             if (current == previous)   
	                 current++;  
	             previous = current;  
	             byte now[] = (new Long(current)).toString().getBytes();  
	             MessageDigest md = MessageDigest.getInstance("MD5");  
	               
	             md.update(id.getBytes());  
	             md.update(now);  
	             return toHex(md.digest());  
	         } catch (NoSuchAlgorithmException e) {  
	             return null;  
	         }  
	    }  
	  
	    private String toHex(byte buffer[]) {  
	        StringBuffer sb = new StringBuffer(buffer.length * 2);  
	        for (int i = 0; i < buffer.length; i++) {  
	            sb.append(Character.forDigit((buffer[i] & 240) >> 4, 16));  
	            sb.append(Character.forDigit(buffer[i] & 15, 16));  
	        }  
	  
	        return sb.toString();  
	    }  
}
