package apache.org.utils;

public enum CellPhoneCompatibility {
    APPLE_IPHONE("Apple iPhone"),
    GOOGLE("Google"),
    LG("LG"),
    SAMSUNG("Samsung");


    private final String value;

    public String getValue() {
        return value;
    }

    CellPhoneCompatibility(String value) {
        this.value = value;
    }
}
