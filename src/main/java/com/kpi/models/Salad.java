package com.kpi.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "salads")
public class Salad{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Title;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "salads_ingredients",
            joinColumns = @JoinColumn(name = "salad_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredients_id")
    )
    private Set<Ingredient> ingredientSet;

    public Set<Ingredient> getIngredients() {
        return ingredientSet;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredientSet = ingredients;
    }

    public String getName() {
        return Title;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setName(String name) {
        this.Title = name;
    }

    public Long getId() {
        return Id;
    }

    @Override
    public String toString() {
        return "Salad{" +
                "id=" + Id +
                ", Title='" + Title + '\'' +
                ", ingredients="  +
                '}';
    }
}
