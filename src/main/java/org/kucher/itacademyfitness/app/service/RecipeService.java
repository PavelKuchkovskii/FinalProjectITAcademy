package org.kucher.itacademyfitness.app.service;

import org.kucher.itacademyfitness.app.config.exceptions.api.AlreadyChangedException;
import org.kucher.itacademyfitness.app.config.exceptions.api.NotFoundException;
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
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class RecipeService implements IRecipeService {

    private final IRecipeDao dao;
    private final ModelMapper mapper;

    public RecipeService(IRecipeDao dao, ModelMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public RecipeDTO create(RecipeDTO dto) {
        dto.setUuid(UUID.randomUUID());
        dto.setDtCreate(LocalDateTime.now());
        dto.setDtUpdate(dto.getDtCreate());

        if(validate(dto)) {

            Recipe recipe = mapToEntity(dto);
            dao.save(recipe);
        }

        return dto;
    }

    @Override
    public RecipeDTO read(UUID uuid) {
        Optional<Recipe> read = dao.findById(uuid);

        if(read.isPresent()) {
            return read.map(this::mapToDTO).orElse(null);
        }
        else {
            throw new NotFoundException();
        }
    }

    @Override
    public Page<RecipeDTO> get(int page, int itemsPerPage) {
        Pageable pageable = PageRequest.of(page, itemsPerPage);
        Page<Recipe> recipes = dao.findAll(pageable);

        return new PageImpl<>(recipes.get().map(this::mapToDTO)
                .collect(Collectors.toList()), pageable, recipes.getTotalElements());
    }

    @Override
    public RecipeDTO update(UUID uuid, LocalDateTime dtUpdate, RecipeDTO dto) {
        RecipeDTO read = this.read(uuid);

        if(read.getDtUpdate().isEqual(dtUpdate)) {
            read.setDtUpdate(LocalDateTime.now());
            read.setTitle(dto.getTitle());
            read.setComposition(dto.getComposition());

            if(validate(read)) {
                Recipe recipe = mapToEntity(read);
                dao.save(recipe);
            }
            return read;
        }
        else {
            throw new AlreadyChangedException();
        }
    }

    @Override
    public void delete(UUID uuid, LocalDateTime dtUpdate) {

    }

    @Override
    public boolean validate(RecipeDTO dto) {
        if(dto.getUuid() == null) {
            throw new IllegalArgumentException("Uuid cannot be null");
        }
        else if(dto.getDtCreate() == null){
            throw new IllegalArgumentException("Date create cannot be null");
        }
        else if(dto.getDtUpdate()== null){
            throw new IllegalArgumentException("Date update cannot be null");
        }

        return true;
    }

    @Override
    public RecipeDTO mapToDTO(Recipe recipe) {
        return mapper.map(recipe, RecipeDTO.class);
    }

    @Override
    public Recipe mapToEntity(RecipeDTO dto) {
        return RecipeBuilder
                .create()
                .setUuid(dto.getUuid())
                .setDtCreate(dto.getDtCreate())
                .setDtUpdate(dto.getDtUpdate())
                .setTitle(dto.getTitle())
                .setComposition(dto.getComposition())
                .build();
    }
}
