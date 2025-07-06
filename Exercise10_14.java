/*  -----------------------------------------------------------
    File : Exercise10_14.java
    Path : src/main/java/assignments/Exercise10_14/Exercise10_14.java
----------------------------------------------------------- */
package assignments.Exercise10_14;

import java.util.GregorianCalendar;

public class Exercise10_14 {
    public static void main(String[] args) {
        // object for today
        MyDate today = new MyDate();

        // object for the given elapsed milliseconds
        MyDate past = new MyDate(34355555133101L);

        // display results
        System.out.printf("Today        : %d-%02d-%02d%n",
                today.getYear(), today.getMonth() + 1, today.getDay());
        System.out.printf("Elapsed date : %d-%02d-%02d%n",
                past.getYear(),  past.getMonth() + 1, past.getDay());
    }
}

/* ------------------------------------------------------------------
   Helper class
------------------------------------------------------------------ */
class MyDate {
    private int year;
    private int month;   // 0-based (0 = January)
    private int day;

    /** No-arg constructor — current date */
    public MyDate() {
        GregorianCalendar gc = new GregorianCalendar();
        this.year  = gc.get(GregorianCalendar.YEAR);
        this.month = gc.get(GregorianCalendar.MONTH);
        this.day   = gc.get(GregorianCalendar.DAY_OF_MONTH);
    }

    /** Construct from milliseconds since 00:00, 1 Jan 1970 */
    public MyDate(long elapsedTime) {
        setDate(elapsedTime);
    }

    /** Construct from explicit Y/M/D (month still 0-based) */
    public MyDate(int year, int month, int day) {
        this.year  = year;
        this.month = month;
        this.day   = day;
    }

    /* ---------- getters ---------- */
    public int getYear()  { return year;  }
    public int getMonth() { return month; }
    public int getDay()   { return day;   }

    /* ---------- mutate from elapsed milliseconds ---------- */
    public void setDate(long elapsedTime) {
        GregorianCalendar gc = new GregorianCalendar();
        gc.setTimeInMillis(elapsedTime);
        this.year  = gc.get(GregorianCalendar.YEAR);
        this.month = gc.get(GregorianCalendar.MONTH);
        this.day   = gc.get(GregorianCalendar.DAY_OF_MONTH);
    }
}
