


package com.ecshop.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 作用描述
 *  util for beans
 */
public final class BeanUtil {
	
	/**
	 * 比较两个bean的字段， 返回不同的字段及内容
	 * 格式为： {field:"fieldName",oldValue:"1",newValue:"2"}
	 * @param src  修改前对象
	 * @param dest  修改后对象
	 * @return
	 */
	public static List<Map<String, Object>> compareProperties(Object src, Object dest) {
		List<Map<String, Object>> retList = new ArrayList<Map<String, Object>>();
		
		if (src == null || dest == null) {
			return retList;
		}
		
		Class<?> classSrc  = src.getClass();
		Class<?> classDest = dest.getClass();
		
		Field[] destFields = classDest.getDeclaredFields();
		
		for (Field destField : destFields) {
			String name = destField.getName();
			Field srcField = null;
			Object oldValue = null;
			Object newValue = null;
			
			// 反射取新值
			try {
				destField.setAccessible(true);
				newValue = destField.get(dest);
			} catch (Exception e) {
				// just ignore it;
				continue;
			}
			
			// 反射取旧值
			try {
				srcField = classSrc.getDeclaredField(name);
				if (srcField != null) {
					srcField.setAccessible(true);
					oldValue = srcField.get(src);
				}
				
				// 两个对象都有的字段， 才记录修改信息
				if (!String.valueOf(newValue).equals(String.valueOf(oldValue))) {
					Map<String, Object> map = new HashMap<String, Object>();
					map.put("fieldName", name);
					map.put("oldValue", oldValue);
					map.put("newValue", newValue);
					retList.add(map);
				}
				
			} catch (Exception e1) {
				// just ignore it;
			}
		}
		
		return retList;
	}
	
	/**
	 * 复制bean的字段值
	 * @param src  源对象
	 * @param dest 目的对象
	 */
	public static void copyProperties(Object src, Object dest) {
		if (src == null || dest == null) {
			return;
		}
		
		Class<?> classSrc  = src.getClass();
		Class<?> classDest = dest.getClass();
		
		Field[] destFields = classDest.getDeclaredFields();
		//Field[] srcFields  = classSrc.getDeclaredFields();
		
		for (Field destField : destFields) {
			String name = destField.getName();
			Field srcField = null;
			
			try {
				srcField = classSrc.getDeclaredField(name);
			} catch (Exception e2) {
				continue;
			}
			
			if (srcField != null) {
				srcField.setAccessible(true);
				destField.setAccessible(true);
				
				Object val = null;
				
				try {
					val = srcField.get(src);
				} catch (Exception e1) {
					//e1.printStackTrace();
				}
				
				
				if (val != null) {
					try {
						destField.set(dest, srcField.get(src));
					} catch (Exception e) {
						//e.printStackTrace();
					}
				}
				
			}
		}
	}
}
