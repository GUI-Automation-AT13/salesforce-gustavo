package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static core.utilities.GetEnv.envVariable;

public class CalendarManager {
    private String dateActualComplete;
    private String dataFormat = envVariable().get("DATE_FORMAT");
    private Date date;
    private Calendar calendarDate;
    private int dates;
    private DateFormatInput dateFormat;

    public CalendarManager() {
    }

    /**
     * Converts string to date according input and format of date.
     *
     * @param input is value which will convert to date
     * @return object type Date
     */
    public Date convertStringToDate(final String input) throws ParseException {
        if (input == null | input == "") {
            throw new RuntimeException("Invalid value or date");
        }
        String[] analise = input.split(" ");
        generateDateActual(dataFormat);
        if (analise.length > 1) {
            isRightDateAccordingConventions(input);
            managerInputs();
            return getResult();
        } else {
            if (isValidateFormatAndDate(input)) {
                return resultRightFormat(input);
            }
            onlyWordInput(input);
            managerInputs();
            return getResult();
        }
    }

    /**
     * Convert a string to data.
     * This convert string which contains a int and string according
     * of enum DateFormatInput.
     *
     * @param input is value which will convert to date
     */
    private void isRightDateAccordingConventions(final String input) {
        String[] divide = input.toLowerCase().split(" ", 2);
        dates = Integer.parseInt(divide[0]);
        String fillUpLowBar = divide[1].replace(' ', '_');
        dateFormat = DateFormatInput.valueOf(fillUpLowBar);
        if (dateFormat.isSingular() && dates != 1) {
            throw new RuntimeException("The value is incorrectly has to be in plural");
        }
        if (!dateFormat.isSingular() && dates == 1) {
            throw new RuntimeException("The value is incorrectly has to be in singular");
        }
        if (input.contains("-")) {
            throw new RuntimeException("The value is incorrectly entered or has negative number");
        }
        if (fillUpLowBar.contains("ago")) {
            dates = -dates;
        }
    }

    /**
     * Convert a string to data.
     * Only for 3 word, TODAY, YESTERDAY and TOMORROW.
     *
     * @param input input is value which will convert to date
     */
    private void onlyWordInput(final String input) {
        if (input.equals("TODAY")) {
            dates = 0;
            dateFormat = DateFormatInput.valueOf(input);
            return;
        }

        if (input.equals("YESTERDAY")) {
            dates = -1;
            dateFormat = DateFormatInput.valueOf(input);
            return;
        }

        if (input.equals("TOMORROW")) {
            dates = 1;
            dateFormat = DateFormatInput.valueOf(input);
            return;
        }
        throw new RuntimeException("The value is not valid, try today, yesterday and tomorrow");
    }

    /**
     * Generates actual date.
     *
     * @param dataFormat is format of data
     * @return a string with actual date
     */
    public String generateDateActual(final String dataFormat) {
        java.text.DateFormat dateFormat = new SimpleDateFormat(dataFormat);
        date = new Date();
        dateActualComplete = dateFormat.format(date);
        setCalendarFormat();
        return dateActualComplete;
    }

    /**
     * Sets calendar according of string.
     */
    private void setCalendarFormat() {
        calendarDate = Calendar.getInstance();
    }

    /**
     * Sets date according requirement of string.
     */
    private void managerInputs() {
        if ("year".equals(dateFormat.getValue())) {
            calendarDate.add(Calendar.YEAR, dates);
        }
        if ("month".equals(dateFormat.getValue())) {
            calendarDate.add(Calendar.MONTH, dates);
        }
        if ("date".equals(dateFormat.getValue())) {
            calendarDate.add(Calendar.DATE, dates);
        }
        if ("hour".equals(dateFormat.getValue())) {
            calendarDate.add(Calendar.HOUR, dates);
        }
        if ("minute".equals(dateFormat.getValue())) {
            calendarDate.add(Calendar.MINUTE, dates);
        }
        if ("second".equals(dateFormat.getValue())) {
            calendarDate.add(Calendar.SECOND, dates);
        }
    }

    /**
     * Gets result of string input.
     *
     * @return a date object.
     */
    private Date getResult() {
        return calendarDate.getTime();
    }

    /**
     * Verify the format and convert string to data.
     *
     * @param dateString is the string with a date format
     * @return a Date object
     * @throws ParseException if don't convert correctly
     */
    private Date resultRightFormat(final String dateString) throws ParseException {
        DateFormat format = new SimpleDateFormat(dataFormat);
        return format.parse(dateString);
    }

    /**
     * Verify is date is right format.
     *
     * @param dateString is the string with a date format
     * @return boolean if is validate date
     */
    private boolean isValidateFormatAndDate(final String dateString) {
        Pattern pat = Pattern.compile("^(0?[1-9]|1[012])[/-](0?[1-9]|[12][0-9]|3[01])[/-]((19|20)\\d\\d)$");
        Matcher mat = pat.matcher(dateString);
        return mat.matches();
    }
}
