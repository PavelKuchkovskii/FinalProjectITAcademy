package org.kucher.itacademyfitness.app.service;

import org.kucher.itacademyfitness.app.dao.api.IProductDao;
import org.kucher.itacademyfitness.app.dao.entity.Product;
import org.kucher.itacademyfitness.app.dao.entity.builders.ProductBuilder;
import org.kucher.itacademyfitness.app.service.api.IProductService;
import org.kucher.itacademyfitness.app.service.dto.ProductDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService implements IProductService {

    private IProductDao dao;

    public ProductService(IProductDao dao) {
        this.dao = dao;
    }

    @Override
    public ProductDTO create(ProductDTO dto) {
        dto.setId(UUID.randomUUID());
        dto.setDtCreate(LocalDateTime.now());
        dto.setDtUpdate(dto.getDtCreate());

        if(validate(dto)) {

            Product product = ProductBuilder
                    .create()
                    .setUuid(dto.getId())
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
    public ProductDTO read(long id) {
        return null;
    }

    @Override
    public List<ProductDTO> get() {
        return null;
    }

    @Override
    public ProductDTO update(long id, LocalDateTime dtUpdate, ProductDTO dto) {
        return null;
    }

    @Override
    public void delete(long id, LocalDateTime dtUpdate) {

    }

    @Override
    public boolean validate(ProductDTO productDTO) {
        return true;
    }
}
