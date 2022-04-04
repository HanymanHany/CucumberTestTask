package constants.data;

public enum TokenType {
    BASIC("Basic "),
    BEARER("Bearer ");

    private final String type;

    TokenType(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }

}
