package com.companyKLJ.hexagonal.infrastructure.repositories.bloc;

import com.companyKLJ.hexagonal.infrastructure.entities.Header_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Header_PortRepositoryJPA extends JpaRepository<Header_Entity, Long> {
}
