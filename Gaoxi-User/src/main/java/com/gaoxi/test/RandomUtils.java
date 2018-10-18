package com.gaoxi.Test;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


/**
 * 随机数工具类
 *
 *
 */
public class RandomUtils {
	private static String allChar = "abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
	private static String letterChar = "abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static String numberChar = "0123456789";
	private static String allCharNL = "ABCDEFGHJXYZ123456789";
	/**
	 * 获取 时间字符串 + 随机的字符串(包含大小写字母和数字)
	 * @param length 出去时间以外的字符串长度，dateFormat 时间格式(默认为yyyyMMddHHmmssSSSS)
	 * @return
	 */
	public static String getRandomStringWithTime(int length,String dateFormat) {
		if (StringUtil.isEmpty(dateFormat)) {
			dateFormat ="yyyyMMddHHmmssSSSS";
		}
		Date date = new Date();
		DateFormat df = new SimpleDateFormat(dateFormat);
		return df.format(date) + getRandomString(length);
	}

	public static String getRandomStringWithTime(Date date, int length) {
		String dateFormat ="yyyyMMddHHmmss";
//		String dateFormat ="yyyyMMddHHmmssSSSS";
		DateFormat df = new SimpleDateFormat(dateFormat);
		return df.format(date) + getRandomString(length);
	}

	/**
	 * 获取 时间字符串 + 随机的字符串(包含大小写字母和数字)
	 * @param length 出去时间以外的字符串长度，dateFormat 时间格式(默认为yyyyMMddHHmmssSSSS)
	 * @return
	 */
	public static String getRandomNumberStringWithTime(int length,String dateFormat) {
		if (StringUtil.isEmpty(dateFormat)) {
			dateFormat ="yyyyMMddHHmmssSSSS";
		}
		Date date = new Date();
		DateFormat df = new SimpleDateFormat(dateFormat);
		return df.format(date) + getRandomNumberString(length);
	}

	/**
	 * 获取 时间字符串 + 随机的字符串(包含大小写字母和数字)
	 * @param length 出去时间以外的字符串长度，dateFormat 时间格式(默认为yyyyMMddHHmmssSSSS)
	 * @return
	 */
	public static String getRandomNumberStringWith6Time() {
		
		String dateFormat ="yyyyMMddHHmmssSSSS";
		Date date = new Date();
		DateFormat df = new SimpleDateFormat(dateFormat);
		return df.format(date) + getRandomNumberString(6);
	}

	
	/**
	 * 获取随机的字符串(包含大小写字母和数字)
	 * @param length 字符串长度
	 * @return
	 */
	public static String getRandomString(int length) {
		return getString(length,allChar);
	}
	
	/**
	 * 获取随机的字符串(包含大小写字母和数字)
	 * @param length 字符串长度
	 * @return
	 */
	public static String getRandomStringNL(int length) {
		return getString(length,allCharNL);
	}
	
	/**
	 * 获取随机的字符串(只包含数字)
	 * @param length 字符串长度
	 * @return
	 */
	public static String getRandomNumberString(int length) {
		return getString(length,numberChar);
	}
	
	/**
	 * 获取随机的字符串(只包含大小写字母)
	 * @param length 字符串长度
	 * @return
	 */
	public static String getRandomLetterString(int length) {
		return getString(length,letterChar);
	}
	
	private static String getString(int length,String str) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for(int i = 0 ; i < length ; i++) {
			sb.append(str.charAt(random.nextInt(str.length())));
		}
		return sb.toString();
	}
	
	//获取最大值
	public static Integer getMaxNum(List<Integer> numList) {
		Integer maxNum = numList.get(0);
		for (Integer num : numList) {
			if(num > maxNum){
				maxNum = num;
			}
		}
		return maxNum;
	}
	
	//获取最小值
	public static Integer getMinNum(List<Integer> numList) {
		Integer minNum = numList.get(0);
		for (Integer num : numList) {
			if(num < minNum){
				minNum = num;
			}
		}
		return minNum;
	}
	
	//获取不重复随机数  参数1. 随机数最大值  2.几个随机数
	public static Integer getRandomNum(Integer min,Integer max, Integer num) {
		Random rand = new Random();
		boolean[] bool = new boolean[max + 1] ;
		int randInt = 0;

		for (int i = 0; i < num; i++) {
			do {
				randInt = rand.nextInt(max - min + 1) + min ;
			} while (bool[randInt]);
			bool[randInt] = true;
		}
		return randInt;
	}
	
	//获取不重复随机数  参数1. 随机数最大值  2.几个随机数
	public static List<Integer> getRandomNumList(Integer min,Integer max, Integer num) {
		List<Integer> randomNumList = new ArrayList<Integer>();
		Random rand = new Random();
		boolean[] bool = new boolean[max + 1] ;
		int randInt = 0;

		for (int i = 0; i < num; i++) {
			do {
				randInt = rand.nextInt(max - min + 1) + min ;
			} while (bool[randInt]);
			bool[randInt] = true;
			randomNumList.add(randInt);
		}
		return randomNumList;
	}
	
	//获取重复随机数  参数1. 随机数最大值  2.几个随机数
	public static List<Integer> getRepetitionNumList(Integer min,Integer max, Integer num) {
		List<Integer> randomNumList = new ArrayList<Integer>();
		Random rand = new Random();
		int randInt = 0;

		for (int i = 0; i < num; i++) {
			randInt = rand.nextInt(max - min + 1) + min ;
			randomNumList.add(randInt);
		}
		return randomNumList;
	}
	
	public static void main(String[] args) {
		//System.err.println(RandomUtils.getRandomString(6).toUpperCase());	
		//System.err.println(RandomUtils.getRandomNumberStringWithTime(6,"yyyyMMddHHmmss"));	
		/*for(int i =0;i<1000;i++){
			List<Integer> randomNumList = RandomUtils.getRandomNumList(1,7,1);
			for (Integer integer : randomNumList) {
				System.out.println(integer);
			}
			
		}*/
	
		/*List<Integer> randomNumList = RandomUtils.getRandomNumList(1,6,7);
		for (Integer integer : randomNumList) {
			System.out.println(integer);
		}*/
		//System.out.println(getMaxNum(randomNumList));
		
		
		Random rand = new Random();
		/*for(int i =0 ;i<1000;i++){
			System.out.println(getRepetitionNumList(6,9,3));
		}*/
		System.out.println(getRandomStringWithTime(new Date(),6));
		
	}
}
