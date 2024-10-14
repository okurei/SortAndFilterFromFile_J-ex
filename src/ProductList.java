import java.io.*;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ProductList {
    public final int ratingThreshold = 3;
    int counter = 0;
    String pathListTxt = "src/productList.txt";
    File productListTxt = new File(pathListTxt);
    LinkedList<ShopProduct> productLinkedList = new LinkedList<>();


    public void readerForProductList(){
        if (productListTxt.exists() && productListTxt.canRead()){
            try (BufferedReader reader = new BufferedReader(new FileReader(productListTxt))){
                String product;
                do {
                    product = reader.readLine();
                    if (product != null) {
                        String[] productsArray = product.split(" ");
                        String productName = productsArray[0];
                        double productPrice;
                        int productRating;
                        try {
                            productPrice = Double.parseDouble(productsArray[1]);
                        } catch (NumberFormatException e) {
                            System.out.println("Error with price " + counter);
                            productPrice = -1;
                        }
                        try {
                            productRating = Integer.parseInt(productsArray[2]);
                        } catch (NumberFormatException e) {
                            System.out.println("Error with rating " + counter);
                            productRating = -1;
                        }
                        if (productName != null && productPrice != -1 && productRating != -1) {
                            ShopProduct shopProduct = new ShopProduct(productName, productPrice, productRating);
                            productLinkedList.add(shopProduct);
                        } else {
                            System.out.println("Error with the creation of the class " + counter);
                        }
                    }

                    counter++;
                } while(product != null);
            }catch (IOException e){
                System.out.println("File not read");
            }
        }
    }
    public void compareProducts(){
        readerForProductList();

        productLinkedList.sort(Comparator.comparing(ShopProduct::getPrice).thenComparing(ShopProduct::getRating));

        for (ShopProduct product : productLinkedList)
            System.out.println(product.toString());

        List<String> endList = productLinkedList.stream()
                .filter(shopProduct -> shopProduct.getRating() > ratingThreshold)
                .map(ShopProduct :: toString)
                .toList();

        System.out.println("\n");
        endList.forEach(System.out::println);
        System.out.println("\n");
    }

}
