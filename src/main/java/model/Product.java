package model;

public class Product {
    private String description;
    private double price;
    private int stock; // Estoque

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isAvailable(int quantity) {
        return stock >= quantity; // Verifica se o estoque é suficiente
    }

    public void reduceStock(int quantity) {
        if (isAvailable(quantity)) {
            this.stock -= quantity; // Reduz o estoque
        }
    }
}
