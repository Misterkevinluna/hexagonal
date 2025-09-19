package com.companyKLJ.hexagonal.application.ports;

import com.companyKLJ.hexagonal.domain.models.Header_Model;

import java.util.Optional;

public interface FindByHeader_UseCasePort {
    Optional<Header_Model> findById(Long id);
}
