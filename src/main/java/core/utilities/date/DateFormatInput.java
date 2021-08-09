package core.utilities.date;

public enum DateFormatInput {
    years_ago("year", false),
    months_ago("month", false),
    days_ago("date", false),
    hours_ago("hour", false),
    minutes_ago("minute", false),
    seconds_ago("second", false),
    years_from_now("year", false),
    months_from_now("month", false),
    days_from_now("date", false),
    hours_from_now("hour", false),
    minutes_from_now("minute", false),
    seconds_from_now("second", false),
    year_ago("year", true),
    month_ago("month", true),
    day_ago("date", true),
    hour_ago("hour", true),
    minute_ago("minute", true),
    second_ago("second", true),
    year_from_now("year", true),
    month_from_now("month", true),
    day_from_now("date", true),
    hour_from_now("hour", true),
    minute_from_now("minute", true),
    second_from_now("second", true),
    TODAY("date", true),
    YESTERDAY("date", true),
    TOMORROW("date", true);

    private String value;
    private boolean isSingular;

    DateFormatInput(final String value, boolean isSingular) {
        this.value = value;
        this.isSingular = isSingular;
    }

    public String getValue() {
        return value;
    }

    public void setValue(final String value) {
        this.value = value;
    }

    public boolean isSingular() {
        return isSingular;
    }

    public void setSingular(boolean singular) {
        isSingular = singular;
    }
}
