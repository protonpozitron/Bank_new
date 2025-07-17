package types;

public enum Fields implements Types {
    INPUT(".//div[contains(text(),'{{pattern}}')] | .//span[contains(text(),'{{pattern}}')]"),

    LOGPASSINPUT(".//input[contains(@placeholder,'{{pattern}}')]"),

    INPUTERROR("//label[normalize-space(.)='{{pattern}}' ]/following::input[1 and @class[contains(.,'error')]]");
    private String title;

    Fields(String title) {
        this.title = title;
    }


    public String getTitle() {
        return title;
    }
}
