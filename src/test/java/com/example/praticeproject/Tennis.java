package com.example.praticeproject;

public class Tennis {
    private int firstPlayerScoreTimes;

    public String score() {
        if (firstPlayerScoreTimes == 1) {
            return "fifteen love";
        }
        return "love all";
    }

    public void firstPlayerScore() {
        firstPlayerScoreTimes++;
    }
}
