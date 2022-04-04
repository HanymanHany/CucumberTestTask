package constants.endPoint;

public enum ApiEndpoint {
    V2_OAUTH2_TOKEN("/v2/oauth2/token"),
    V2_PLAYERS("/v2/players");

    private final String path;

    ApiEndpoint(String path) {
        this.path = path;
    }

    public String path() {
        return path;
    }

    public String pathAndEndpoint(int additionalPath) {
        return path + "/"+additionalPath;
    }
}
