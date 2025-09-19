package com.companyKLJ.hexagonal.domain.repositories;

import com.companyKLJ.hexagonal.domain.models.Body_Model;

import java.util.List;

public interface GetAllBody_ModelRepository {
    List<Body_Model> getAll();
}
