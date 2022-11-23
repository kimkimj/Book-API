package com.example.springjpaexebook.repository;

import com.example.springjpaexebook.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {}