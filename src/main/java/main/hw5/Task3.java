package main.hw5;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {

    private Task3() {
    }

    public static Optional<LocalDate> parseDate(String date) {
        if (date == null || date.isEmpty()) {
            return Optional.empty();
        }

        DateHandler fixedFormatHandler = new FixedFormatDateHandler();
        DateHandler relativeDateHandler = new RelativeDateHandler();
        DateHandler daysAgoDateHandler = new DaysAgoDateHandler();

        fixedFormatHandler.setNextHandler(relativeDateHandler);
        relativeDateHandler.setNextHandler(daysAgoDateHandler);

        return fixedFormatHandler.handle(date);
    }

    private interface DateHandler {
        Optional<LocalDate> handle(String date);

        void setNextHandler(DateHandler nextHandler);
    }

    private abstract static class AbstractDateHandler implements DateHandler {
        private DateHandler nextHandler;

        @Override
        public void setNextHandler(DateHandler nextHandler) {
            this.nextHandler = nextHandler;
        }

        protected Optional<LocalDate> handleNext(String date) {
            if (nextHandler != null) {
                return nextHandler.handle(date);
            }
            return Optional.empty();
        }
    }

    private static class FixedFormatDateHandler extends AbstractDateHandler {
        private final DateTimeFormatter[] formatters = {
            DateTimeFormatter.ofPattern("yyyy-MM-dd"),
            DateTimeFormatter.ofPattern("yyyy-M-d"),
            DateTimeFormatter.ofPattern("M/d/yyyy"),
            DateTimeFormatter.ofPattern("M/d/yy")
        };

        @Override
        public Optional<LocalDate> handle(String date) {
            for (DateTimeFormatter formatter : formatters) {
                try {
                    return Optional.of(LocalDate.parse(date, formatter));
                } catch (DateTimeParseException ignored) {
                }
            }
            return handleNext(date);
        }
    }

    private static class RelativeDateHandler extends AbstractDateHandler {
        @Override
        public Optional<LocalDate> handle(String date) {
            switch (date.toLowerCase()) {
                case "today":
                    return Optional.of(LocalDate.now());
                case "tomorrow":
                    return Optional.of(LocalDate.now().plusDays(1));
                case "yesterday":
                    return Optional.of(LocalDate.now().minusDays(1));
                default:
                    return handleNext(date);
            }
        }
    }

    private static class DaysAgoDateHandler extends AbstractDateHandler {
        private final Pattern daysAgoPattern = Pattern.compile("(\\d+) days? ago");

        @Override
        public Optional<LocalDate> handle(String date) {
            Matcher matcher = daysAgoPattern.matcher(date.toLowerCase());
            if (matcher.matches()) {
                int daysAgo = Integer.parseInt(matcher.group(1));
                return Optional.of(LocalDate.now().minusDays(daysAgo));
            }
            return handleNext(date);
        }
    }
}
