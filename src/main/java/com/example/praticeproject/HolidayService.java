package com.example.praticeproject;

import org.springframework.stereotype.Service;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;


@Service
public class HolidayService {

    public String sayHello() {
        Integer month = 12;
        Integer day = 25;
        DateTime dateTime = getDateTime();
        if (dateTime.getMonthOfYear() == month && dateTime.getDayOfMonth() == day) {
            return "Merry Xmas";
        } else {
            return "Today is not Xmas";
        }
    }

    protected  DateTime getDateTime() {
        return new DateTime();
    }


//    public String getXmasState(){
//        Integer month=12;
//        Integer day=25;
//        if(isValidChrisMas(day,month)){
//            return "Merry Xmas";
//        }else{
//            return "Today is not Xmas";
//        }
//    }
}
