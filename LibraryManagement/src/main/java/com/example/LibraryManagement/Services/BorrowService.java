package com.example.LibraryManagement.Services;

import com.example.LibraryManagement.Entity.Book;
import com.example.LibraryManagement.Entity.Patron;
import com.example.LibraryManagement.Repository.BookRepository;
import com.example.LibraryManagement.Repository.PatronRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class BorrowService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    PatronRepository patronRepository;
    @Transactional
    public ResponseEntity<String> borrowBook(int patronID, int bookID){
        Patron patron = patronRepository.findById(patronID).orElse(null);
        Book book = bookRepository.findById(bookID).orElse(null);
        if(book.getPatron()!=null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sorry this book is not available currently");
        }
        if(patron == null){
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such patron");
        }
        book.setPatron(patron);
        patron.getBorrowedBooks().add(book);
        book.setReturnDate(LocalDate.now());
        return ResponseEntity.status(200).body("successful transaction!"+"Book id"+bookID
                                            +"is now with patron with id"+patronID);
    }
    @Transactional
    public Book getBorrowedBook(int patronID, int bookID){
        Patron patron = patronRepository.findById(patronID).orElse(null);
        Book book = bookRepository.findById(bookID).orElse(null);
        if(book==null || patron == null){
            return null;
        }
        Set<Book> borrowedBooks= patron.getBorrowedBooks();
        return borrowedBooks.contains(book) ? book : null;
    }

}
