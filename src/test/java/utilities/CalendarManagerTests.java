package utilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class CalendarManagerTests {
    private Calendar calendarExpected;
    private Calendar dateToConvert;
    private CalendarManager calendarManager;

    @BeforeMethod
    public void clean(){
        calendarExpected =Calendar.getInstance();
        dateToConvert = Calendar.getInstance();
        calendarManager = new CalendarManager();
    }

    @Test
    public void shouldReturnTodayDate() {
        Date date = calendarManager.converterStringToDate("TODAY");
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.DAY_OF_MONTH);
        int expected = calendarExpected.get(Calendar.DAY_OF_MONTH);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void shouldReturnTomorrowDate() {
        Date date = calendarManager.converterStringToDate("TOMORROW");
        calendarExpected.add(Calendar.DAY_OF_MONTH,1);
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.DAY_OF_MONTH);
        int expected = calendarExpected.get(Calendar.DAY_OF_MONTH);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void shouldReturnYesterdayDate() throws ParseException {
        Date date = calendarManager.converterStringToDate("YESTERDAY");
        calendarExpected.add(Calendar.DAY_OF_MONTH,-1);
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.DAY_OF_MONTH);
        int expected = calendarExpected.get(Calendar.DAY_OF_MONTH);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void shouldReturn2DaysAgoDate() throws ParseException {
        Date date = calendarManager.converterStringToDate("2 days ago");
        calendarExpected.add(Calendar.DAY_OF_MONTH,-2);
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.DAY_OF_MONTH);
        int expected = calendarExpected.get(Calendar.DAY_OF_MONTH);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void shouldReturn15MinNowDate() {
        Date date = calendarManager.converterStringToDate("15 minutes from now");
        calendarExpected.add(Calendar.MINUTE,15);
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.MINUTE);
        int expected = calendarExpected.get(Calendar.MINUTE);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void shouldReturn5MonthsNOwDate() {
        Date date = calendarManager.converterStringToDate("5 months from now");
        calendarExpected.add(Calendar.MONTH,5);
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.MONTH);
        int expected = calendarExpected.get(Calendar.MONTH);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void shouldReturnDate() {
        Date date = calendarManager.converterStringToDate("7/14/2021");
        dateToConvert.setTime(date);
        int actualMonth = dateToConvert.get(Calendar.MONTH);
        int expectedMonth = Calendar.JULY;
        int actualDay = dateToConvert.get(Calendar.DAY_OF_MONTH);
        int expectedDay = 14;
        int actualYear = dateToConvert.get(Calendar.YEAR);
        int expectedYear = 2021;
        Assert.assertEquals(actualDay,expectedDay);
        Assert.assertEquals(actualMonth,expectedMonth);
        Assert.assertEquals(actualYear,expectedYear);
    }

    @Test
    public void shouldReturn3YearAgoDate() {
        Date date = calendarManager.converterStringToDate("3 years ago");
        calendarExpected.add(Calendar.YEAR,-3);
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.DAY_OF_MONTH);
        int expected = calendarExpected.get(Calendar.DAY_OF_MONTH);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void shouldReturn1DayAgoDate() {
        Date date = calendarManager.converterStringToDate("1 day ago");
        calendarExpected.add(Calendar.DAY_OF_MONTH,-1);
        dateToConvert.setTime(date);
        int actual = dateToConvert.get(Calendar.DAY_OF_MONTH);
        int expected = calendarExpected.get(Calendar.DAY_OF_MONTH);
        Assert.assertEquals(actual,expected);
    }


    @Test(expectedExceptions = RuntimeException.class)
    public void shouldReturnExceptionWithInvalidInputToday() {
        Date date = calendarManager.converterStringToDate("today");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void shouldReturnExceptionWithInvalidInputDaysWithOneDay() {
        Date date = calendarManager.converterStringToDate("1 days ago");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void shouldReturnExceptionToInvalidYear() {
        Date date = calendarManager.converterStringToDate("-3 years ago");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void shouldReturnExceptionToInvalidMonthsNow() {
        Date date = calendarManager.converterStringToDate("5 month from now");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void shouldReturnExceptionToNullInput() {
        Date date = calendarManager.converterStringToDate(null);
    }

}
