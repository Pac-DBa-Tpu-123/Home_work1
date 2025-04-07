package main.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public class Task2 {

    private Task2() {
    }

    private static final int NUMBER_OF_MONTH = 12;
    private static final int DAY_OF_THE_WEEK_FRIDAY = 13;

    public static List<LocalDate> findFriday13s(int year) {
        List<LocalDate> friday13s = new ArrayList<>();

        for (int month = 1; month <= NUMBER_OF_MONTH; month++) {
            LocalDate date = LocalDate.of(year, month, DAY_OF_THE_WEEK_FRIDAY);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
                friday13s.add(date);
            }
        }

        return friday13s;
    }

    public static LocalDate findNextFriday13(LocalDate startDate) {
        return startDate.with(new NextFriday13Adjuster());
    }

    public static class NextFriday13Adjuster implements TemporalAdjuster {

        @Override
        public Temporal adjustInto(Temporal temporal) {
            LocalDate date = LocalDate.from(temporal);
            LocalDate nextFriday13 = date;

            while (true) {
                nextFriday13 = nextFriday13.with(TemporalAdjusters.firstDayOfNextMonth());
                LocalDate candidate = nextFriday13.withDayOfMonth(DAY_OF_THE_WEEK_FRIDAY);
                if (candidate.getDayOfWeek() == DayOfWeek.FRIDAY && candidate.isAfter(date)) {
                    return candidate;
                }
            }
        }
    }
}
