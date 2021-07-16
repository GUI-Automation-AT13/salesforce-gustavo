package utilities;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import static org.testng.Assert.assertThrows;

public class CalendarManagerTests {
    private Calendar calendarExpected;
    private Calendar dateToConvert;
    private CalendarManager calendarManager;

    @BeforeMethod
    public void clean() {
        calendarExpected = Calendar.getInstance();
        dateToConvert = Calendar.getInstance();
        calendarManager = new CalendarManager();
    }

    @Test
    public void shouldReturnTodayDate() throws ParseException {
        Date date = calendarManager.convertStringToDate("TODAY");
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.DAY_OF_MONTH);
        int expected = calendarExpected.get(Calendar.DAY_OF_MONTH);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnTomorrowDate() throws ParseException {
        Date date = calendarManager.convertStringToDate("TOMORROW");
        calendarExpected.add(Calendar.DAY_OF_MONTH, 1);
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.DAY_OF_MONTH);
        int expected = calendarExpected.get(Calendar.DAY_OF_MONTH);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnYesterdayDate() throws ParseException {
        Date date = calendarManager.convertStringToDate("YESTERDAY");
        calendarExpected.add(Calendar.DAY_OF_MONTH, -1);
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.DAY_OF_MONTH);
        int expected = calendarExpected.get(Calendar.DAY_OF_MONTH);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturn2DaysAgoDate() throws ParseException {
        Date date = calendarManager.convertStringToDate("2 days ago");
        calendarExpected.add(Calendar.DAY_OF_MONTH, -2);
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.DAY_OF_MONTH);
        int expected = calendarExpected.get(Calendar.DAY_OF_MONTH);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturn15MinNowDate() throws ParseException {
        Date date = calendarManager.convertStringToDate("15 minutes from now");
        calendarExpected.add(Calendar.MINUTE, 15);
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.MINUTE);
        int expected = calendarExpected.get(Calendar.MINUTE);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturn5MonthsNOwDate() throws ParseException {
        Date date = calendarManager.convertStringToDate("5 months from now");
        calendarExpected.add(Calendar.MONTH, 5);
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.MONTH);
        int expected = calendarExpected.get(Calendar.MONTH);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnDate() throws ParseException {
        Date date = calendarManager.convertStringToDate("7/14/2021");
        dateToConvert.setTime(date);
        int actualMonth = dateToConvert.get(Calendar.MONTH);
        int expectedMonth = Calendar.JULY;
        int actualDay = dateToConvert.get(Calendar.DAY_OF_MONTH);
        int expectedDay = 14;
        int actualYear = dateToConvert.get(Calendar.YEAR);
        int expectedYear = 2021;
        Assert.assertEquals(actualDay, expectedDay);
        Assert.assertEquals(actualMonth, expectedMonth);
        Assert.assertEquals(actualYear, expectedYear);
    }

    @Test
    public void shouldReturn3YearAgoDate() throws ParseException {
        Date date = calendarManager.convertStringToDate("3 years ago");
        calendarExpected.add(Calendar.YEAR, -3);
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.DAY_OF_MONTH);
        int expected = calendarExpected.get(Calendar.DAY_OF_MONTH);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturn1DayAgoDate() throws ParseException {
        Date date = calendarManager.convertStringToDate("1 day ago");
        calendarExpected.add(Calendar.DAY_OF_MONTH, -1);
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.DAY_OF_MONTH);
        int expected = calendarExpected.get(Calendar.DAY_OF_MONTH);
        Assert.assertEquals(actual, expected);
    }


    @Test(expectedExceptions = RuntimeException.class,
            expectedExceptionsMessageRegExp = "The value is not valid, try today, yesterday and tomorrow")
    public void shouldReturnExceptionWithInvalidInputToday() throws ParseException {
        Date date = calendarManager.convertStringToDate("todai");
    }

    @Test(expectedExceptions = RuntimeException.class,
            expectedExceptionsMessageRegExp = "The value is incorrectly entered or has negative number")
    public void shouldReturnExceptionWithInvalidInputDaysWithOneDay() throws ParseException {
        Date date = calendarManager.convertStringToDate("1 days ago");
    }

    @Test(expectedExceptions = RuntimeException.class,
            expectedExceptionsMessageRegExp = "The value is incorrectly entered or has negative number")
    public void shouldReturnExceptionToInvalidYear() throws ParseException {
        Date date = calendarManager.convertStringToDate("-3 years ago");
    }

    @Test(expectedExceptions = RuntimeException.class,
            expectedExceptionsMessageRegExp = "The value is incorrectly entered or has negative number")
    public void shouldReturnExceptionToInvalidMonthsNow() throws ParseException {
        Date date = calendarManager.convertStringToDate("5 month from now");
    }

    @Test(expectedExceptions = RuntimeException.class,
            expectedExceptionsMessageRegExp = "Invalid value or date")
    public void shouldReturnExceptionToNullInput() throws ParseException {
        Date date = calendarManager.convertStringToDate(null);
    }
}
