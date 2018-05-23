package com.kpi.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity(name="Salad")
@Table(name = "salads")
public class Salad{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Title;

    @ManyToMany(mappedBy = "salads")
    private Set<Ingredient> ingredientSet = new HashSet<>();

    public void addIngredient(Ingredient tag) {
        ingredientSet.add(tag);
        tag.getSalads().add(this);
    }

    public void removeTag(Ingredient tag) {
        ingredientSet.remove(tag);
        tag.getSalads().remove(this);
    }

    public Set<Ingredient> getIngredients() {
        return ingredientSet;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredientSet = ingredients;
    }

    public String getTitle() {
        return Title;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setTitle(String name) {
        this.Title = name;
    }

    public Long getId() {
        return Id;
    }

    public double countAndGetTotalPrice(){
        return this.getIngredients().stream().mapToDouble(Ingredient::getPrice).sum();
    }

    public double countAndGetTotalCalories(){
       return  this.getIngredients().stream().mapToDouble(Ingredient::getNumberCalories).sum();
    }

    @Override
    public String toString() {
        return "Salad{" +
                "Id=" + Id +
                ", Title='" + Title + '\'' +
                ", ingredientSet=" +
                '}';
    }
}
