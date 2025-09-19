package com.companyKLJ.hexagonal.infrastructure.repositories.bloc;

import com.companyKLJ.hexagonal.infrastructure.entities.Body_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Body_PortRepositoryJPA extends JpaRepository<Body_Entity, Long> {

    @Query("select b from Body_Entity b where b.idHeader_Model = ?1")
    List<Body_Entity> findAllByidHeader_Model(Long idHeader);
}
