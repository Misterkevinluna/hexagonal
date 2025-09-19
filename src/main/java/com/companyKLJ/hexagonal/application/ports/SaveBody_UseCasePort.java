package com.companyKLJ.hexagonal.application.ports;

import com.companyKLJ.hexagonal.domain.models.Body_Model;

public interface SaveBody_UseCasePort {
    Body_Model save(Body_Model body);
}
