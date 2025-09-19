package com.companyKLJ.hexagonal.domain.repositories;

import com.companyKLJ.hexagonal.domain.models.Body_Model;

import java.util.List;

public interface FindAllByBody_ModelRepository {
    List<Body_Model> findAllByidHeader_Model(Long idHeader);
}
