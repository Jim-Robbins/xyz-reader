package com.example.xyzreader;

import android.text.format.DateUtils;
import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
/**
 * Created by jim on 6/12/17.
 */
public class Utils {
    private static final String TAG = Utils.class.toString();;

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sss");
    // Use default locale format
    private static SimpleDateFormat outputFormat = new SimpleDateFormat();
    // Most time functions can only handle 1902 - 2037
    private static GregorianCalendar START_OF_EPOCH = new GregorianCalendar(2,1,1);

    public static String getFormattedDate(String date) {
        Date publishedDate = parsePublishedDate(date);
        return (!publishedDate.before(START_OF_EPOCH.getTime())) ?
                DateUtils.getRelativeTimeSpanString(publishedDate.getTime(), System.currentTimeMillis(), DateUtils.HOUR_IN_MILLIS, DateUtils.FORMAT_ABBREV_ALL).toString()
                : outputFormat.format(publishedDate);
    }

    private static Date parsePublishedDate(String date) {
        try {
            return dateFormat.parse(date);
        } catch (ParseException ex) {
            Log.e(TAG, ex.getMessage());
            Log.i(TAG, "passing today's date");
            return new Date();
        }
    }
}