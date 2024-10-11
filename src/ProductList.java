import java.io.*;
import java.util.ArrayList;

public class ProductList {
    int counter = 0;
    String pathListTxt = "src/productList.txt";
    File productListTxt = new File(pathListTxt);
    ArrayList<ShopProduct> productArrayList = new ArrayList<>();

    /*public void writerForProductList(){
        if (productListTxt.exists() && productListTxt.canWrite()){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(productListTxt))){
                writer.write("PersonalPc 999.99 4\n");
                writer.write("PersonalPc 999.99 4\n");
            }catch (IOException e){
                System.out.println("Error in writing");
            }
        }
    }*/

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
                            System.out.println("Error with price" + counter);
                            productPrice = -1;
                        }
                        try {
                            productRating = Integer.parseInt(productsArray[2]);
                        } catch (NumberFormatException e) {
                            System.out.println("Error with rating" + counter);
                            productRating = -1;
                        }
                        if (productName != null && productPrice != -1 && productRating != -1) {
                            ShopProduct shopProduct = new ShopProduct(productName, productPrice, productRating);
                            productArrayList.add(shopProduct);
                        } else {
                            System.out.println("Error with the creation of the class" + counter);
                        }
                    }

                    counter++;
                } while(product != null);
            }catch (IOException e){
                System.out.println("File not read");
            }
        }
    }

    public void printArrayList(){
        for (ShopProduct shopProduct : productArrayList) {
            System.out.println(shopProduct.toString());
        }
    }
}
