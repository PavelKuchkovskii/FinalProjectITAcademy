package org.kucher.itacademyfitness.app.controller;

import org.kucher.itacademyfitness.app.service.api.IJournalFoodService;
import org.kucher.itacademyfitness.app.service.dto.JournalFoodDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/profile")
public class JournalFoodController {

    private IJournalFoodService service;

    public JournalFoodController(IJournalFoodService service) {
        this.service = service;
    }

    @GetMapping("/{uuid_profile}/journal/food")
    public ResponseEntity<Page<JournalFoodDTO>> doGet(@PathVariable("uuid_profile") UUID uuid,
                                                      @RequestParam int page, @RequestParam int size) {

        Page<JournalFoodDTO> journalFoodDTOS = this.service.get(page, size, uuid);

        return new ResponseEntity<>(journalFoodDTOS, HttpStatus.CREATED);
    }

    @PostMapping("/{uuid_profile}/journal/food")
    public ResponseEntity<JournalFoodDTO> doPost(@PathVariable("uuid_profile") UUID uuid,
                                                 @Valid @RequestBody JournalFoodDTO dto) {
        JournalFoodDTO created = this.service.create(dto, uuid);

        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    /*@PutMapping("/{uuid}/dt_update/{dt_update}")
    public ResponseEntity<JournalFoodDTO> doPut(@PathVariable("uuid") UUID uuid,
                                           @PathVariable("dt_update") String dt_update,
                                           @RequestBody JournalFoodDTO dto) {

        LocalDateTime dtUpdate = LocalDateTime.ofInstant(Instant.ofEpochMilli(Long.parseLong(dt_update)), ZoneId.of("UTC"));

        JournalFoodDTO updated = this.service.update(uuid, dtUpdate, dto);

        return new ResponseEntity<>(updated, HttpStatus.CREATED);
    }*/

}
