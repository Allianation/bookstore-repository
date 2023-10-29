package com.argentina.programa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.argentina.programa.models.Book;

@Repository
public interface IBookRepository extends JpaRepository<Book, Integer> {

}
