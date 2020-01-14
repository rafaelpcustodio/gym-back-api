package com.dextra.gymapp.domain.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateParser {

    private static final DateTimeFormatter DATE_FORMATTER =  DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static LocalDate convertStringToLocalDate(final String date){
        return LocalDate.parse(date, DATE_FORMATTER);
    }
}
