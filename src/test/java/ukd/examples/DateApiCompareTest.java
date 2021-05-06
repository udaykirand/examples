package ukd.examples;

import org.junit.Test;

import java.util.stream.IntStream;

public class DateApiCompareTest {

    @Test
    public void testPerformance() {
        System.out.println("\tnewAPI\toldAPI");
        IntStream.rangeClosed(1, 10)
                .forEach(DateApiCompareTest::createDateObjects);

    }

    private static void createDateObjects(int i) {
        DateApiCompare dateApiCompare = new DateApiCompare();
        long newStartTime = System.currentTimeMillis();
        dateApiCompare.checkNewApproach();
        long newEndTime = System.currentTimeMillis();
        long oldStartTime = System.currentTimeMillis();
        dateApiCompare.checkOldApproachDate();
        long oldEndTime = System.currentTimeMillis();

        System.out.println(String.format(
                "\t%s\t\t%s",
                (newEndTime - newStartTime),
                (oldEndTime - oldStartTime)));
    }
}
