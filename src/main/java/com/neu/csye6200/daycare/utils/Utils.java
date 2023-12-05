package com.neu.csye6200.daycare.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.function.Function;

public class Utils {
    public static final Function<String, Integer> GET_AGE_IN_MONTHS_FROM_DOB = (date) -> {
        LocalDate today = LocalDate.now();
        Date bDate = getDateFromString(date);
        Calendar calendar = Calendar.getInstance();
        assert bDate != null;
        calendar.setTime(bDate);
        LocalDate birthday = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
        Period p = Period.between(birthday, today);
        return p.getYears() * 12 + p.getMonths();
    };

    private static Date getDateFromString(String date) {
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        try {
            String text = null;
            return dateFormat.parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
