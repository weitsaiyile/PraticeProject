package com.example.praticeproject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TennisTest {

    private final Tennis tennis = new Tennis();

    @Test
    public void love_all() {
        scoreShouldBe("love all");
    }
    @Test
    public void fifteen_love() {
        tennis.firstPlayerScore();
        scoreShouldBe("fifteen love");
    }

    private void scoreShouldBe(String expected) {
        assertEquals(expected, tennis.score());
    }
}