package com.ecshop.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ScheduleUtil {
	
	/**
	 * 当前时间与调度时间点之间的相差毫秒数
	 * @param initPattern 调度时间点模式，如：'yyyy-MM-12 02:00','yyyy-MM-dd 01:00'
	 * @param intvalPattern 两个调度之间频度单位，取值为Calendar中的静态字段
	 * @param intval 两个调度之间频度值 
	 * @return 调度时间点之间的相差毫秒数
	 */
	public static long scheduleIntval(String initPattern,int intvalPattern,int intval){
		long hs = 0l;
		try{
			Date curTime = Calendar.getInstance().getTime();
			SimpleDateFormat f = new SimpleDateFormat(initPattern);
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date initTime = sf.parse(f.format(curTime));
			if(curTime.after(initTime)){
				Calendar cal = Calendar.getInstance();
				cal.add(intvalPattern, intval);
				initTime = sf.parse(f.format(cal.getTime()));
			}
			
			hs = initTime.getTime() - curTime.getTime();
		}catch(Exception e){
			e.printStackTrace();
		}
		return hs;
	}
}
