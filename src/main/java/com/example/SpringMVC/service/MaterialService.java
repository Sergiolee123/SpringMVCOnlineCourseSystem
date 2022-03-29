package com.example.SpringMVC.service;

import com.example.SpringMVC.dao.MaterialRepository;
import com.example.SpringMVC.exception.MaterialNotFindException;
import com.example.SpringMVC.model.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class MaterialService {
    private MaterialRepository materialRepository;

    @Autowired
    public void setMaterialRepository(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    @Transactional(rollbackFor = Throwable.class)
    public Material addMaterial(Material material){
        return materialRepository.save(material);
    }

    @Transactional(rollbackFor = Throwable.class)
    public void deleteMaterialById(Long id){
        materialRepository.deleteById(id);
    }

    public Optional<Material> findMaterialById(Long id){
        return materialRepository.findById(id);
    }
}
