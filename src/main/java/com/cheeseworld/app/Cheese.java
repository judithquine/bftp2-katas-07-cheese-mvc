package com.cheeseworld.app;

import javax.persistence.*;

@Entity
public class Cheese {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private double price;
    private boolean stinky;
    private boolean french;
    private boolean discount;

    public Cheese() {

    }

    public Cheese(String info) {
        this.name = info.split("\\|")[0];
        this.stinky = info.contains("stinky") || info.contains("smell");
        this.french = info.contains("french");
        this.discount = info.contains("discount");
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public double getPrice(){ return price;}
    public void setPrice(double v) {
        if (!this.discount) this.price = 5.0;
        else this.price = 4.5;
    }

    public boolean isStinky() { return stinky; }

    public boolean isFrench() { return french; }

    public boolean hasDiscount() {return discount; }
}
