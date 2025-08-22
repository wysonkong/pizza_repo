package com.example.pizza_repo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service //lets you call it as a service in controller through Spring
public class PizzaService {

    private final ArrayList<Pizza> pizzaList = new ArrayList<Pizza>();


    public Pizza savePizza(Pizza pizza) {
        pizzaList.add(pizza);
        return pizza;
    }

    public ArrayList<Pizza> getPizzaList() {
        return pizzaList;
    }

    public Pizza getPizzaByID(Long id) {
        for(Pizza pizza : pizzaList) {
            if(pizza.getId().equals(id)) {
                return pizza;
            }
        }
        throw new RuntimeException("Could not find a pizza by this ID:" + id);
    }

    public ArrayList<Pizza> getPizzaByToppings(String toppings) {
        ArrayList<Pizza> toppingList = new ArrayList<Pizza>();
        for(Pizza pizza : getPizzaList()) {
            if(pizza.getToppings().equals(toppings)) {
                toppingList.add(pizza);
            }
        }
        if(toppingList.isEmpty()){
            throw new RuntimeException("You big dumbass");
        }
        return toppingList;
    }
}
