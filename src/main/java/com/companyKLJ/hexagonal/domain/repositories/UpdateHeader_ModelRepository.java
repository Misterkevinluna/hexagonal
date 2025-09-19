package com.companyKLJ.hexagonal.domain.repositories;

import com.companyKLJ.hexagonal.domain.models.Header_Model;

import java.util.Optional;

public interface UpdateHeader_ModelRepository {
    Optional<Header_Model> update(Header_Model header);
}
