package com.companyKLJ.hexagonal.domain.repositories;

import com.companyKLJ.hexagonal.domain.models.Header_Model;

import java.util.Optional;

public interface FindByHeader_ModelRepository {
    Optional<Header_Model> findById(Long id);
}
