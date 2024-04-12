package sem2.sep2.shared.room;

public class Room {
    private String bedType;
    private int price;

    public Room(String bedType, int price) {
        this.bedType = bedType;
        this.price = price;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public void reserve(){

    }
   // public void

}
