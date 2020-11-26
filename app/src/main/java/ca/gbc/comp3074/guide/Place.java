package ca.gbc.comp3074.guide;

public class Place {
    private String name;
    private String address;
    private String description;
    private String phone;

    public Place(String name, String address, String description, String phone) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
