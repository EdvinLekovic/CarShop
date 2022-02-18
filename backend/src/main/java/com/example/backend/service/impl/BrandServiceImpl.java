package com.example.backend.service.impl;

import com.example.backend.model.Brand;
import com.example.backend.model.Model;
import com.example.backend.repository.BrandRepository;
import com.example.backend.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> listAllBrands() {
        return brandRepository.findAll();
    }

    @Override
    public List<Model> listAllModelsByBrand(String name) {
        Brand brand = brandRepository.findById(name).orElseThrow();
        return brand.getModels();
    }
}
