package utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;

public class CalendarManager {
    private String dateActualComplete;
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
    public Date converterStringToDate(final String input) {
        try {
            if (isOnlyWord(input)) {
                managerInputs();
                return result();
            }
            if (isRightDateAccordingConventions(input)) {
                managerInputs();
                return result();
            }
            return resultRightFormat(input);
        } catch (ParseException e) {
            throw new RuntimeException("The value is not valid");
        }
    }

    /**
     * Convert a string to data.
     * This convert string which contains a int and string according
     * of enum DateFormatInput.
     *
     * @param input is value which will convert to date
     * @return object type Date
     */
    private boolean isRightDateAccordingConventions(final String input) {
        try {
            String[] divide = input.split(" ", 2);
            dates = Integer.parseInt(divide[0]);
            String fillUpLowBar = divide[1].replace(' ', '_');
            dateFormat = DateFormatInput.valueOf(fillUpLowBar);
            if ((dateFormat.isSingular() && dates != 1) | (!dateFormat.isSingular() && dates == 1) | dates < 0) {
                return false;
            }
            if (fillUpLowBar.contains("ago")) {
                dates = -dates;
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Convert a string to data.
     * Only for 3 word, TODAY, YESTERDAY and TOMORROW.
     *
     * @param input input is value which will convert to date
     * @return object type Date
     */
    private boolean isOnlyWord(final String input) {
        generateDateActual();
        if (input.equals("TODAY")) {
            dates = 0;
            dateFormat = DateFormatInput.valueOf(input);
            return true;
        }

        if (input.equals("YESTERDAY")) {
            dates = -1;
            dateFormat = DateFormatInput.valueOf(input);
            return true;
        }

        if (input.equals("TOMORROW")) {
            dates = 1;
            dateFormat = DateFormatInput.valueOf(input);
            return true;
        }
        return false;
    }

    /**
     * Generates actual date.
     */
    private void generateDateActual() {
        java.text.DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        date = new Date();
        dateActualComplete = dateFormat.format(date);
        setCalendarFormat();
    }

    /**
     * Sets calendar according of string.
     */
    private void setCalendarFormat() {
        calendarDate = Calendar.getInstance();
        calendarDate.setTime(date);
    }

    /**
     * Sets date according requirement of string.
     */
    private void managerInputs() {
        if ("year" == dateFormat.getValue()) {
            calendarDate.add(Calendar.YEAR, dates);
        }
        if ("month" == dateFormat.getValue()) {
            calendarDate.add(Calendar.MONTH, dates);
        }
        if ("date" == dateFormat.getValue()) {
            calendarDate.add(Calendar.DATE, dates);
        }
        if ("hour" == dateFormat.getValue()) {
            calendarDate.add(Calendar.HOUR, dates);
        }
        if ("minute" == dateFormat.getValue()) {
            calendarDate.add(Calendar.MINUTE, dates);
        }
        if ("second" == dateFormat.getValue()) {
            calendarDate.add(Calendar.SECOND, dates);
        }
    }

    /**
     * Gets result of string input.
     *
     * @return a date object.
     */
    private Date result() {
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
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        return format.parse(dateString);
    }
}
