package pojo;

import java.util.List;

public class Item {
    private String sku;
    private String name;
    private String brand;
    private Price price;
    private String category;
    private int quantity;
    private List<String> subcategory;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<String> getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(List<String> subcategory) {
        this.subcategory = subcategory;
    }
}
