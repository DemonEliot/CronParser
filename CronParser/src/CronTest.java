import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CronTest {

    @Test
    void parseMinute() {
        List<Integer> expected = Arrays.asList(0,15,30,45);
        assertEquals(expected, Cron.parseMinute("*/15"));
    }

    @Test
    void parseHour() {
        List<Integer> expected = List.of(0);
        assertEquals(expected, Cron.parseHour("0"));
    }

    @Test
    void parseDay() {
        List<Integer> expected = Arrays.asList(1, 15);
        assertEquals(expected, Cron.parseDay("1,15"));
    }

    @Test
    void parseMonth() {
        List<Integer> expected = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12);
        assertEquals(expected, Cron.parseMonth("*"));

        List<Integer> expected2 = Arrays.asList(1,2,3,4);
        assertEquals(expected2, Cron.parseMonth("JAN,FEB,MAR,APR"));
    }

    @Test
    void parseWeekday() {
        List<Integer> expected = Arrays.asList(1,2,3,4,5);
        assertEquals(expected, Cron.parseWeekday("1-5"));

        List<Integer> expected2 = Arrays.asList(1,5,7);
        assertEquals(expected2, Cron.parseWeekday("MON,FRI,SUN"));
    }

}