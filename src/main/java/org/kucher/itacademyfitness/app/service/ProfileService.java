package org.kucher.itacademyfitness.app.service;

import org.kucher.itacademyfitness.app.dao.api.IProfileDao;
import org.kucher.itacademyfitness.app.dao.entity.Product;
import org.kucher.itacademyfitness.app.dao.entity.Profile;
import org.kucher.itacademyfitness.app.dao.entity.User;
import org.kucher.itacademyfitness.app.dao.entity.builders.ProductBuilder;
import org.kucher.itacademyfitness.app.security.entity.UserToJwt;
import org.kucher.itacademyfitness.app.service.api.IProfileService;
import org.kucher.itacademyfitness.app.service.dto.ProfileDTO;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;
import java.util.UUID;

public class ProfileService implements IProfileService {

    private final IProfileDao dao;

    public ProfileService(IProfileDao dao) {
        this.dao = dao;
    }

    @Override
    public ProfileDTO create(ProfileDTO dto) {
        dto.setUuid(UUID.randomUUID());
        dto.setDtCreate(LocalDateTime.now());
        dto.setDtUpdate(dto.getDtCreate());

        UserToJwt userToJwt = (UserToJwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = new User(userToJwt.getUuid(), userToJwt.getDtCreate(), userToJwt. getDtUpdate());

        //user
        if(validate(dto)) {

            Product product = ProductBuilder
                    .create()
                    .setUuid(dto.getUuid())
                    .setDtCreate(dto.getDtCreate())
                    .setDtUpdate(dto.getDtUpdate())
                    .setTitle(dto.getTitle())
                    .setWeight(dto.getWeight())
                    .setCalories(dto.getCalories())
                    .setFats(dto.getFats())
                    .setCarbohydrates(dto.getCarbohydrates())
                    .setProteins(dto.getProteins())
                    .build();

            dao.save(product);
        }

        return dto;
    }

    @Override
    public ProfileDTO read(UUID uuid) {
        return null;
    }

    @Override
    public Page<ProfileDTO> get(int page, int itemsPerPage) {
        return null;
    }

    @Override
    public ProfileDTO update(UUID uuid, LocalDateTime dtUpdate, ProfileDTO dto) {
        return null;
    }

    @Override
    public void delete(UUID uuid, LocalDateTime dtUpdate) {

    }

    @Override
    public boolean validate(ProfileDTO dto) {
        return false;
    }

    @Override
    public ProfileDTO mapToDTO(Profile profile) {
        return null;
    }
}
