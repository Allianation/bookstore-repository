package com.argentina.programa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.argentina.programa.models.Editorial;

public interface IEditorialRepository extends JpaRepository<Editorial, Integer> {

}
