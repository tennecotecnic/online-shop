package com.tennecotecnic.onlineshop.util;

import java.time.Instant;

public class TimeFormatUtil {

    public static Instant timeFormatSetting() {
        Instant timestamp = Instant.now();
        long milliSeconds = timestamp.toEpochMilli();
        return Instant.ofEpochMilli(milliSeconds);
    }
}
