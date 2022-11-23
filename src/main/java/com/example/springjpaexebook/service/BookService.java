package com.example.springjpaexebook.service;

import com.example.springjpaexebook.domain.Author;
import com.example.springjpaexebook.domain.Book;
import com.example.springjpaexebook.domain.dto.BookResponse;
import com.example.springjpaexebook.repository.AuthorRepository;
import com.example.springjpaexebook.repository.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService{
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<BookResponse> findBooks(Pageable pageable) {
        Page<Book> books = bookRepository.findAll(pageable);
        List<BookResponse> bookResponses = books.stream()
                .map(book -> {
                    Optional<Author> optionalAuthor = authorRepository.findById(book.getAuthorId());
                    return BookResponse.of(book, optionalAuthor.get().getName());
                }).collect(Collectors.toList());
        return bookResponses;
    }
}