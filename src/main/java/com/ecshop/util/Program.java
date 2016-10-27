package com.ecshop.util;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Program {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 提交的数据
		String content = "您好，您的修改手机验证码是：888888；有任何疑问可以拨打我们的客服电话 4009660160";
//		String pstContent = createSubmitXml("13400573376", content, "短信验证码");
		String ret = post("13400573376", content, "短信验证码", "");
		System.out.print(ret);
		System.out.print("\nexec end!");
	}
	
	/**
	 * @Title: post
	 * @Description:TODO 发送短信接口
	 * @author zhouy 2015-6-11 下午05:11:12
	 * @param mobile 手机号码，多个号码英文逗号隔开最多不要超过50个
	 * @param content 短信内容
	 * @param serType 短信类型
	 * @param sendtime 发送时间，空为立即发送，日期格式：YYYY-MM-dd HH:mm:SS
	 * @return String 返回类型
	 */
	public static String post(String mobile, String content, String serType, String sendtime){
		// 提交的url地址，这个要修改成部署的对应的接口的url
		String uri = "http://userinterface.vcomcn.com/Opration.aspx";
		// 提交的数据
		String pstContent = "";
		int smsNum = mobile.indexOf(",");
		if (smsNum == -1) {
			pstContent = createSubmitXml(mobile, content, serType, sendtime);
		} else {
			pstContent = createMultiSubmitXml(mobile, content, serType, sendtime);
		}
		String ret = Http.post(uri, pstContent);
		return ret;
	}

	public static String MD5(String encryptContent) {
		String result = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(encryptContent.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			result = buf.toString().toUpperCase();
		} catch (NoSuchAlgorithmException e) {
		}
		return result;
	}

	/**
	 * @Title: createSubmitXml
	 * @Description:TODO 发送单个手机号码
	 * @author zhouy 2015-6-11 下午05:06:03
	 * @param phone 手机号码
	 * @param content 短信内容
	 * @param serType 短信类型
	 * @param sendtime 发送时间
	 * @return String 返回类型
	 */
	public static String createSubmitXml(String phone, String content, String serType, String sendtime) {
		StringBuffer sp = new StringBuffer();
		sp.append(String.format("<Group Login_Name=\"%s\" Login_Pwd=\"%s\" InterFaceID=\"\" OpKind=\"0\" SerType=\"%s\">", "账号", MD5("密码"), serType));
		sp.append(String.format("<E_Time>%s</E_Time>", sendtime));
		sp.append("<Item>");
		sp.append("<Task>");
		sp.append(String.format("<Recive_Phone_Number>%s</Recive_Phone_Number>", phone));
		sp.append(String.format("<Content><![CDATA[%s]]></Content>", content));
		sp.append("<Search_ID>1</Search_ID>");
		sp.append("</Task>");
		sp.append("</Item>");
		sp.append("</Group>");
		return sp.toString();
	}
	
	/**
	 * @Title: createMultiSubmitXml
	 * @Description:TODO 发送多个手机号码
	 * @author zhouy 2015-6-11 下午05:06:03
	 * @param mobile 手机号码，多个号码英文逗号隔开最多不要超过50个
	 * @param content 短信内容
	 * @param serType 短信类型
	 * @param sendtime 发送时间
	 * @return String 返回类型
	 */
	public static String createMultiSubmitXml(String mobile, String content, String serType, String sendtime) {
		StringBuffer sp = new StringBuffer();
		sp.append(String.format("<Group Login_Name=\"%s\" Login_Pwd=\"%s\" InterFaceID=\"\" OpKind=\"51\" SerType=\"%s\">", "fjwys", MD5("ab8888"), serType));
		sp.append(String.format("<E_Time>%s</E_Time>", sendtime));
		sp.append(String.format("<Mobile>%s</Mobile>", mobile));
		sp.append(String.format("<Content><![CDATA[%s]]></Content>", content));
		sp.append("<ClientID>1</ClientID>");
		sp.append("</Group>");
		return sp.toString();
	}
	
	@SuppressWarnings("static-access")
	public static String createSubmitXml() {
		Date now = new Date();
		// 2008-6-16 20:54:53
//		DateFormat dtFormat = DateFormat.getDateInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(now);
		calendar.add(calendar.MINUTE, 1);
		now = calendar.getTime();
		String sendtime = sdf.format(now);
		// String sendtime = dtFormat.format(now);
		
		System.out.println(sendtime);
		StringBuffer sp = new StringBuffer();
		sp
		.append(String
				.format(
						"<Group Login_Name=\"%s\" Login_Pwd=\"%s\" InterFaceID=\"\" OpKind=\"0\" SerType=\"短信类型\">",
						"fjwys", MD5("ab8888")));
		sp.append(String.format("<E_Time></E_Time>"));
		// sp.append(String.format("<E_Time>%s</E_Time>", sendtime));
		sp.append("<Item>");
		
		sp.append("<Task>");
		sp.append("<Recive_Phone_Number>13400573376</Recive_Phone_Number>");
		// sp.append("<Content><![CDATA[888888   40010025232]]></Content>");
		sp
		.append("<Content><![CDATA[您好，您的修改绑定手机验证码是：888888；有任何疑问可以拨打我们的客服电话 4009660160]]></Content>");
		// sp.append("<Content><![CDATA[【威翼视联网】您好，您的修改手机验证码是：123456；有任何疑问可以拨打我们的客服电话 40010025232]]></Content>");
		sp.append("<Search_ID>1</Search_ID>");
		sp.append("</Task>");
		
		/*
		 * sp.append("<Task>");
		 * sp.append("<Recive_Phone_Number>18059135112</Recive_Phone_Number>");
		 * sp.append("<Content><![CDATA[测试短信1002]]></Content>");
		 * sp.append("<Search_ID>1</Search_ID>"); sp.append("</Task>");
		 */
		sp.append("</Item>");
		sp.append("</Group>");
		
		System.out.println(sp.toString());
		return sp.toString();
	}
}
