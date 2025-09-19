package com.companyKLJ.hexagonal.domain.repositories;

import com.companyKLJ.hexagonal.domain.models.Header_Model;

public interface SaveHeader_ModelRepository {
    Header_Model save(Header_Model header);
}
