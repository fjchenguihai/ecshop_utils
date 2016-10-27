package com.ecshop.util;

import org.apache.commons.lang.StringUtils;

/**
 * 根据 user agent string 来判断出客户端的浏览器以及平台等信息 
 * @Description TODO
 * @author jerry
 * @date 2015-11-18下午08:07:52
 *
 */
public class UserAgentUtil {
	
	public static boolean isWeChatClient(String userAgentString){
		boolean flag =false;
		//UserAgent userAgent = UserAgent.parseUserAgentString(userAgentString);
		//Mozilla/5.0 (Linux; U; Android 4.4.2; zh-cn; PE-TL10 Build/HuaweiPE-TL10) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 
		//MQQBrowser/5.4 TBS/025478 Mobile Safari/533.1 MicroMessenger/6.3.5.50_r1573191.640 NetType/WIFI Language/zh_CN
		if(!StringUtils.isEmpty(userAgentString) && userAgentString.indexOf("MicroMessenger")>0){
			flag=true;
		}
		return flag; 
	}
}
