package org.kucher.itacademyfitness.app.service;

import org.kucher.itacademyfitness.app.dao.api.IJournalFoodDao;
import org.kucher.itacademyfitness.app.dao.entity.JournalFood;
import org.kucher.itacademyfitness.app.dao.entity.Profile;
import org.kucher.itacademyfitness.app.dao.entity.builders.JournalFoodBuilder;
import org.kucher.itacademyfitness.app.service.api.IJournalFoodService;
import org.kucher.itacademyfitness.app.service.api.IProfileService;
import org.kucher.itacademyfitness.app.service.dto.JournalFoodDTO;
import org.kucher.itacademyfitness.app.service.dto.ProfileDTO;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class JournalFoodService implements IJournalFoodService {

    private final IJournalFoodDao dao;
    private final IProfileService profileService;
    private final ModelMapper mapper;

    public JournalFoodService(IJournalFoodDao dao, IProfileService profileService, ModelMapper mapper) {
        this.dao = dao;
        this.profileService = profileService;
        this.mapper = mapper;
    }


    @Override
    public JournalFoodDTO create(JournalFoodDTO dto) {
        dto.setUuid(UUID.randomUUID());
        dto.setDtCreate(LocalDateTime.now());
        dto.setDtUpdate(dto.getDtCreate());

        if(validate(dto)) {
            JournalFood journalFood = mapToEntity(dto);

            dao.save(journalFood);
        }

        return dto;
    }

    @Override
    public JournalFoodDTO create(JournalFoodDTO dto, UUID profileUuid) {
        ProfileDTO profile = profileService.read(profileUuid);
        dto.setProfile(profileService.mapToEntity(profile));
        return create(dto);
    }

    @Override
    public Page<JournalFoodDTO> get(int page, int itemsPerPage, UUID profileUuid) {
        Pageable pageable = PageRequest.of(page, itemsPerPage);
        Optional<List<JournalFood>> recipes = dao.findAllByProfile_Uuid(profileUuid);

        if(recipes.isPresent()) {
            return new PageImpl<>(recipes.get().stream().map(this::mapToDTO)
                    .collect(Collectors.toList()), pageable, recipes.get().size());
        }
        else {
            throw new RuntimeException("Journal food is empty");
        }
    }

    @Override
    public JournalFoodDTO read(UUID uuid) {
        Optional<JournalFood> oProduct = dao.findById(uuid);
        return oProduct.map(this::mapToDTO).orElse(null);
    }

    @Override
    @Deprecated
    public Page<JournalFoodDTO> get(int page, int itemsPerPage) {
        //SO BAD
        return null;
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

    @Override
    public JournalFood mapToEntity(JournalFoodDTO dto) {
        return JournalFoodBuilder
                .create()
                .setUuid(dto.getUuid())
                .setDtCreate(dto.getDtCreate())
                .setDtUpdate(dto.getDtUpdate())
                .setDtSupply(dto.getDtSupply())
                .setRecipe(dto.getRecipe())
                .setProduct(dto.getProduct())
                .setWeight(dto.getWeight())
                .setProfile(dto.getProfile())
                .build();
    }
}
