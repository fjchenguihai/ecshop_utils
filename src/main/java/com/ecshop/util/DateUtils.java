package com.ecshop.util;

/*
 * File DateUtil.java
 * Created on 2004-6-25
 *
 */

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * @description 日期工具类
 * @author seabao
 * @project Jasine.WADK
 * @date 2004-6-25
 */
public class DateUtils {
	private static final String pattern = "yyyy-MM-dd HH:mm:ss";
	private static final SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	private static final int[] TIME_FIELD_LEVELS =
		{
			Calendar.YEAR,
			Calendar.MONTH,
			Calendar.DATE,
			Calendar.HOUR_OF_DAY,
			Calendar.MINUTE,
			Calendar.SECOND,
			Calendar.MILLISECOND };
	
	
	/**
	 * 返回"yyyy-MM-dd HH:mm:ss"的格式
	 * @return
	 */
	public static SimpleDateFormat getDefaultDateFormat(){
		return sdf;
	}
	/**
	 * 对齐日期对象到指定精度
	 * @param date 日期对象
	 * @param field 要对齐的时间域，参考Calendar中field的定义
	 * @return 对齐后的日期
	 */
	public static Date roundDate(Date date, int field) {
		if (date == null) {
			return date;
		}

		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());

		boolean clearFlag = false;
		for (int i = 0; i < TIME_FIELD_LEVELS.length; i++) {
			if (clearFlag) {
				cal.set(TIME_FIELD_LEVELS[i], cal.getMinimum(TIME_FIELD_LEVELS[i]));
			} else if (TIME_FIELD_LEVELS[i] == field) {
				clearFlag = true;
			}
		}

		return cal.getTime();
	}

	/**
	 * 调整日期对象
	 * @param date 日期对象
	 * @param field 时间域，参考Calendar中field的定义
	 * @param amount 调整数量
	 * @return 调整后的日期对象
	 */
	public static Date rollDate(Date date, int field, int amount) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		cal.add(field, amount);
		return cal.getTime();
	}

	/**
	 * 获得日期对象的时间域值
	 * @param field 时间域，参考Calendar中field的定义
	 * @return 对应时间域的值
	 */
	public static int getDateField(Date date, int field) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(field);
	}

	/**
	 * 获得修改时间域值后的日期对象
	 * @param date 日期对象
	 * @param field 时间域，参考Calendar中field的定义
	 * @param value 时间域的值
	 * @return 修改后的日期对象
	 */
	public static Date setDateField(Date date, int field, int value) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(date.getTime());
		cal.set(field, value);
		return cal.getTime();
	}

	public static boolean isToday ( java.util.Date date) {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.setTime(date);
		if (year == calendar.get(Calendar.YEAR)
			&& dayOfYear == calendar.get(Calendar.DAY_OF_YEAR)) 
			return true;
		else return false;
	}
	
	public static boolean isBoforeToday(java.util.Date date) {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.setTime(date);
		if (year > calendar.get(Calendar.YEAR)) return true;
		if (year < calendar.get(Calendar.YEAR)) return false;
		if (dayOfYear > calendar.get(Calendar.DAY_OF_YEAR)) return true;
		return false;		
	}
	
	public static boolean isAfterToday(java.util.Date date) {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int dayOfYear = calendar.get(Calendar.DAY_OF_YEAR);
		calendar.setTime(date);
		if (year < calendar.get(Calendar.YEAR)) return true;
		if (year > calendar.get(Calendar.YEAR)) return false;
		if (dayOfYear < calendar.get(Calendar.DAY_OF_YEAR)) return true;
		return false;		
	}
	
	/**
	 * 获得上一天的日期
	 */
	public static Date lastDay()
	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		return calendar.getTime();
	}
	/**
	 * 比较天数
	 * @return 开始日期与结束日期天数差
	 */
	public static int compareDays(Date startDay, Date endDay){
		long start = startDay.getTime();
		long end = endDay.getTime();
		long datemills = 24L*60L*60L*1000L;
		
		long during = end - start;
		
		return (int)(during/datemills);
	}
	
	 
	/**
	 * when btime>atime true
	 * @param atime
	 * @param btime
	 * @return
	 */
	public static boolean isATimeBefaoreBTime(Date atime, Date btime){
		boolean success = false;
		long start = atime.getTime();
		long end = btime.getTime();
		long during = end - start;
		if(during>0 || during==0){
			success = true;
		}
		return success;
	}
	
	/**
	 * 
	 * 组合日期和时间
	 * <p>
	 * @param date 时间偏移
	 * @param time 日期偏移
	 * @return
	 */
	public static Date composeDateTime(Date date,Date time){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY,getDateField(time, Calendar.HOUR_OF_DAY));
		cal.set(Calendar.MINUTE, getDateField(time, Calendar.MINUTE));
		cal.set(Calendar.SECOND, getDateField(time, Calendar.SECOND));
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	
	/**
	 * 格式化日期
	 * @param date
	 * @return date为空时返回空字符串
	 */
	 public static String dateToString(Date date){
	   if(date!=null){
	    return sdf.format(date);
	   }
	   return "";
	 }
	 
	 /**
	  * 根据  pattern 规则格式化 日期
	  * @param date
	  * @param pattern 
	  * @return date为空时返回空字符串,pattern为空时返回默认格式("yyyy-MM-dd HH:mm:ss")
	  */
	 public static String dateToString(Date date,String pattern){
		 if(!"".equals(pattern)&&pattern!=null){
			SimpleDateFormat temp = new SimpleDateFormat(pattern);
			if(date!=null){
				return temp.format(date);
			}
		 }
		 if(date!=null){
			 return sdf.format(date);
		 }
		 return "";
	 }
	 
	 public static Date dateFormat(Date date,String pattern)throws Exception {
		 if(!"".equals(pattern)&&pattern!=null){
			SimpleDateFormat temp = new SimpleDateFormat(pattern);
			if(date!=null){
				String dd =  temp.format(date);
				return temp.parse(dd);
			}
		 }
		 return null;
	 }
	 
	 
	 //把字符串转为日期   
	 public static Date ConverToDate(String strDate,String pattern) {  
	    if(!"".equals(pattern)&&pattern!=null){
	    	SimpleDateFormat temp = new SimpleDateFormat(pattern);
	    	if(Utils.isNotBlank(strDate)){
	    		Date date = new Date();
				try {
					date = temp.parse(strDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
	    		return date;
	    	}
	 	}
	    return null;  
	 }
	 
	 public static Date getDateOfBeginTime(String strDate,String pattern){
		 Date date = ConverToDate(strDate, pattern);
		 return getStartDate(date);
		 
	 }
	 
	 public static Date getDateOfEndTime(String strDate,String pattern){
		 Date date = ConverToDate(strDate, pattern);
		 return getEndDate(date);
		 
	 }
	 
	public static Date getStartDate(Date date) {
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTime(date);
		 calendar.set(Calendar.HOUR_OF_DAY, 0);
		 calendar.set(Calendar.MINUTE, 0);
		 calendar.set(Calendar.SECOND, 0);
		 return calendar.getTime();
	}

	public static Date getEndDate(Date date) {
		 Calendar calendar = Calendar.getInstance();
		 calendar.setTime(date);
		 calendar.set(Calendar.HOUR_OF_DAY, 23);
		 calendar.set(Calendar.MINUTE, 59);
		 calendar.set(Calendar.SECOND, 59);
		 return calendar.getTime();
	}
	 
	 /**  
	  * 获取前一个月的日期  
	  *   
	  * @return 前一个月的日期  
	  */  
	 public static Date getTodayBeforeMonth(Date currentTime,String format) throws Exception{   
	     SimpleDateFormat formatter = new SimpleDateFormat(format);   
	    // Date currentTime = new Date();// 得到当前系统时间   
	     long now = currentTime.getTime();// 返回自 1970 年 1 月 1 日 00:00:00 GMT   
	                                         // 以来此Date 对象表示毫秒数   
	     currentTime = new Date(now - 86400000 * 24);   
	     long now1 = currentTime.getTime();   
	     currentTime = new Date(now1 - 86400000 * 6);   
	     String current = formatter.format(currentTime);   
	     return formatter.parse(current);   
	 }   
	 /**
	  * 获取当前系统时间
	  * @param pattern yyyy-MM-dd HH:mm:ss
	  * @return
	  */
	 public static Date getCurrentDate(String pattern){
		 SimpleDateFormat formatter = new SimpleDateFormat(pattern);   
		 Date date = Calendar.getInstance().getTime();
		 String dateString = formatter.format(date);
		 try {
			date= formatter.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return date;
	 }
	 /**
	  * 获取当前系统时间
	  * @param pattern yyyy-MM-dd HH:mm:ss
	  * @return
	  */
	 public static Timestamp getCurrentTimeStamp(String pattern){
		 SimpleDateFormat formatter = new SimpleDateFormat(pattern);   
		 Date date = Calendar.getInstance().getTime();
		 String dateString = formatter.format(date);
		 return Timestamp.valueOf(dateString);
	 }
	 /**
	  * 获取当前系统时间字符串
	  * @param pattern yyyy-MM-dd HH:mm:ss
	  * @return
	  */
	 public static String getCurrentDateStr(String pattern){
		 SimpleDateFormat formatter = new SimpleDateFormat(pattern);   
		 Date date = Calendar.getInstance().getTime();
		 String dateString = formatter.format(date);
		 return dateString;
	 }
	 
	 	 /**
	  * 获取当前系统时间(中文格式) 2015年10月27日 19时50分32秒
	  * @return 2015年10月27日 19时50分32秒
	  */
	 public static String getCurrentChineseDate(){
		 Calendar cal = Calendar.getInstance();
		 int year = cal.get(Calendar.YEAR);
		 int month = cal.get(Calendar.MONTH);
		 int day = cal.get(Calendar.DAY_OF_MONTH);
		 int hour = cal.get(Calendar.HOUR_OF_DAY);
		 int min = cal.get(Calendar.MINUTE);
		 int sec = cal.get(Calendar.SECOND);
		 String date = year+"年"+(month+1)+"月"+day+"日 "+hour+"时"+min+"分"+sec+"秒";
		 return date;
	 }
	 
	 /**
	  * 获取当前系统的偏移时间
	  * @param pattern yyyy-MM-dd HH:mm:ss
	  * @param field 偏移字段 eg:Calendar.MINUTE
	  * @param amount 偏移数
	  * @return
	  */
	 public static Date getOffSetCurrentDate(String pattern,int field,int amount){
		 SimpleDateFormat formatter = new SimpleDateFormat(pattern);   
		 Calendar cal = Calendar.getInstance();
		 //设置偏移时间
		 cal.add(field, amount);
		 //获取偏移时间
		 Date date = cal.getTime();
		 String dateString = formatter.format(date);
		 try {
			date= formatter.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	 }
	 
	 /**
	  * 获取当前系统的偏移时间
	  * @param pattern yyyy-MM-dd HH:mm:ss
	  * @param field 偏移字段 eg:Calendar.MINUTE
	  * @param amount 偏移数
	  * @return
	  */
	 public static Timestamp getOffSetCurrentTimeStamp(String pattern,int field,int amount){
		 SimpleDateFormat formatter = new SimpleDateFormat(pattern);   
		 Calendar cal = Calendar.getInstance();
		 //设置偏移时间
		 cal.add(field, amount);
		 //获取偏移时间
		 Date date = cal.getTime();
		 String dateString = formatter.format(date);
		 return Timestamp.valueOf(dateString);
	 }
	 
	 public static List<String> getDateStringBeforeMonth(Integer month){
		List<String> list = new ArrayList<String>();
		for(int i=month;i>0;i--) {
		    Calendar calendar=Calendar.getInstance();//默认是当前日期
			calendar.add(Calendar.MONTH, -i);
			SimpleDateFormat sf = new SimpleDateFormat("yyyyMM");
	        list.add(sf.format(calendar.getTime()));
		}
		return list;
	 }
	 
	 /**
	  * 获取几分钟前的时间
	  * @param minute
	  * @return
	  */
	 public static String getLastMinuteTime(int minute){
		 Calendar c = Calendar.getInstance(); 
		 c.add(Calendar.MINUTE, -minute);
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String minuteTime = formatter.format(c.getTime());
		 return minuteTime;
	 }
	 
	 public static Timestamp convertUnixTimestampToDate(long uninxTimestamp,String pattern){
//		 String date = new java.text.SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new java.util.Date(Unix timestamp * 1000))
		 Date date = new Date(uninxTimestamp*1000);
		 DateFormat sdf = null;
		 if(StringUtils.isEmpty(pattern)){
			 sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 }else{
			 sdf = new SimpleDateFormat(pattern);
		 }
		 return Timestamp.valueOf(sdf.format(date));
		 
	 }
	 
	 public static void main(String[] args) throws Exception{
		// Date date= getDateOfEndTime("2014-02-16", "yyyy-MM-dd");
		 
		 System.out.println(getLastMinuteTime(10));
	 }
}