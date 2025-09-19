package com.companyKLJ.hexagonal.domain.repositories;

import com.companyKLJ.hexagonal.domain.models.Header_Model;

import java.util.List;

public interface GetAllHeader_ModelRepository {
    List<Header_Model> getAll();
}
