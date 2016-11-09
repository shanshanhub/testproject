package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author WanChuanLai
 * @create 8/26/16.
 */
public class TestMain {
    public static void main(String [] args){

        Date time=new Date(1478170200000l);
        System.out.println(time);
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(time);
//        calendar.add(calendar.MONTH, -2);
//        calendar.set(Calendar.DAY_OF_MONTH,1);
//        calendar.set(Calendar.HOUR_OF_DAY,0);
//        calendar.set(Calendar.MINUTE,0);
//        calendar.set(Calendar.SECOND,0);
//        Date beforeThreeMonth=convertStringToDate(LONGDATEFORMATER_YYYYMMDDHHMM,convertDateToString(LONGDATEFORMATER_YYYYMMDDHHMM,calendar.getTime()));
//
//        System.out.println(beforeThreeMonth);

    }

    /**
     * 把时间字符串转成指定格式的时间
     *
     * @param datePattern
     *            转换格式
     * @param date
     *            时间
     * @return 时间Date
     * @throws ParseException
     */
    public static final Date convertStringToDate(String datePattern,
                                                 String dateStr) {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(datePattern);
        try {
            date = df.parse(dateStr);
        } catch (ParseException pe) {
           // log.info("{}",pe);
            return null;
        }
        return (date);
    }
    public final static String LONGDATEFORMATER = "yyyy-MM-dd HH:mm:ss";

    public final static String LONGDATEFORMATER_YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";
    public static final Date convertStringToDate(String dateStr) {
        SimpleDateFormat df = null;
        Date date = null;
        df = new SimpleDateFormat(LONGDATEFORMATER);
        try {
            date = df.parse(dateStr);
        } catch (ParseException pe) {
           // log.info("{}",pe);
            return null;
        }
        return (date);
    }

    public static final String convertDateToString(String datePattern, Date date) {
        String returnValue = null;
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(datePattern);
            returnValue = df.format(date);
        }
        return (returnValue);
    }

}
