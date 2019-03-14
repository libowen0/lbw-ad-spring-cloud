package com.lbw.ad.utils;

import com.lbw.ad.exception.AdException;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * Created with IntelliJ IDEA. User: lbw Date: 2019/2/25 Time: 17:42 Description:
 */
public class CommonUtils {

    private static String[] parsePatterns = {"yyyy-MM-dd","yyyy/MM/dd","yyyy.MM.dd"};

    public static String md5(String value){
        return DigestUtils.md5Hex(value).toUpperCase();
    }

    public static Date parseStringDate(String dateString) throws AdException {

        try {
            return DateUtils.parseDate(dateString,parsePatterns);
        } catch (ParseException e) {
            throw new AdException(e.getMessage());
        }
    }
}
