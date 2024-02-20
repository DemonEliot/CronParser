package maps;

import java.util.HashMap;
import java.util.Map;

public class WeekdayMap {

    Map<String, Integer> weekdayMap = new HashMap<>();


    public WeekdayMap() {
        weekdayMap.put("MON", 1);
        weekdayMap.put("TUE", 2);
        weekdayMap.put("WED", 3);
        weekdayMap.put("THU", 4);
        weekdayMap.put("FRI", 5);
        weekdayMap.put("SAT", 6);
        weekdayMap.put("SUN", 7);
    }

    public int getWeekdayValue(String weekdayName) {
        return weekdayMap.get(weekdayName);
    }
}
