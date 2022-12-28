package org.kucher.itacademyfitness.app.controller;

import org.kucher.itacademyfitness.app.service.api.IRecipeService;
import org.kucher.itacademyfitness.app.service.dto.RecipeDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    private IRecipeService service;

    public RecipeController(IRecipeService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<RecipeDTO>> doGet(@RequestParam int page, @RequestParam int size) {

        Page<RecipeDTO> recipeDTOS = this.service.get(page, size);

        return new ResponseEntity<>(recipeDTOS, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<RecipeDTO> doPost(@RequestBody RecipeDTO dto) {
        RecipeDTO created = this.service.create(dto);

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }


}
