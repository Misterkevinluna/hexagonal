package com.companyKLJ.hexagonal.application.ports;

import com.companyKLJ.hexagonal.domain.models.Body_Model;

import java.util.Optional;

public interface UpdateBody_UseCasePort {
    Optional<Body_Model> update(Body_Model body);
}
