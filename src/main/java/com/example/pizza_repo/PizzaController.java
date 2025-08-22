package com.example.pizza_repo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pizza")
public class PizzaController { ;


    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping
    public Pizza createPizza(@RequestBody Pizza newPizza) {
        return pizzaService.savePizza(newPizza);
        // creates the pizza and allows you to see the pizza that you created instead of creating a new pizza with set and then using get
    }

    @GetMapping
    public ResponseEntity<ArrayList<Pizza>> findPizza() {
        return new ResponseEntity<>(pizzaService.getPizzaList(), HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public Pizza findPizzaByID(@PathVariable Long id) {
        return pizzaService.getPizzaByID(id);
    }
}
