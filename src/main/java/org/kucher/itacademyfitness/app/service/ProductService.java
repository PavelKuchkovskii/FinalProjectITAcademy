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
import java.util.Optional;
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
        dto.setUuid(UUID.randomUUID());
        dto.setDtCreate(LocalDateTime.now());
        dto.setDtUpdate(dto.getDtCreate());

        if(validate(dto)) {

            Product product = mapToEntity(dto);

            dao.save(product);
        }

        return dto;
    }

    @Override
    public ProductDTO read(UUID uuid) {
        Optional<Product> oProduct = dao.findById(uuid);
        return oProduct.map(this::mapToDTO).orElse(null);

    }

    @Override
    public Page<ProductDTO> get(int page, int itemsPerPage) {
        Pageable pageable = PageRequest.of(page, itemsPerPage);
        Page<Product> products = dao.findAll(pageable);

        return new PageImpl<> (products.get().map(this::mapToDTO)
                .collect(Collectors.toList()), pageable, products.getTotalElements());
    }

    @Override
    public ProductDTO update(UUID uuid, LocalDateTime dtUpdate, ProductDTO dto) {

        ProductDTO productDTO = this.read(uuid);
        productDTO.setDtUpdate(LocalDateTime.now());
        productDTO.setTitle(dto.getTitle());
        productDTO.setWeight(dto.getWeight());
        productDTO.setCalories(dto.getCalories());
        productDTO.setFats(dto.getFats());
        productDTO.setCarbohydrates(dto.getCarbohydrates());
        productDTO.setProteins(dto.getProteins());

        Product product = ProductBuilder
                .create()
                .setUuid(productDTO.getUuid())
                .setDtCreate(productDTO.getDtCreate())
                .setDtUpdate(productDTO.getDtUpdate())
                .setTitle(productDTO.getTitle())
                .setWeight(productDTO.getWeight())
                .setCalories(productDTO.getCalories())
                .setFats(productDTO.getFats())
                .setCarbohydrates(productDTO.getCarbohydrates())
                .setProteins(productDTO.getProteins())
                .build();

        dao.save(product);

        return productDTO;

    }

    @Override
    public void delete(UUID uuid, LocalDateTime dtUpdate) {

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
    public Product mapToEntity(ProductDTO dto) {
        return ProductBuilder
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
    }


}
