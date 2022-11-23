package com.example.springjpaexebook.repository;

import com.example.springjpaexebook.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {}