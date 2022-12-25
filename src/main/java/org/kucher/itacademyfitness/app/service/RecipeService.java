package org.kucher.itacademyfitness.app.service;

import org.kucher.itacademyfitness.app.dao.api.IRecipeDao;
import org.kucher.itacademyfitness.app.dao.entity.Recipe;
import org.kucher.itacademyfitness.app.service.api.IRecipeService;
import org.kucher.itacademyfitness.app.service.builders.RecipeBuilder;
import org.kucher.itacademyfitness.app.service.dto.RecipeDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class RecipeService implements IRecipeService {

    private IRecipeDao dao;

    public RecipeService(IRecipeDao dao) {
        this.dao = dao;
    }

    @Override
    public RecipeDTO create(RecipeDTO dto) {
        dto.setUuid(UUID.randomUUID());
        dto.setDtCreate(LocalDateTime.now());
        dto.setDtUpdate(dto.getDtCreate());

        Recipe recipe = RecipeBuilder
                .create()
                .setUuid(dto.getUuid())
                .setDtCreate(dto.getDtCreate())
                .setDtUpdate(dto.getDtUpdate())
                .setTitle(dto.getTitle())
                .setComposition(dto.getComposition())
                .build();

        dao.save(recipe);

        return dto;
    }

    @Override
    public RecipeDTO read(long id) {
        return null;
    }

    @Override
    public List<RecipeDTO> get() {
        return null;
    }

    @Override
    public RecipeDTO update(long id, LocalDateTime dtUpdate, RecipeDTO dto) {
        return null;
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {

    }
}
