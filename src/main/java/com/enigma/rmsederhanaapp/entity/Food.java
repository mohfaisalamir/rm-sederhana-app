package com.enigma.rmsederhanaapp.entity;

public class Food {
    private Integer id;
    private String name;
    private Long price;

    public Food(Integer id, String name, Long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Food() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
