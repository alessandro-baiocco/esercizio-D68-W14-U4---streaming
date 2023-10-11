package market;

import java.util.Random;

public class Product {
    Random rnd = new Random();
    private long id;
    private String name;
    private String category;
    private Double price;


    public Product(String name, String category, Double price) {
        this.id = rnd.nextLong(100, 199);
        this.name = name;
        this.category = category;
        this.price = price;
    }

    //getters and setters
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
