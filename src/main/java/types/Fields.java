package types;

public enum Fields implements Types {
    INPUT(".//div[contains(text(),'{{pattern}}')] | .//span[contains(text(),'{{pattern}}')]","ПОЛЕ"),

    LOGPASSINPUT(".//input[contains(@placeholder,'{{pattern}}')]", "ЛОГИНПАРОЛЬ"),

    INPUTERROR("//label[normalize-space(.)='{{pattern}}' ]/following::input[1 and @class[contains(.,'error')]]", "");
    private String title;
    private String name;

    Fields(String title) {
        this.title = title;
        this.name = null;
    }

    Fields(String title, String name) {
        this.title = title;
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }
}
