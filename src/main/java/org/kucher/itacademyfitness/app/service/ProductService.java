package org.kucher.itacademyfitness.app.service;

import org.kucher.itacademyfitness.app.dao.api.IProductDao;
import org.kucher.itacademyfitness.app.dao.entity.Product;
import org.kucher.itacademyfitness.app.dao.entity.builders.ProductBuilder;
import org.kucher.itacademyfitness.app.service.api.IProductService;
import org.kucher.itacademyfitness.app.service.dto.ProductDTO;
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
public class ProductService implements IProductService {

    private IProductDao dao;
    private ModelMapper mapper;

    public ProductService(IProductDao dao, ModelMapper mapper) {
        this.dao = dao;
        this.mapper = mapper;
    }

    @Override
    public ProductDTO create(ProductDTO dto) {
        dto.setId(UUID.randomUUID());
        dto.setDtCreate(LocalDateTime.now());
        dto.setDtUpdate(dto.getDtCreate());

        if(validate(dto)) {

            Product product = ProductBuilder
                    .create()
                    .setId(dto.getId())
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
    public Page<ProductDTO> get(int page, int itemsPerPage) {
        Pageable pageable = PageRequest.of(page, itemsPerPage);
        Page<Product> products = dao.findAll(pageable);

        return new PageImpl<> (products.get().map(this::mapToDTO)
                .collect(Collectors.toList()), pageable, products.getTotalElements());
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

    @Override
    public ProductDTO mapToDTO(Product product) {
        return mapper.map(product, ProductDTO.class);
    }

    @Override
    public Product mapToEntity(ProductDTO entity) {
        return null;
    }


}
