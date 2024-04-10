package com.example.LibraryManagement.Controller;

import com.example.LibraryManagement.Entity.Book;
import com.example.LibraryManagement.Entity.Patron;
import com.example.LibraryManagement.Services.PatronService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatronController {
    @Autowired
    PatronService patronService;
    @PostMapping("/addPatron")
    public ResponseEntity<String> addPatron(@RequestBody Patron patron){
        return patronService.saveDetails(patron);
    }
    @GetMapping("/getAllPatrons")
    public ResponseEntity<List<Patron>> getAllBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(patronService.getAllPatrons());
    }
    @GetMapping("/getPatron/{id}")
    public ResponseEntity<Patron> getBookById(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(patronService.getPatronById(id));
    }
    @PutMapping("/updatePatron/{id}")
    public ResponseEntity<String> updateBook(@PathVariable int id,@RequestBody Patron patron){
        return patronService.updatePatron(id,patron);
    }
    @DeleteMapping("/deletePatron/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable int id){
       return patronService.deletePatron(id);
    }

}
