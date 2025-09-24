package types;

public enum Header implements Types{
    HEADER(".//div[contains(text(),'{{pattern}}')] | .//span[contains(text(),'{{pattern}}')]"),

    LABEL(".//div[contains(text(),'{{pattern}}')] |.//span[contains(text(),'{{pattern}}')] | .//label[contains(text(),'{{pattern}}')] | .//h3[contains(text(),'{{pattern}}')]"),

    COLUMN(".//tr/td['{{pattern}}']/descendant::span[@class='alias']");
    private String title;


    Header(String title) {
        this.title = title;

    }


    public String getTitle() {
        return title;
    }
}
