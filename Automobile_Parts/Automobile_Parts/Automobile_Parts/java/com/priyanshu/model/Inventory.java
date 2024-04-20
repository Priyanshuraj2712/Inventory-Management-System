package com.priyanshu.model;

public class Inventory {
    private int id;
    private int supplierId;
    private int warehouseId;
    private double price;
    private String category;
    private String name;
    private int quantity;

    // Constructors
    public Inventory() {
    }

    public Inventory(int id, int supplierId, int warehouseId, double price, String category, String name, int quantity) {
        this.id = id;
        this.supplierId = supplierId;
        this.warehouseId = warehouseId;
        this.price = price;
        this.category = category;
        this.name = name;
        this.quantity = quantity;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
