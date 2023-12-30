package com.example.testTask.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class TimeUtils {
    private static final String DATE_PATTERN = "EEEE, MMMM dd, yyyy";
    public static final String POSTED_ON_DAY = "Posted on ";
    public static Long convertStringDateToTimeStamp(String stringDate) {
        long timestamp;
        stringDate = cutString(stringDate,POSTED_ON_DAY);
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
            Date  date = dateFormat.parse(stringDate);
            timestamp = date.getTime();
        } catch (ParseException ignored) {
            timestamp = 0L;
        }
        return timestamp;
    }
    public static String convertStringDateToTimeToString(Long dateLong) {
        Date date = new Date(dateLong);
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE, MMMM dd, yyyy");
            return  dateFormat.format(date);
        }
        public static String cutString(String stringDate,
                                 String partToRemove) {
        return  stringDate.replace(partToRemove,"");
        }
    }
