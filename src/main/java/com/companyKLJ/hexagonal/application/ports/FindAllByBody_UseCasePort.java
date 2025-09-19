package com.companyKLJ.hexagonal.application.ports;

import com.companyKLJ.hexagonal.domain.models.Body_Model;

import java.util.List;

public interface FindAllByBody_UseCasePort {
    List<Body_Model> findAllByidHeader_Model(Long idHeader);
}
