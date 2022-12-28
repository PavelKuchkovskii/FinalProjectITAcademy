package org.kucher.itacademyfitness.app.service;

import org.kucher.itacademyfitness.app.dao.api.IRecipeDao;
import org.kucher.itacademyfitness.app.dao.entity.Recipe;
import org.kucher.itacademyfitness.app.service.api.IRecipeService;
import org.kucher.itacademyfitness.app.dao.entity.builders.RecipeBuilder;
import org.kucher.itacademyfitness.app.service.dto.RecipeDTO;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RecipeService implements IRecipeService {

    private IRecipeDao dao;
    private ModelMapper mapper;

    public RecipeService(IRecipeDao dao, ModelMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public RecipeDTO create(RecipeDTO dto) {
        dto.setId(UUID.randomUUID());
        dto.setDtCreate(LocalDateTime.now());
        dto.setDtUpdate(dto.getDtCreate());

        if(validate(dto)) {

            Recipe recipe = RecipeBuilder
                    .create()
                    .setId(dto.getId())
                    .setDtCreate(dto.getDtCreate())
                    .setDtUpdate(dto.getDtUpdate())
                    .setTitle(dto.getTitle())
                    .setComposition(dto.getComposition())
                    .build();

            dao.save(recipe);
        }

        return dto;
    }

    @Override
    public RecipeDTO read(long id) {
        return null;
    }

    @Override
    public Page<RecipeDTO> get(int page, int itemsPerPage) {
        Pageable pageable = PageRequest.of(page, itemsPerPage);
        Page<Recipe> recipes = dao.findAll(pageable);

        return new PageImpl<>(recipes.get().map(this::mapToDTO)
                .collect(Collectors.toList()), pageable, recipes.getTotalElements());
    }

    @Override
    public RecipeDTO update(long id, LocalDateTime dtUpdate, RecipeDTO dto) {
        return null;
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {

    }

    @Override
    public boolean validate(RecipeDTO dto) {
        return true;
    }

    @Override
    public RecipeDTO mapToDTO(Recipe recipe) {
        return mapper.map(recipe, RecipeDTO.class);
    }

    @Override
    public Recipe mapToEntity(RecipeDTO entity) {
        return null;
    }
}
