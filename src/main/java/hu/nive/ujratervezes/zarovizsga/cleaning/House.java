package hu.nive.ujratervezes.zarovizsga.cleaning;

public class House implements Cleanable {

    private String address;
    private int area;

    private int price = 80;

    public House(String address, int area) {
        this.address = address;
        this.area = area;
    }

    @Override
    public int clean() {
        return getArea() * price;
    }

    @Override
    public String getAddress() {
        return address;
    }

    public int getArea() {
        return area;
    }

    public int getPrice() {
        return price;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
