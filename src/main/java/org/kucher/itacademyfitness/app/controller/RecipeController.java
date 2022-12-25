package org.kucher.itacademyfitness.app.controller;

import org.kucher.itacademyfitness.app.service.api.IRecipeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private IRecipeService service;

    public RecipeController(IRecipeService service) {
        this.service = service;
    }



}
