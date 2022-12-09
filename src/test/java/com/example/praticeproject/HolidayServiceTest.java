package com.example.praticeproject;

import org.joda.time.DateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HolidayServiceTest {
    HolidayServiceForTest holidayService;

    @BeforeEach
    public void setUp() {
        holidayService = new HolidayServiceForTest();
    }

    @Test
    void today_is_Xmas() {
        givenToday(11, 21);
        sayHelloShouldBe("Today is not Xmas");
    }

    @Test
    void today_is_not_Xmas() {
        givenToday(12, 25);
        sayHelloShouldBe("Merry Xmas");
    }

    public void givenToday(Integer month, Integer day) {
        holidayService.setDateTime(new DateTime(2000,month,day,1,1));
    }

    public void sayHelloShouldBe(String expected) {
        Assertions.assertEquals(expected, holidayService.sayHello());
    }
}

class HolidayServiceForTest extends HolidayService {
    DateTime dateTime;

    public void setDateTime(DateTime dateTime) {
      this.dateTime = dateTime;
    }
    @Override
    protected DateTime getDateTime() {
        return dateTime;
    }



}