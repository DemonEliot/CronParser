import maps.MonthMap;
import maps.WeekdayMap;

import java.util.ArrayList;
import java.util.List;

public class Cron {

    static String minute;
    static String hour;
    static String day;
    static String month;
    static String weekday;
    static String command;

    public static void main(String[] args) {

        minute = args[0];
        hour = args[1];
        day = args[2];
        month = args[3];
        weekday = args[4];
        command = args[5];

        List<Integer> minutes = parseMinute(minute);
        List<Integer> hours = parseHour(hour);
        List<Integer> days = parseDay(day);
        List<Integer> months = parseMonth(month);
        List<Integer> weekdays = parseWeekday(weekday);

        outputCron("minute", minutes);
        outputCron("hour", hours);
        outputCron("days", days);
        outputCron("months", months);
        outputCron("weekdays", weekdays);
        outputCron("command", command);
    }

    /*
    * Print name (taking 14 spaces)
    * */
    public static void outputCron(String name, List<Integer> values) {
        System.out.printf("%-14s", name);

        for (Integer value : values) {
            System.out.print(value.toString() + " ");
        }
        System.out.println();
    }

    public static void outputCron(String name, String value) {
        System.out.printf("%-14s", name);
        System.out.print(value);
    }
    /*
     * Allowed:
     * 0-59
     * , - * /
     */
    public static List<Integer> parseMinute(String minute) {
        int min = 0;
        int max = 59;

        return parse(minute, min, max);
    }

    /*
     * Allowed:
     * 0-23
     * , - * /
     */
    public static List<Integer> parseHour(String hour) {
        int min = 0;
        int max = 23;

        return parse(hour, min, max);
    }

    /*
     * Allowed:
     * 1-31
     * , - * ? / L W C
     */
    public static List<Integer> parseDay(String day) {
        int min = 1;
        int max = 31;

        if (day.equals("?")) {
            List<Integer> results = new ArrayList<>();
            for (int i = min; i <= max; i++) {
                results.add(i);
            }
            return results;
        }
        return parse(day, min, max);
    }

    /*
     * Allowed:
     * 1-12 or JAN,DEC
     * , - * /
     */
    public static List<Integer> parseMonth(String month) {
        int min = 1;
        int max = 12;

        if (month.matches(".*[a-zA-Z].*")) {
            List<Integer> results = new ArrayList<>();
            MonthMap months = new MonthMap();

            if (month.contains(",")) {
                for (String monthName : month.split(",")) {
                    results.add(months.getMonthValue(monthName));
                }
            } else {
                results.add(months.getMonthValue(month));
            }

            return results;
        }

        return parse(month, min, max);
    }

    /*
     * Allowed:
     * 1-7 or MON,SUN
     * , - * ? / L C #
     */
    public static List<Integer> parseWeekday(String weekday) {
        int min = 1;
        int max = 7;

        if (weekday.equals("?")) {
            List<Integer> results = new ArrayList<>();
            for (int i = min; i <= max; i++) {
                results.add(i);
            }
            return results;
        }
        else if (weekday.matches(".*[a-zA-Z].*")) {
            List<Integer> results = new ArrayList<>();
            WeekdayMap days = new WeekdayMap();

            if (weekday.contains(",")) {
                for (String weekdayNames : weekday.split(",")) {
                    results.add(days.getWeekdayValue(weekdayNames));
                }
            } else {
                results.add(days.getWeekdayValue(weekday));
            }

            return results;
        }

        return parse(weekday, min, max);
    }

    public static List<Integer> parse(String s, int min, int max) {
        List<Integer> results = new ArrayList<>();

        if (s.contains(",")) {
            for (String num : s.split(",")) {
                results.add(Integer.parseInt(num));
            }
        } else if (s.contains("-")) {
            String[] splitString = s.split("-");
            int start = Integer.parseInt(splitString[0]);
            int end = Integer.parseInt(splitString[1]);
            for (int i = start; i <= end; i++) {
                results.add(i);
            }
        } else if (s.equals("*")) {
            for (int i = min; i <= max; i++) {
                results.add(i);
            }
        } else if (s.contains("/")) {
            String[] splitString = s.split("/");
            int increment = Integer.parseInt(splitString[1]);
            int start;

            if (s.contains("*")) {
                start = min;
            } else {
                start = Integer.parseInt(splitString[0]);
                increment = 1;
            }

            for (int i = start; i <= max; i += increment) {
                results.add(i);
            }
        } else {
            results.add(Integer.parseInt(s));
        }

        return results;
    }

}
