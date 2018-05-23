package com.kpi.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "typeingredients")
public class TypeIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Value;

    @OneToMany(fetch = FetchType.LAZY, mappedBy="typeIngredient")
    private List<Ingredient> ingredientList;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    @Override
    public String toString() {
        return getValue();
    }
}
