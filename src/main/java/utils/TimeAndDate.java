package utils;

import org.joda.time.DateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public final class TimeAndDate {

    private static final String DATE_FORMAT = "dd/MM/yyyy";
    private static final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    private static final DateTimeFormatter dateFormat8 = DateTimeFormatter.ofPattern(DATE_FORMAT);


    private TimeAndDate(){

    }

    public static int getDayFromRange(int range){

        Date currentDate = new Date();
        System.out.println("date : " + dateFormat.format(currentDate));

        // convert date to localdatetime
        LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        // plus range
        localDateTime = localDateTime.plusMonths(range/30).plusDays(range%30);
        //localDateTime = localDateTime.plusHours(1).plusMinutes(2).minusMinutes(1).plusSeconds(1);

        // convert LocalDateTime to date
        Date newDataFromRange = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        System.out.println("\nOutput : " + dateFormat.format(newDataFromRange));
        System.out.println("future day : " + localDateTime.getDayOfMonth());

        return localDateTime.getDayOfMonth();

    }

    public static int getDayFromString(String dateInString) throws ParseException {

        Date date = dateFormat.parse(dateInString);
        return new DateTime(date).getDayOfMonth();


    }
}
