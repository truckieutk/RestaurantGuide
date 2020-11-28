package truckieu.com.restaurantguide;


import java.io.Serializable;

public class Place implements Serializable {
    private String name;
    private String address;
    private String description;
    private String phone;
    private String tag;
    private String rating;

    public Place(String name, String address, String description, String phone, String tag, String rating) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.phone = phone;
        this.tag = tag;
        this.rating=rating;
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

    public String getTag(){
        return tag;
    }

    public void setTag(String tag){
        this.tag=tag;
    }

    public String getRating(){
        return rating;
    }

    public void setRating(String rating){
        this.rating=rating;
    }

    @Override
    public String toString(){
        return "Name: " + name +
                "\nAddress: "+ address +
                "\nPhone: "+phone +
                "\nDescription: "+description +
                "\nTag: " + tag +
                "\nRating: " + rating;
    }
}