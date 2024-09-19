package com.bookstore.jpa.controllers;

import com.bookstore.jpa.dtos.BookRecorDto;
import com.bookstore.jpa.models.BookModel;
import com.bookstore.jpa.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bookstore/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookModel>>getAllBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }
    @PostMapping
    public ResponseEntity<BookModel> saveBook(@RequestBody BookRecorDto bookRecorDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.saveBook(bookRecorDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable UUID id){
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.OK).body("Book deleted successfully.");
    }
}

