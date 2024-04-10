package com.example.LibraryManagement.Controller;

import com.example.LibraryManagement.Entity.Book;
import com.example.LibraryManagement.Services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @PostMapping("/addBook")
    public ResponseEntity<String> addBook(@RequestBody Book book){
        return bookService.saveDetails(book);
    }
    @GetMapping("/getAllBooks")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }
    @GetMapping("/getBook/{id}")

    public ResponseEntity<Book> getBookById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getById(id));
    }
    @PutMapping("/updateBook/{id}")
    public ResponseEntity<String> updateBook(@PathVariable int id,@RequestBody Book book){
        return bookService.updateBook(id,book);
    }

}
