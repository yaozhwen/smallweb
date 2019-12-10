package com.yao.core.util;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by yaozwsq on 2019/12/5.
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils{
    private final static Log logger = LogFactory.getLog(DateUtils.class);

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    public static final String YYYY_MM_DD = "yyyyMMdd";
    public static final String HH_SS_MM = "HHssmm";
    public static final String YYYY_MM_DD_DEF = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyyMMddHHmmss";
    public static final String DATE_WEB_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_WEB_FORMAT_NO_SS = "yyyy-MM-dd HH:mm";
    public static final String E_MMM_DD_HH_MM_SS_Z_YYYY = "E MMM dd hh:mm:ss z yyyy";//日期格式 "Tue Sep 26 13:56:19 CST 2017"
    public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyyMMddHHmmssSSS";

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern(YYYY_MM_DD_HH_MM_SS);
        Date date = format.parse("20161223161000");
        format.applyPattern(DATE_WEB_FORMAT);
        System.out.println(format.format(date));
    }

    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }



    public static String formatDate(Date date, Object... pattern) {
        if (date == null)
            return null;

        String formatDate;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date parseDateTime(String ds) {
        try {
            return parseDate(ds, "yyyy-MM-dd HH:mm:ss");
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date getTimeOfY0(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return  cal.getTime();
    }

    public static Date getTimeOfM0(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return  cal.getTime();
    }

    public static Date getTimeOfD0(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return  cal.getTime();
    }

    public static Date getTimeOfH0(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return  cal.getTime();
    }

    public static Date getFirstTimeOfMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH,
                cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return  cal.getTime();
    }

    public static Date getLastTimeOfMonth(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH,
                cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return  cal.getTime();
    }

    /*是否为指定月份的最后一天*/
    public static boolean isLastDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DATE, (calendar.get(Calendar.DATE) + 1));
        if (calendar.get(Calendar.DAY_OF_MONTH) == 1) {
            return true;
        }
        return false;
    }

    public static Date getDateNoSSS(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.MILLISECOND, 0);
        return  cal.getTime();
    }

    /*是否为本月第一天*/
    public static boolean isFirstDayOfThisMonth(Date date) {
        if(date==null){
            return false;
        }
        String now = formatDate(date,"yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH,1);
        Date firstDate = calendar.getTime();
        String first = formatDate(firstDate,"yyyy-MM-dd");

        if(now.equals(first)){
            return true;
        }else {
            return false;
        }
    }

    public static String getYearAndMonth(Date date){
        String ym = formatDate(date,"yyyy-MM");
        return ym;
    }

    public static String getYMD(Date date){
        String ym = formatDate(date,"yyyy-MM-dd");
        return ym;
    }

    public static String getTime() {
        return formatDate(new Date(), "HH:mm:ss");
    }

    public static String getDateTime() {
        return formatDate(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    public static String getYear() {
        return formatDate(new Date(), "yyyy");
    }

    public static String getMonth() {
        return formatDate(new Date(), "MM");
    }

    public static String getDay() {
        return formatDate(new Date(), "dd");
    }

    public static String getHour(Date date) {
        return formatDate(date, "HH");
    }

    public static String getWeek() {
        return formatDate(new Date(), "E");
    }
    public static String getWeekByParam(Date date) {
        return formatDate(date, "E");
    }

    public static Date parseDate(Object str) {
        if (str == null){
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    public static long pastDays(Date date) {
        long t = new Date().getTime()-date.getTime();
        return t/(24*60*60*1000);
    }

    public static long pastHour(Date date) {
        long t = new Date().getTime()-date.getTime();
        return t/(60*60*1000);
    }

    public static long pastMinutes(Date date) {
        long t = new Date().getTime()-date.getTime();
        return t/(60*1000);
    }

    public static String formatDateTime(long timeMillis){
        long day = timeMillis/(24*60*60*1000);
        long hour = (timeMillis/(60*60*1000)-day*24);
        long min = ((timeMillis/(60*1000))-day*24*60-hour*60);
        long s = (timeMillis/1000-day*24*60*60-hour*60*60-min*60);
        long sss = (timeMillis-day*24*60*60*1000-hour*60*60*1000-min*60*1000-s*1000);
        return (day>0?day+",":"")+hour+":"+min+":"+s+"."+sss;
    }

    /**
     * 获取两个时间值 相隔天数
     * @param before
     * @param after
     * @return
     */
    public static long getDistanceOfTwoDate(Date before, Date after) throws ParseException {
        DateFormat df = new SimpleDateFormat(YYYY_MM_DD_DEF);
        before = df.parse(df.format(before));
        after = df.parse(df.format(after));
        long beforeTime = before.getTime();
        long afterTime = after.getTime();
        return (afterTime - beforeTime) / (1000 * 60 * 60 * 24);
    }

    /**
     *  日期大小比较
     * @param date1
     * @param date2
     * @return date2 == date1-->0
     * @return date2 > date1-->1
     * @return date2 < date1-->-1
     * @return -2 异常
     */
    public static int dateStringCompare(Date date1,String date2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM");
        try {
            Date dt1 = df.parse(date2);
            Date dt2 = df.parse(df.format(date1));
            if (dt1.getTime()>dt2.getTime()){
                return  1;
            }else if (dt1.getTime()== dt2.getTime()){
                return  0;
            }else {
                return  -1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  2;
    }

    /**
     * 取得当月天数
     * */
    public static int getCurrentMonthLastDay()
    {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.DATE, 1);
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }


    /**
     * 字符串转换成日期
     * @param str
     * @param formatType
     * @return
     */
    public static Date StrToDate(String str,String formatType) {

        SimpleDateFormat format = new SimpleDateFormat(formatType);
        Date date = null;
        try {
            //date = format.parse(new SimpleDateFormat(formatType).format(str));
            date = format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static List<String> getWeekend(Integer year){
        List<String> list = new ArrayList<String>();
        try{
            SimpleDateFormat df=new SimpleDateFormat("yyyy-mm-dd");
            Date date=null;
            Calendar calendar=Calendar.getInstance();
            int totalDay;
            if(year % 4 == 0 && year % 100 != 0 || year % 400 == 0){//闰年的判断规则
                totalDay=366;
            }else{
                totalDay=365;
            }
            date=df.parse(year+"-01-01");
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            for(int i=0;i<totalDay;i++){
                if(cal.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY||cal.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY) {
                    list.add(DateUtils.formatDate(cal.getTime(),"yyyy-MM-dd"));
                }
                cal.add(Calendar.DAY_OF_MONTH,1);
            }
        }catch(ParseException e){
            e.printStackTrace();
        }

        return list;
    }

    /**
     * 使用SimpleDateFormat类对时间字符串的合法性进行校验
     *
     * @param dateStr
     *            将要被校验合法性的时间字符串，格式：yyyyMMddHHmmss
     */
    public static Boolean checkLegalityInClassSimpleDateFormat(String dateStr,String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date realDate = sdf.parse(dateStr);
            if (dateStr.equals(sdf.format(realDate))) {
                return true;
            } else {
                return false;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 判断日期是否为周末
     *
     * @param date 入参日期
     * @return true：为周末
     */
    public static boolean isWeekend(Date date) {
        if (date == null)
            return false;

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY;
    }

    /*
	 * 计算时间差
	 */
    public static int getTwoDayTimes(String fromDate ,String toDate) {
        SimpleDateFormat simpleFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            long from = simpleFormat.parse(fromDate).getTime();
            long to = simpleFormat.parse(toDate).getTime();
            int seconds = (int) ((to - from)/(1000));
            return seconds;
        } catch (ParseException e) {
            e.printStackTrace();
            return -1;
        }
    }


    /**
     * 计算时间差
     * @param fromDate
     * @param toDate
     * @return
     */
    public static int getTwoDayTimes(Date fromDate ,Date toDate) {
        long from = fromDate.getTime();
        long to = toDate.getTime();
        return (int) ((to - from)/(1000));
    }

    /**
     * 日期字符串格式转换
     * @param dateString
     * @return
     * @throws ParseException
     */
    public static String switchDateString(String dateString) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("yyyyMMddHHmmss");
        Date date = format.parse(dateString);
        format.applyPattern("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

    /**
     * 获取当前时间的过去第几天的日期
     *
     * @param past
     * @return
     */
    public static String getPastDate(int past) {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_YEAR,-past);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date today = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String result = format.format(today);
        return result;
    }
}
