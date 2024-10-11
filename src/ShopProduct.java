public class ShopProduct {
    private final String name;
    private double price;
    private int rating;
    public final int ratingThreshold = 3;

    public ShopProduct(String name, double price, int rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice (Double price){
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating){
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "ShopProduct{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                '}';
    }
}
