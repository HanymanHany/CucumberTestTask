package constants.pages;

/** Path urls For Merchant **/
public enum PathUrl {
    login("/admin/login"),
    players("/user/player/admin"),
    ;

    private String value;
    private PathUrl(String value) {
        this.value = value; }

    public String getPath(){
        return value;
    }
}
