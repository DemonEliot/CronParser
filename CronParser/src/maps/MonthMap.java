package maps;

import java.util.HashMap;
import java.util.Map;

public class MonthMap {

    Map<String, Integer> monthMap = new HashMap<>();


    public MonthMap() {
        monthMap.put("JAN", 1);
        monthMap.put("FEB", 2);
        monthMap.put("MAR", 3);
        monthMap.put("APR", 4);
        monthMap.put("MAY", 5);
        monthMap.put("JUN", 6);
        monthMap.put("JUL", 7);
        monthMap.put("AUG", 8);
        monthMap.put("SEP", 9);
        monthMap.put("OCT", 10);
        monthMap.put("NOV", 11);
        monthMap.put("DEC", 12);
    }

    public int getMonthValue(String monthName) {
        return monthMap.get(monthName);
    }
}
