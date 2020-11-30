package ca.gbc.comp3074.guide;

import java.io.Serializable;

public class Place implements Serializable {
    private Integer placeId;
    private String name;
    private String address;
    private String description;
    private String phone;
    private String tag;
    private float rating;



    public Place(Integer placeId, String name, String address, String description, String phone, String tag, float rating) {
        this.placeId = placeId;
        this.name = name;
        this.address = address;
        this.description = description;
        this.phone = phone;
        this.tag = tag;
        this.rating = rating;
    }

    public Integer getPlaceId() {
        return placeId;
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
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", phone='" + phone + '\'' +
                ", tag='" + tag + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
