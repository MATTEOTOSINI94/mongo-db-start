package it.bitrock.mongodbstart.service;

import org.apache.commons.validator.GenericValidator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ServiceUtils {


    public static boolean isValidDate(String date){
        return GenericValidator.isDate(date,"dd-MM-yyyy",true);
    }

    public static LocalDateTime transformStringToLocalDateTime(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(date,formatter);
        return localDate.atStartOfDay();
    }
}
