package salesforce.utilities;

public final class Converter {

    private Converter() {
    }

    /**
     * Convert double to string with format salesforce.
     *
     * @param number will converter
     * @return string with format salesforce.
     */
    public static String converterIntToString(double number) {
        return String.valueOf(number).replace('.', ',');
    }

    /**
     * Convert String to Url enum.
     *
     * @param namePage is string with name page
     * @param mode is classic or Lightning to salesforce
     * @return enum type Urls
     */
    public static Urls converterStringToEnum(final String namePage, final String mode) {
        return Urls.valueOf((namePage + "_" + mode).replace(' ', '_').toUpperCase());
    }
}
