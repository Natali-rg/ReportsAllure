package weather;

public enum Lang {
    ES("es-ES"),
    EN("en-GB"),
    PL("pl-PL");

    private String codew;

    Lang(String code) {
        this.codew = code;
    }

    public String getCode() {
        return codew;
    }
}
