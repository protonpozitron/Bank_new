package types;

public enum Modals implements Types{
    WINDOW("//div[@class='modal-body']/h3[contains(text(),'{{pattern}}')]/parent::div");
    private String title;
    Modals(String title) {
        this.title = title;

    }


    public String getTitle() {
        return title;
    }
}
