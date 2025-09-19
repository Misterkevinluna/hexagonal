package com.companyKLJ.hexagonal.application.ports;

import com.companyKLJ.hexagonal.domain.models.Header_Model;

import java.util.List;

public interface GetAllHeader_UseCasePort {
    List<Header_Model> getAll();
}
