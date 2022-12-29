package org.kucher.itacademyfitness.app.service;

import org.kucher.itacademyfitness.app.dao.api.IJournalFoodDao;
import org.kucher.itacademyfitness.app.dao.entity.JournalFood;
import org.kucher.itacademyfitness.app.dao.entity.Product;
import org.kucher.itacademyfitness.app.dao.entity.Recipe;
import org.kucher.itacademyfitness.app.dao.entity.builders.JournalFoodBuilder;
import org.kucher.itacademyfitness.app.dao.entity.builders.RecipeBuilder;
import org.kucher.itacademyfitness.app.service.api.IJournalFoodService;
import org.kucher.itacademyfitness.app.service.dto.JournalFoodDTO;
import org.kucher.itacademyfitness.app.service.dto.RecipeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class JournalFoodService implements IJournalFoodService {

    private IJournalFoodDao dao;
    private ModelMapper mapper;

    public JournalFoodService(IJournalFoodDao dao, ModelMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }


    @Override
    public JournalFoodDTO create(JournalFoodDTO dto) {
        dto.setUuid(UUID.randomUUID());
        dto.setDtCreate(LocalDateTime.now());
        dto.setDtUpdate(dto.getDtCreate());

        if(validate(dto)) {
            JournalFood journalFood = JournalFoodBuilder
                    .create()
                    .setUuid(dto.getUuid())
                    .setDtCreate(dto.getDtCreate())
                    .setDtUpdate(dto.getDtUpdate())
                    .setDtSupply(dto.getDtSupply())
                    .setRecipe(dto.getRecipe())
                    .setProduct(dto.getProduct())
                    .setWeight(dto.getWeight())
                    .build();

            dao.save(journalFood);
        }

        return dto;
    }

    @Override
    public JournalFoodDTO read(UUID uuid) {
        Optional<JournalFood> oProduct = dao.findById(uuid);
        return oProduct.map(this::mapToDTO).orElse(null);
    }

    @Override
    public Page<JournalFoodDTO> get(int page, int itemsPerPage) {
        Pageable pageable = PageRequest.of(page, itemsPerPage);
        Page<JournalFood> recipes = dao.findAll(pageable);

        return new PageImpl<>(recipes.get().map(this::mapToDTO)
                .collect(Collectors.toList()), pageable, recipes.getTotalElements());
    }

    @Override
    public JournalFoodDTO update(UUID uuid, LocalDateTime dtUpdate, JournalFoodDTO dto) {
        JournalFoodDTO journalFoodDTO = this.read(uuid);
        journalFoodDTO.setDtUpdate(LocalDateTime.now());
        journalFoodDTO.setDtSupply(dto.getDtSupply());
        journalFoodDTO.setRecipe(dto.getRecipe());
        journalFoodDTO.setProduct(dto.getProduct());
        journalFoodDTO.setWeight(dto.getWeight());

        JournalFood journalFood = JournalFoodBuilder
                .create()
                .setUuid(journalFoodDTO.getUuid())
                .setDtCreate(journalFoodDTO.getDtCreate())
                .setDtUpdate(journalFoodDTO.getDtUpdate())
                .setDtSupply(journalFoodDTO.getDtSupply())
                .setRecipe(journalFoodDTO.getRecipe())
                .setProduct(journalFoodDTO.getProduct())
                .setWeight(journalFoodDTO.getWeight())
                .build();

        dao.save(journalFood);

        return journalFoodDTO;
    }

    @Override
    public void delete(UUID uuid, LocalDateTime dtUpdate) {

    }

    @Override
    public boolean validate(JournalFoodDTO dto) {
        return true;
    }

    @Override
    public JournalFoodDTO mapToDTO(JournalFood journalFood) {
        return mapper.map(journalFood, JournalFoodDTO.class);
    }
}
