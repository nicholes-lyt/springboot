package com.base.common.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

/**
 * 日期工具类
 * 
 * @author liyut
 * 
 */
public class DateUtil {

	private final static Logger logger = Logger.getLogger(DateUtil.class);

	/**
	 * 中文x年x月x日
	 */
	public static final String CN_yyyyMMdd = "yyyy年MM月dd日";
	/**
	 * 中文x年x月x日 x时x分x秒
	 */
	public static final String HHmm = "HH:mm";
	public static final String CN_yyyyMMddHHmmss = "yyyy年MM月dd日 HH时mm分ss秒";
	public static final String CN_yyyyMMddHHmm = "yyyy年MM月dd日 HH时mm分";
	public static final String CN_MMDD = "MM月dd号";
	public static final String HHmmss = "HH:mm:ss";
	public static final String yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 格式 20140206081013 yyyyMMddHHmmss
	 */
	public static final String yyyy_MM_dd_HH_mm_ss = "yyyyMMddHHmmss";
	/**
	 * 格式 201402060810 yyyyMMddHHmm
	 */
	public static final String yyyy_MM_dd_HH_mm = "yyyyMMddHHmm";
	/**
	 * 格式 2014020608 yyyyMMddHH
	 */
	public static final String yyyy_MM_dd_HH = "yyyyMMddHH";
	/**
	 * 格式 20140206 yyyyMMdd
	 */
	public static final String yyyy_MM_dd = "yyyyMMdd";
	/**
	 * 格式 2014/2/6 8:00
	 */
	public static final String yyyy_MM_ddHHmm = "yyyy/MM/dd HH:mm";

	/**
	 * 格式 2014/2/6 8:00:00
	 */
	public static final String yyyy_MM_ddHHmmss = "yyyy/MM/dd HH:mm:ss";

	/**
	 * 格式 2014/2/6
	 */
	public static final String yyyy_MM_dd_ = "yyyy/MM/dd";
	/**
	 * yyyyMMdd HH:mm
	 */
	public static final String yyyy_MM_dd_HHmm = "yyyyMMdd HH:mm";
	public static final String yyyyMMddHHmm = "yyyy-MM-dd HH:mm";
	public static final String yyMMddHHmmss = "yy-MM-dd HH:mm:ss";
	public static final String yyMMddHHmm = "yy-MM-dd HH:mm";
	public static final String YYYY = "YYYY";
	public static final String MMDD = "MM-dd";
	public static final String MMDDsprit = "MM/dd";
	public static final String MMddspritHHmm = "MM/dd HH:mm";
	public static final String yyyyMMddSprit = "yyyy/MM/dd";
	public static final String yyMM = "yy-MM";
	public static final String yyyyMM = "yyyy-MM";
	public static final String yyMMdd = "yy-MM-dd";
	public static final String yyyyMMdd = "yyyy-MM-dd";
	public static final String MM = "MM";
	public static final String DD = "dd";
	public static final String HH = "HH";

	public static Date parseToDate(String s, String style)
			throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		simpleDateFormat.applyPattern(style);
		Date date = null;
		if (s == null || s.length() < 8) {
			return null;
		}
		date = simpleDateFormat.parse(s);
		return date;
	}

	public static Date parseToDateMM(String s, String style) {
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
			simpleDateFormat.applyPattern(style);
			Date date = null;
			if (s == null) {
				return null;
			}
			date = simpleDateFormat.parse(s);
			return date;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String parseToString(String s, String style)
			throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		simpleDateFormat.applyPattern(style);
		Date date = null;
		String str = null;
		if (s == null || s.length() < 8) {
			return null;
		}
		date = simpleDateFormat.parse(s);
		str = simpleDateFormat.format(date);

		return str;
	}

	public static String parseToDateString(String s, String style)
			throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		simpleDateFormat.applyPattern(style);
		Date date = null;
		String str = null;
		if (s == null || s.length() < 8) {
			return null;
		}
		date = simpleDateFormat.parse(s);
		str = simpleDateFormat.format(date);
		return str;
	}

	public static String parseToString(Date date, String style) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		simpleDateFormat.applyPattern(style);
		String str = null;
		if (date == null) {
			return null;
		}
		str = simpleDateFormat.format(date);
		return str;
	}

	public static String getNowTime() {
		Calendar now = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(yyyyMMddHHmmss);
		String str = formatter.format(now.getTime());
		return str;
	}

	public static String getTimeInMillis(Date startDate, Date endDate) {
		long thedaymillis = endDate.getTime() - startDate.getTime();
		return thedaymillis >= 1000 ? thedaymillis / 1000 + "秒！" : thedaymillis
				+ "毫秒！";
	}

	// 比较两个时间的大小
	public static int compare_dateString(String time1, String time2) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			java.util.Date d1 = df.parse(time1);
			java.util.Date d2 = df.parse(time2);
			if (d1.getTime() > d2.getTime()) {
				return 1;
			} else if (d1.getTime() < d2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	// 比较两个时间的大小
	public static int compare_date(Date d1, Date d2) {
		try {
			if (d1.getTime() > d2.getTime()) {
				return 1;
			} else if (d1.getTime() < d2.getTime()) {
				return -1;
			} else {
				return 0;
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return 0;
	}

	/**
	 * 
	 * @Description: 根据日期Calendar.get dayofweek获取星期几
	 * @author nicholes
	 * @version 1.0
	 * @date 2014-3-25 下午4:05:01
	 * @param day
	 * @return
	 * @return String
	 */
	public static String getWeekCN(int day) {
		String week = "星期";
		switch (day) {
		case 2:
			week += "一";
			break;
		case 3:
			week += "二";
			break;
		case 4:
			week += "三";
			break;
		case 5:
			week += "四";
			break;
		case 6:
			week += "五";
			break;
		case 7:
			week += "六";
			break;
		case 1:
			week += "日";
			break;
		}
		return week;
	}

	/**
	 * 
	 * @Description: 根据日期Calendar.get getWeekZJ获取星期几
	 * @author nicholes
	 * @version 1.0
	 * @date 2014-3-25 下午4:05:01
	 * @param day
	 * @return
	 * @return String
	 */
	public static String getWeekZJ(int day) {
		String week = "周";
		switch (day) {
		case 2:
			week += "一";
			break;
		case 3:
			week += "二";
			break;
		case 4:
			week += "三";
			break;
		case 5:
			week += "四";
			break;
		case 6:
			week += "五";
			break;
		case 7:
			week += "六";
			break;
		case 1:
			week += "日";
			break;
		}
		return week;
	}

	/**
	 * @Description: 获取本周列表
	 * @author nicholes
	 * @version 1.0
	 * @date 2014-5-14 下午5:58:23
	 * @return
	 * @return List<Date>
	 */
	public static List<Date> getCurrentDayWeekList(Date today) {
		List<Date> list = new ArrayList<Date>();
		Calendar cal = Calendar.getInstance();
		if (today != null) {
			cal.setTime(today);
		}
		int day = cal.get(Calendar.DAY_OF_WEEK);// 获取当天周did
		try {
			for (int i = day - 1; i > 0; i--) {// 前半部日期
				Calendar nextcal = (Calendar) BeanUtils.cloneBean(cal);
				nextcal.add(Calendar.DAY_OF_MONTH, -i);
				list.add(nextcal.getTime());
			}
			for (int i = 0; i <= 7 - day; i++) {// 后半部日期
				Calendar nextcal = (Calendar) BeanUtils.cloneBean(cal);
				nextcal.add(Calendar.DAY_OF_MONTH, i);
				list.add(nextcal.getTime());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @Description: 显示执行时间
	 * @author nicholes
	 * @version 1.0
	 * @date 2015-2-7 下午3:03:19
	 * @param time
	 * @return
	 * @return String
	 */
	public static String showExecuteTime(Date startTime) {
		long millis = new Date().getTime() - startTime.getTime();
		return millis > 1000 ? (millis / 1000) + "秒！" : millis + "毫秒";
	}

	/**
	 * 
	 * @Description:获取日期前后相差天数
	 * @author nicholes
	 * @version 1.0
	 * @date 2015-3-4 下午6:26:22
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @return long
	 */
	public static long getDateMargin(Date beginDate, Date endDate) {
		long margin = 0;
		margin = endDate.getTime() - beginDate.getTime();
		margin = margin / (1000 * 60 * 60 * 24);
		return margin;
	}

	public static List<Date> getDateList(Date beginDate, Date endDate) {
		int marg = (int) getDateMargin(beginDate, endDate);
		List<Date> list = new ArrayList<Date>();
		for (int i = -marg; i < 0; i++) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(endDate);
			cal.add(Calendar.DAY_OF_MONTH, i);
			list.add(cal.getTime());
		}
		return list;
	}

	public static Date getDtime(Date date, int day) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(cal.DATE, cal.get(cal.DATE) + day);
		return cal.getTime();
	}

	/**
	 * 获取当月第一天
	 * 
	 * @return
	 */
	public static Date getMonthFirstDay() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		return c.getTime();
	}

	/**
	 * 获取当月最后一天
	 * 
	 * @return
	 */
	public static Date getMonthLastDay() {
		// 获取当前月最后一天
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	// 获取当前时间所在年的周数
	public static int getWeekOfYear(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setMinimalDaysInFirstWeek(7);
		c.setTime(date);

		return c.get(Calendar.WEEK_OF_YEAR);
	}

	// 获取当前时间所在年的最大周数
	public static int getMaxWeekNumOfYear(int year) {
		Calendar c = new GregorianCalendar();
		c.set(year, Calendar.DECEMBER, 31, 23, 59, 59);

		return getWeekOfYear(c.getTime());
	}

	public static void main(String[] args) throws ParseException {
		/*
		 * Calendar cal=Calendar.getInstance(); for (int i = 1; i < 11; i++) {
		 * cal.add(Calendar.MONTH, -1);
		 * System.out.println(DateUtil.parseToString(cal.getTime(),
		 * DateUtil.yyyyMMddHHmm)); }
		 */
		// Date beginDate = DateUtil.parseToDate("2015-09-01", yyyyMMdd);
		// Date endDate = DateUtil.parseToDate("2015-10-01", yyyyMMdd);
		// List<Date> list = getDateList(beginDate, endDate);
		// for(Date date : list){
		// System.out.println(date.toString());
		// }
		logger.info("日期格式化："+DateUtil.parseToString(getMonthLastDay(),
				DateUtil.yyyyMMdd));
	}
}
