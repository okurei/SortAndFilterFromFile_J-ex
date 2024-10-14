public class Main {
    public static void main(String[] args) {
       ProductList productList = new ProductList();
        productList.compareProducts();
    }
}
/*
Exercise: Sorting and Filtering a List of Products
Problem:

You are working for an online store and need to manage a list of products. Each product has the following attributes:

    name (String)
    price (double)
    rating (int, from 1 to 5)

Your task is to:

    Sort the products by price (ascending order).
    If two products have the same price, sort them by rating (descending order).
    Filter out products that have a rating lower than 3.
    Output the names of the products that pass the filter, sorted according to the above criteria.

Requirements:

    Use Comparator to sort the products.
    Use Java Stream to filter and process the list.

Steps:

    Create a ShopProduct class with the necessary attributes.
    Create a list of products.
    Sort the products using Comparator based on the specified criteria (price and rating).
    Use a stream to filter the products with a rating of 3 or higher.
    Print the names of the products that remain after filtering, in the correct sorted order.

Example Input:

You have the following list of products:
Name	Price	Rating
Laptop	999.99	4
Headphones	199.99	5
Smartphone	799.99	3
Keyboard	99.99	2
Monitor	299.99	3
Expected Output:

Keyboard
Monitor
Headphones
Smartphone
Laptop

Solution Outline:

Here is a possible implementation:

java

import java.util.*;
import java.util.stream.Collectors;

class ShopProduct {
    String name;
    double price;
    int rating;

    // Constructor
    public ShopProduct(String name, double price, int rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a list of products
        List<ShopProduct> products = Arrays.asList(
                new ShopProduct("Laptop", 999.99, 4),
                new ShopProduct("Headphones", 199.99, 5),
                new ShopProduct("Smartphone", 799.99, 3),
                new ShopProduct("Keyboard", 99.99, 2),
                new ShopProduct("Monitor", 299.99, 3)
        );

        // Sort products first by price (ascending), then by rating (descending)
        Comparator<ShopProduct> comparator = Comparator
                .comparingDouble(ShopProduct::getPrice)
                .thenComparing(Comparator.comparingInt(ShopProduct::getRating).reversed());

        // Filter products with rating >= 3 and sort them using the comparator
        List<String> filteredSortedProducts = products.stream()
                .filter(product -> product.rating >= 3)  // Filter products with rating >= 3
                .sorted(comparator)                      // Sort based on comparator
                .map(ShopProduct::toString)                  // Map to product names
                .collect(Collectors.toList());           // Collect the results into a list

        // Output the product names
        filteredSortedProducts.forEach(System.out::println);
    }
}

Key Points:

    Comparator:
        Comparator.comparingDouble(ShopProduct::getPrice) sorts by price in ascending order.
        thenComparing(Comparator.comparingInt(ShopProduct::getRating).reversed()) sorts by rating in descending order if the prices are the same.

    Stream API:
        filter(product -> product.rating >= 3) filters out products with a rating below 3.
        sorted(comparator) sorts the filtered products.
        map(ShopProduct::toString) transforms the stream to contain only product names.
        collect(Collectors.toList()) collects the final product names into a list.

    Output:
        The program outputs the names of products that meet the criteria, sorted by price (ascending) and rating (descending for products with the same price).

Challenge:

You can extend this exercise by adding more functionality:

    Allow the user to input the sorting criteria dynamically (e.g., sort by rating first, then price).
    Filter products based on a price range as well.*/