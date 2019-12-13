package com.dextra.gymapp.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class DateParser {

    public static LocalDate convertDateToLocalDate(final Date date){
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
