package org.kucher.itacademyfitness.app.service;

import org.kucher.itacademyfitness.app.dao.api.IJournalFoodDao;
import org.kucher.itacademyfitness.app.dao.api.IProductDao;
import org.kucher.itacademyfitness.app.dao.entity.JournalFood;
import org.kucher.itacademyfitness.app.dao.entity.Product;
import org.kucher.itacademyfitness.app.dao.entity.builders.JournalFoodBuilder;
import org.kucher.itacademyfitness.app.dao.entity.builders.ProductBuilder;
import org.kucher.itacademyfitness.app.service.api.IJournalFoodService;
import org.kucher.itacademyfitness.app.service.api.IProductService;
import org.kucher.itacademyfitness.app.service.dto.JournalFoodDTO;
import org.kucher.itacademyfitness.app.service.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class JournalFoodService implements IJournalFoodService {

    private IJournalFoodDao dao;

    public JournalFoodService(IJournalFoodDao dao) {
        this.dao = dao;
    }


    @Override
    public JournalFoodDTO create(JournalFoodDTO dto) {
        dto.setId(UUID.randomUUID());
        dto.setDtCreate(LocalDateTime.now());
        dto.setDtUpdate(dto.getDtCreate());

        if(validate(dto)) {
            JournalFood journalFood = JournalFoodBuilder
                    .create()
                    .setId(dto.getId())
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
    public JournalFoodDTO read(long id) {
        return null;
    }

    @Override
    public Page<JournalFoodDTO> get(int page, int itemsPerPage) {
        return null;
    }

    @Override
    public JournalFoodDTO update(long id, LocalDateTime dtUpdate, JournalFoodDTO dto) {
        return null;
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {

    }

    @Override
    public boolean validate(JournalFoodDTO dto) {
        return true;
    }

    @Override
    public JournalFoodDTO mapToDTO(JournalFood journalFood) {
        return null;
    }

    @Override
    public JournalFood mapToEntity(JournalFoodDTO entity) {
        return null;
    }
}
