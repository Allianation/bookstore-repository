package com.argentina.programa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.argentina.programa.models.Author;

@Repository
public interface IAuthorRepository extends JpaRepository<Author, Integer> {

}
