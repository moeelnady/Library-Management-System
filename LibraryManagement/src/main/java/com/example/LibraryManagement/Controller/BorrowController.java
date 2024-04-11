package com.example.LibraryManagement.Controller;

import com.example.LibraryManagement.Entity.Book;
import com.example.LibraryManagement.Services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BorrowController {
    @Autowired
    BorrowService borrowService;
    @PostMapping("/borrow/{patronID}/{bookID}")
    public ResponseEntity<String> borrowBook(@PathVariable int patronID,
                                             @PathVariable int bookID){
        return borrowService.borrowBook(patronID,bookID);
    }
    @PutMapping("/get/{patronID}/{bookID}")
    public Book getBorrowedBook(@PathVariable int patronID,
                                                  @PathVariable int bookID){
        return borrowService.getBorrowedBook(patronID,bookID);
    }
}
