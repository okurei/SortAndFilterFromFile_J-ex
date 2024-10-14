public class ShopProduct {
    private final String name;
    private final double price;
    private final int rating;

    public ShopProduct(String name, double price, int rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }
    public int getRating() {
        return rating;
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
