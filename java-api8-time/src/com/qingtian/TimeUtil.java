package com.qingtian;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/10/30
 */
public class TimeUtil {

    public static void main(String[] args) {
        Date startDate = formatToDate("2018-10-29 20:00:00", "yyyy-MM-dd HH:mm:ss");
        Date endDate = formatToDate("2018-10-30 21:00:00", "yyyy-MM-dd HH:mm:ss");

        // 获取endDate对应的localDateTime

        LocalDateTime startLocalDateTime = translate2LocalDateTime(startDate);
        LocalDateTime endLocalDateTime = translate2LocalDateTime(endDate);
        // endLocalDateTime - startLocalDateTime ,单位小时
        long hour = startLocalDateTime.until(endLocalDateTime, ChronoUnit.HOURS);
        // endLocalDateTime - startLocalDateTime ,单位秒
        long second = startLocalDateTime.until(endLocalDateTime, ChronoUnit.SECONDS);
        System.out.println("hour:" + hour);
        System.out.println("second:" + second);
    }

    /**
     * 将时间格式化为指定的format
     * @param strDate
     * @param format
     * @return
     */
    private static Date formatToDate(String strDate, String format) {
        if (strDate == null) {
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     * 将date转换为localDateTime
     * @param date
     * @return
     */
    private static LocalDateTime translate2LocalDateTime(Date date) {
        ZoneId zoneId = ZoneId.systemDefault();

        // 获取date对应的localDateTime
        Instant instant = date.toInstant();
        return instant.atZone(zoneId).toLocalDateTime();
    }

    /**
     * 将date转换为localDate
     * @param date
     * @return
     */
    private static LocalDate translate2LocalDate(Date date) {
        ZoneId zoneId = ZoneId.systemDefault();

        // 获取date对应的localDate
        Instant instant = date.toInstant();
        return instant.atZone(zoneId).toLocalDate();
    }
}
