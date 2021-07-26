package utilities;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @DataProvider(name = "ActualResult")
    public static Object[][] datesInputResult() {
        return new Object[][]{{"5 years from now", Calendar.YEAR, 5},
                {"1 second from now", Calendar.SECOND, 1},
                {"2 hours from now", Calendar.HOUR, 2},
                { "TODAY", Calendar.DAY_OF_MONTH, 0 },
                {"TOMORROW" , Calendar.DAY_OF_MONTH, 1},
                { "YESTERDAY",Calendar.DAY_OF_MONTH ,-1 },
                { "2 days ago", Calendar.DAY_OF_MONTH, -2},
                {"15 minutes from now" , Calendar.MINUTE,15 },
                {"5 months from now" ,Calendar.MONTH , 5},
                {"3 years ago" ,Calendar.YEAR ,-3 },
                {"1 day ago" , Calendar.DAY_OF_MONTH, -1}};
    }

    @Test(dataProvider = "ActualResult")
    public void shouldReturnDateModifier(String dateToChange,int unit, int amount ) throws ParseException {
        Date date = calendarManager.convertStringToDate(dateToChange);
        calendarExpected.add(unit, amount);
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(unit);
        int expected = calendarExpected.get(unit);
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

    @Test(expectedExceptions = RuntimeException.class,
            expectedExceptionsMessageRegExp = "The value is not valid, try today, yesterday and tomorrow")
    public void shouldReturnExceptionWithInvalidInputToday() throws ParseException {
        Date date = calendarManager.convertStringToDate("todai");
    }

    @Test(expectedExceptions = RuntimeException.class,
            expectedExceptionsMessageRegExp = "The value is incorrectly has to be in singular")
    public void shouldReturnExceptionWithInvalidInputDaysWithOneDay() throws ParseException {
        Date date = calendarManager.convertStringToDate("1 days ago");
    }

    @Test(expectedExceptions = RuntimeException.class,
            expectedExceptionsMessageRegExp = "The value is incorrectly entered or has negative number")
    public void shouldReturnExceptionToInvalidYear() throws ParseException {
        Date date = calendarManager.convertStringToDate("-3 years ago");
    }

    @Test(expectedExceptions = RuntimeException.class,
            expectedExceptionsMessageRegExp = "The value is incorrectly has to be in plural")
    public void shouldReturnExceptionToInvalidMonthsNow() throws ParseException {
        Date date = calendarManager.convertStringToDate("5 month from now");
    }

    @Test(expectedExceptions = RuntimeException.class,
            expectedExceptionsMessageRegExp = "Invalid value or date")
    public void shouldReturnExceptionToNullInput() throws ParseException {
        Date date = calendarManager.convertStringToDate(null);
    }
}
