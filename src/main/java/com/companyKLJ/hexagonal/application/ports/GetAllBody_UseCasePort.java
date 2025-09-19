package com.companyKLJ.hexagonal.application.ports;

import com.companyKLJ.hexagonal.domain.models.Body_Model;

import java.util.List;

public interface GetAllBody_UseCasePort {
    List<Body_Model> getAll();
}
