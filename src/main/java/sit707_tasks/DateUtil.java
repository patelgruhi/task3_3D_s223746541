package sit707_tasks;

public class DateUtil {
    private int day;
    private int month;
    private int year;

    public DateUtil(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void increment(int days) {
        int newDay = this.day + days;
        int newMonth = this.month;
        int newYear = this.year;

        while (newDay > getDaysInMonth()) {
            newDay -= getDaysInMonth();
            newMonth++;

            if (newMonth > 12) {
                newMonth = 1;
                newYear++;
            }
        }

        this.day = newDay;
        this.month = newMonth;
        this.year = newYear;
    }

    public void decrement(int days) {
        int newDay = this.day - days;
        int newMonth = this.month;
        int newYear = this.year;

        while (newDay < 1) {
            newMonth--;

            if (newMonth < 1) {
                newMonth = 12;
                newYear--;
            }

            newDay += getDaysInMonth();
        }

        this.day = newDay;
        this.month = newMonth;
        this.year = newYear;
    }

    public boolean isLeapYear() {
        return this.year % 4 == 0 && (this.year % 100 != 0 || this.year % 400 == 0);
    }

    public int getDaysInMonth() {
        if (this.month == 2) {
            return isLeapYear() ? 29 : 28;
        } else if (this.month == 4 || this.month == 6 || this.month == 9 || this.month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    public String toString() {
        return String.format("%02d/%02d/%04d", this.day, this.month, this.year);
    }
}