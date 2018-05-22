package com.kpi.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name="Ingredient")
@Table(name="ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column(name="Name")
    private  String Name;
    @Column(name = "NumberCalories", nullable = false)
    private Double NumberCalories;
    private double Price;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="typeIngredient_id")
    private TypeIngredient typeIngredient;
    public Ingredient(String name, Double numberCalories, double price){
        this.Name = name;
        this.NumberCalories = numberCalories;
        this.Price = price;
    }

    public Ingredient(){

    }
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name = "salads_ingredients",
            joinColumns = @JoinColumn(name = "ingredient_id"),
            inverseJoinColumns = @JoinColumn(name = "salad_id")
    )
    private Set<Salad> salads = new HashSet<>();

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getNumberCalories() {
        return NumberCalories;
    }

    public void setNumberCalories(Double numberCalories) {
        NumberCalories = numberCalories;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

    public void setTypeIngredient(TypeIngredient typeIngredient) {
        this.typeIngredient = typeIngredient;
    }

    public Set<Salad> getSalads() {
        return salads;
    }

    public void setSalads(Set<Salad> salads) {
        this.salads = salads;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", NumberCalories=" + NumberCalories +
                ", Price=" + Price +
                ", typeIngredient=" + typeIngredient+
                '}';
    }
}
