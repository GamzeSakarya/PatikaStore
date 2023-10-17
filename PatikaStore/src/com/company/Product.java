package com.company;


public class Product {

    private  int id;
    private int  amountOfStock, storage,RAM;
    private String name;
    private Brand brand;
    private double price, screenSize, discountRate;


    public Product(int id, double price, double discountRate, int amountOfStock, int storage, double screenSize, int RAM,  String name, Brand brand) {
        this.id = id;
        this.price = price;
        this.discountRate = discountRate;
        this.amountOfStock = amountOfStock;
        this.storage = storage;
        this.screenSize = screenSize;
        this.RAM = RAM;
        this.brand = brand;
        this.name = name;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmountOfStock() {
        return amountOfStock;
    }

    public void setAmountOfStock(int amountOfStock) {
        this.amountOfStock = amountOfStock;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
}