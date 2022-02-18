package com.example.backend.service;

import com.example.backend.model.Brand;
import com.example.backend.model.Model;

import java.util.List;

public interface BrandService {
    List<Brand> listAllBrands();
    List<Model> listAllModelsByBrand(String name);
}
