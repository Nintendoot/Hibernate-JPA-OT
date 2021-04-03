package by.nintendo.entity;

public enum Role {
    USER("User");
    private String item;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    Role(String item) {
        this.item = item;
    }
}
