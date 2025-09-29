package types;

public enum Fields implements Types {
    INPUT(".//div[contains(text(),'{{pattern}}')] | .//input[@placeholder='{{pattern}}']","ПОЛЕ"),

    LOGPASSINPUT(".//input[contains(@placeholder,'{{pattern}}')]", "ЛОГИНПАРОЛЬ"),

    INPUTERROR("//label[normalize-space(.)='{{pattern}}' ]/following::input[1 and @class[contains(.,'error')]]", ""),

    SELECTFIELD(".//label[contains(.,'{{pattern}}')]/following::div/div[@class[contains(.,'btn-group ')]] | .//li[contains(.,'{{pattern}}')]" ,"СПИСОК");
    private String title;
    private String name;


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
