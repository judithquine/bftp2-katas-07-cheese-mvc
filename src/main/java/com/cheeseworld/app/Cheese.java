package com.cheeseworld.app;

import javax.persistence.*;

@Entity
public class Cheese {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private boolean stinky;
    private boolean french;

    public Cheese() {

    }

    public Cheese(String info) {
        this.name = info.split("\\|")[0];
        this.stinky = info.contains("stinky") || info.contains("smell");
        this.french = info.contains("french");
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

    public boolean isStinky() {
        return stinky;
    }

    public boolean isFrench() { return french; }
}
