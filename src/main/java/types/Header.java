package types;

public enum Header implements Types{
    HEADER(".//div[contains(text(),'{{pattern}}')] | .//span[contains(text(),'{{pattern}}')]"),

    LABEL(".//label[contains(text(),'{{pattern}}')]"),

    COLUMN(".//tr/td['{{pattern}}']/descendant::span[@class='alias']");
    private String title;


    Header(String title) {
        this.title = title;

    }


    public String getTitle() {
        return title;
    }
}
