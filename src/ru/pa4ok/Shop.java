package ru.pa4ok;

import java.util.ArrayList;
import java.util.List;

public class Shop
{
    private List<Product> products = new ArrayList<>();

    /*public Shop(List<Product> products) {
        this.products = products;
    }

    public Shop() {
        this.products = new ArrayList<>();
    }*/

    public Shop(Product... products)
    {
        for(Product p : products) {
            this.products.add(p);
        }
    }

    @Override
    public String toString() {
        return "Shop{" +
                "products=" + products +
                '}';
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public static void main(String[] args)
    {
       /* Shop shop = new Shop();
        shop.getProducts().add(new Product("erwgpijroi"));
        System.out.println(shop);*/

        Shop shop = new Shop(
                new Product("rgggerretgret"),
                new Product("ggre"),
                new Product("rgeger"),
                new Product("gre"),
                new Product("76u67")
        );
        System.out.println(shop);
    }
}
