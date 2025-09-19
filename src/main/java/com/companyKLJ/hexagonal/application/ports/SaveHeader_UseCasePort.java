package com.companyKLJ.hexagonal.application.ports;
import com.companyKLJ.hexagonal.domain.models.Header_Model;
public interface SaveHeader_UseCasePort {
    Header_Model save(Header_Model header);
}
