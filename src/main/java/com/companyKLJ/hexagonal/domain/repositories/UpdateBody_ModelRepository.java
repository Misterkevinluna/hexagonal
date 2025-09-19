package com.companyKLJ.hexagonal.domain.repositories;

import com.companyKLJ.hexagonal.domain.models.Body_Model;

import java.util.Optional;

public interface UpdateBody_ModelRepository {
    Optional<Body_Model> update(Body_Model body);
}
