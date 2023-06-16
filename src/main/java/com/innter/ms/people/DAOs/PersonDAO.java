package com.innter.ms.people.DAOs;

import com.innter.ms.people.entities.PersonEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonDAO extends JpaRepository<PersonEntity, Long> {

    @Query("SELECT p FROM PersonEntity p Join Fetch p.address a WHERE p.name LIKE %:name% OR p.lastName LIKE %:lastName% OR p.surname LIKE %:surname%")
    List<PersonEntity> findPersonByName
            (@Param("name") String name,
             @Param("lastName") String lastName,
             @Param("surname") String surname,
             Pageable pageable
            );
}