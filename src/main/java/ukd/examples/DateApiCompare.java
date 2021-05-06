package ukd.examples;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DateApiCompare {

    private static final int ITERATIONS = 20000;
    private final List<Integer> hours;
    private final List<Integer> minutes;
    private final Date midnightToday;
    private final LocalDate today;

    public DateApiCompare() {
        this.hours = IntStream.range(0, 23).boxed().collect(Collectors.toList());
        this.minutes = IntStream.range(0, 59).boxed().collect(Collectors.toList());

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        this.midnightToday = cal.getTime();

        this.today = LocalDate.now();
    }


    public void checkNewApproach() {

        List<LocalDateTime> createdObjects = new ArrayList<>();

        while (createdObjects.size() < ITERATIONS) {
            for (int hour : hours) {
                for (int minute : minutes) {
                    if (createdObjects.size() < ITERATIONS) {
                        createdObjects.add(LocalTime.of(hour, minute).atDate(today));
                    }
                }
            }
        }
    }

    public void checkOldApproachDate() {

        List<Date> createdObjects = new ArrayList<>();

        while (createdObjects.size() < ITERATIONS) {
            for (int hour : hours) {
                for (int minute : minutes) {
                    if (createdObjects.size() < ITERATIONS) {
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(midnightToday);
                        cal.set(Calendar.HOUR, hour);
                        cal.set(Calendar.MINUTE, minute);

                        createdObjects.add(cal.getTime());
                    }
                }
            }
        }
    }

}
