package com.innter.ms.people.DAOs;

import com.innter.ms.people.entities.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDAO extends JpaRepository<AddressEntity, Long> {
}