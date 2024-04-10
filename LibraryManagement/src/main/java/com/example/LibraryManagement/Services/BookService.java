package com.example.LibraryManagement.Services;

import com.example.LibraryManagement.Entity.Book;
import com.example.LibraryManagement.Repository.BookRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public ResponseEntity<String> saveDetails(Book book){
        bookRepository.save(book);
        return ResponseEntity.status(200).body("Book has been added successfully");
    }
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Book getById (int id){
        return bookRepository.findById(id).orElse(null);
    }
    public ResponseEntity<String> updateBook(int id,Book book){
        Book updatedBook = bookRepository.findById(id).orElse(null);
        if(updatedBook == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such a book");
        }
        else{
            updatedBook.setTitle(book.getTitle());
            updatedBook.setAuthorName(book.getAuthorName());
            updatedBook.setIsbn13(book.getIsbn13());
            updatedBook.setPublicationYear(book.getPublicationYear());
            bookRepository.save(updatedBook);
        }
        return ResponseEntity.status(200).body("Book has been updated successfully");
    }
}
