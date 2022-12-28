package org.kucher.itacademyfitness.app.controller;

import org.kucher.itacademyfitness.app.service.api.IJournalFoodService;
import org.kucher.itacademyfitness.app.service.dto.JournalFoodDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/journal/food")
public class JournalFoodController {

    private IJournalFoodService service;

    public JournalFoodController(IJournalFoodService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<JournalFoodDTO> doPost(@RequestBody JournalFoodDTO dto) {
        JournalFoodDTO created = this.service.create(dto);

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

}
