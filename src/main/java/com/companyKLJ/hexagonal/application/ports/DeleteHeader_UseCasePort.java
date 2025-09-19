package com.companyKLJ.hexagonal.application.ports;

public interface DeleteHeader_UseCasePort {
    boolean delete(Long id);
    //boolean deleteNoReference(String noReference);
}
