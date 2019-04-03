package com.bledi.fletesm.repository;

import com.bledi.fletesm.model.Flete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FleteRepository extends JpaRepository<Flete, Long> {

}