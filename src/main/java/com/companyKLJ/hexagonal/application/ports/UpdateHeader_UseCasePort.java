package com.companyKLJ.hexagonal.application.ports;

import com.companyKLJ.hexagonal.domain.models.Header_Model;

import java.util.Optional;

public interface UpdateHeader_UseCasePort {
    Optional<Header_Model> update(Header_Model header);
}
