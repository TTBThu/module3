package com.ra;

import com.ra.model.entity.ProductEntity;
import com.ra.repository.IRepository;
import com.ra.repository.impl.Repository;

import java.util.UUID;

public class Application {
    public static void main(String[] args) {
        IRepository<ProductEntity, String> productRepository = new Repository<>();

        ProductEntity newEntity = new ProductEntity();
        newEntity.setId(UUID.randomUUID().toString());
        newEntity.setName("New Productttt");
        newEntity.setCategoryId(1);
        newEntity.setImage("image.jpg");
        newEntity.setPrice(Float.valueOf(5500));
        newEntity.setSalePrice(Float.valueOf(6500));
        newEntity.setStatus(true);

        //productRepository.add(newEntity);
        ProductEntity pUpdate = productRepository.findId("P001", ProductEntity.class);
        pUpdate.setName("Tivi Sonyyyyy");
        productRepository.edit(pUpdate);

        for (ProductEntity p : productRepository.findAll(ProductEntity.class)) {
            System.out.println(p.getId() + ": " + p.getName());
        }

        System.out.println("findId()");
        ProductEntity p = productRepository.findId("P001", ProductEntity.class);
        System.out.println(p.getId() + " | " + p.getName());
    }
}