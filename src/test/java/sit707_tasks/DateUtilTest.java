package sit707_tasks;

import org.junit.Test;
import static org.junit.Assert.*;

public class DateUtilTest {

    @Test
    public void testValidDateManipulation() {
        DateUtil date = new DateUtil(1, 1, 2022);
        date.increment(1);
        assertEquals("02/01/2022", date.toString());
        date.decrement(1);
        assertEquals("01/01/2022", date.toString());

        date = new DateUtil(31, 12, 2022);
        date.decrement(1);
        assertEquals("30/12/2022", date.toString());
    }

    @Test
    public void testBoundaryDaysInMonth() {
        DateUtil date = new DateUtil(1, 12, 2022);
        date.increment(30);
        assertEquals("31/12/2022", date.toString());
        date.increment(1);
        assertEquals("01/01/2023", date.toString());

        date = new DateUtil(31, 1, 2022);
        date.decrement(30);
        assertEquals("01/01/2022", date.toString());
        date.decrement(1);
        assertEquals("31/12/2021", date.toString());
    }

    @Test
    public void testLeapYear() {
        DateUtil date = new DateUtil(1, 12, 2022);
        date.increment(30);
        assertEquals("31/12/2022", date.toString());
        date.increment(1);
        assertEquals("01/01/2023", date.toString());

        date = new DateUtil(31, 1, 2022);
        date.decrement(30);
        assertEquals("01/01/2022", date.toString());
        date.decrement(1);
        assertEquals("31/12/2021", date.toString());
    }

    @Test
    public void testInvalidDate() {
        DateUtil date = new DateUtil(1, 12, 2022);
        date.increment(30);
        assertEquals("31/12/2022", date.toString());
        date.increment(1);
        assertEquals("01/01/2023", date.toString());

        date = new DateUtil(31, 1, 2022);
        date.decrement(30);
        assertEquals("01/01/2022", date.toString());
        date.decrement(1);
        assertEquals("31/12/2021", date.toString());
    }

    @Test
    public void testInvalidIncrementDecrement() {
        DateUtil date = new DateUtil(1, 12, 2022);
        date.increment(30);
        assertEquals("31/12/2022", date.toString());
        date.increment(1);
        assertEquals("01/01/2023", date.toString());

        date = new DateUtil(31, 1, 2022);
        date.decrement(30);
        assertEquals("01/01/2022", date.toString());
        date.decrement(1);
        assertEquals("31/12/2021", date.toString());
    }
}
