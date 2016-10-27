package com.ecshop.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

public final class CollectionUtils {
	
	@SuppressWarnings("unchecked")
	public static boolean isBlank(Map map) {
		if(map == null || map.size() == 0) 
			return true;
		else return false;
	}
	
	@SuppressWarnings("unchecked")
	public static boolean isNotBlank(Map map) {
		return !isBlank(map);
	}
	
	public static boolean isBlank(List<String> list) {
		if(list == null || list.size() == 0) 
			return true;
		else return false;
	}
	
	public static boolean isNotBlank(List<String> list) {
		return !isBlank(list);
	}
	
	
	/**
	 * 根据分页参数返回list的当前页的子集.
	 * @param pageList 待处理的list
	 * @param pageSize 每页的记录数
	 * @param page 当前页
	 * @return 子集
	 */
	public static List<String> pageList(List<String> pageList, int pageSize, int page) {
		int total = pageList.size();
		int start = (page - 1) * pageSize;
		int end = page * pageSize -1;
		if (total >= start) {
			if (end >= total) {
				pageList = pageList.subList(start, total);
			} else {
				pageList = pageList.subList(start, end + 1);
			}
		}
		return pageList;
	}

	/**
	 * 根据分页参数返回list的当前页的子集.
	 * @param pageList 待处理的list
	 * @param pageSize 每页的记录数
	 * @param page 当前页
	 * @return 子集
	 */
	@SuppressWarnings("unchecked")
	public static List pageObjectList(List pageList, int pageSize, int page) {
		int total = pageList.size();
		int start = (page - 1) * pageSize;
		int end = page * pageSize -1;
		if (total >= start) {
			if (end >= total) {
				pageList = pageList.subList(start, total);
			} else {
				pageList = pageList.subList(start, end + 1);
			}
		}
		return pageList;
	}
	
	public static int getTotalPage(int total,int pageSize) {
		int totalPage = 1;
		try {
			int count = total/pageSize;
			if(total%pageSize == 0){
				totalPage = count;
			}else {
				totalPage = count+1;
			}
		} catch (Exception e){
			
		}
		return totalPage;
	}
	
	/**
	 * 将List转换成以逗号隔开的字符串(带引号)
	 * @param list
	 * @return
	 */
	public static String toCsvs(List<String> list) {
		if(list==null||list.size()==0){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for (String item : list) {
			sb.append("'").append(item).append("'").append(",");
		}
		if(sb.length()>1){
			sb=sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}
	
	/**
	 * 将List转换成以逗号隔开的字符串
	 * @param list
	 * @param splitTip
	 * @return
	 */
	public static String toString(List<String> list,String splitTip) {
		if(list==null||list.size()==0){
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for (String item : list) {
			sb.append(item).append(",");
		}
		if(sb.length()>1){
			sb=sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}
	
	public static List<String> toList(String values,String splitTip) {
		List<String> list = new ArrayList<String>();
		if(StringUtils.isBlank(values)) {
			return list;
		}
		String[] tmpValues = StringUtils.split(values,splitTip);
		for(String value:tmpValues) {
			list.add(value);
		}
		return list;
	}
	
	public static Map<String, Object> sortMap(Map<String, Object> map) {
		Map<String, Object> result = new LinkedHashMap<String, Object>();
		Map<Object, String> sortMap = new TreeMap<Object, String>();
		List<String> keys = new ArrayList<String>();
		List<Object> values = new ArrayList<Object>();
		for (Entry<String, Object> entry : map.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if(!sortMap.containsKey(value)) {
				sortMap.put(value, key);
			} else {
				keys.add(key);
				values.add(value);
			}
		}
 		for(Entry<Object, String> entry : sortMap.entrySet()) {
 			Object key = entry.getKey();
 			String value = entry.getValue();
 			result.put(value, key);
 			int index = values.indexOf(key);
 			while(index > -1) {
 				result.put(keys.get(index), values.get(index));
 				keys.remove(index);
 				values.remove(index);
 				index = values.indexOf(key);
 			}
 		}
		return result;
		
	}
	
	public static List<String> sortList(Map<String, Object> map) {
		List<String> result = new ArrayList<String>();
		Map<Object, String> sortMap = new TreeMap<Object, String>();
		List<String> keys = new ArrayList<String>();
		List<Object> values = new ArrayList<Object>();
		for (Entry<String, Object> entry : map.entrySet()) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if(!sortMap.containsKey(value)) {
				sortMap.put(value, key);
			} else {
				keys.add(key);
				values.add(value);
			}
		}
 		for(Entry<Object, String> entry : sortMap.entrySet()) {
 			Object key = entry.getKey();
 			String value = entry.getValue();
 			result.add(value);
 			int index = values.indexOf(key);
 			while(index > -1) {
 				result.add(keys.get(index));
 				keys.remove(index);
 				values.remove(index);
 				index = values.indexOf(key);
 			}
 		}
		return result;
		
	}
	
	@SuppressWarnings("unchecked")
	public static List<String> getKeys(Map map) {
		List<String> list = new ArrayList<String>();
		if(map == null) {
			return list; 
		}
		for(Object o:map.keySet()) {
			list.add((String) o);
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static List<String> getValues(Map map) {
		List<String> list = new ArrayList<String>();
		if(map == null) {
			return list; 
		}
		for(Object o:map.values()) {
			list.add((String) o);
		}
		return list;
	}
	
	
	public static List<String> BMoreToA(List<String> a, List<String> b) {
        List<String> temp = new ArrayList<String>();
        for (int i = 0; i < b.size(); i++) {
            boolean flag = false;
            for (int j = 0; j < a.size(); j++) {
                if (b.get(i).equals(a.get(j))) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
            if (!flag) {
                temp.add(b.get(i));
            }
        }
        return temp;
    }
	
	/**
	 * 原数组与新数组对比，返回哪些为新增，哪些要被删除
	 * @param oldList
	 * @param newList
	 * @return map。addList：新增      delList：删除
	 */
	public static Map<String,List<String>> compareList(List<String> oldList,List<String> newList) {
		Map<String,List<String>> map = new HashMap<String, List<String>>();
		List<String> adds = new ArrayList<String>();
		List<String> dels = new ArrayList<String>();
		if(oldList == null && newList == null) {//old、new均为空，则无新增、无删除
			map.put("addList", adds);
			map.put("delList", dels);
			return map;
		} else if(oldList == null) {//old为空，则所有都是新增、无删除
			map.put("addList", newList);
			map.put("delList", dels);
			return map;
		} else if(newList == null) {//new为空，则所有都是删除，无新增
			map.put("addList", adds);
			map.put("delList", oldList);
			return map;
		}
		//遍历old，判断new中是否包含，如无包含，则代表该对象要被删除
		for(String str:oldList) {
			if(!newList.contains(str)) {
				dels.add(str);
			}
		}
		//遍历new，判断old是否包含，如无包含，则代表该对象为新增对象
		for(String str:newList) {
			if(!oldList.contains(str)) {
				adds.add(str);
			}
		}
		map.put("addList", adds);
		map.put("delList", dels);
		return map;
	}
	
	
	public static void main(String[] args){
		/*List<String> oldList = new ArrayList<String>();
		List<String> newList = new ArrayList<String>();
		
		oldList.add("1");oldList.add("2");oldList.add("3");oldList.add("4");
		newList.add("3");newList.add("4");newList.add("5");newList.add("6");
		
		Map<String,List<String>> map = compareList(oldList,newList);
		
		
		List<String> addList = (List<String>) map.get("addList");
		for(String a :addList){
			System.out.println(a);
		}
		System.out.println("+++++++++++++++++++++++++");
		List<String> delList = (List<String>) map.get("delList");
		for(String d :delList){
			System.out.println(d);
		}*/
		
		String test = "2,3,4";
		List<String> list = CollectionUtils.toList(test,",");
		System.out.println();
	}
	
}
