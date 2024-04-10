package com.example.LibraryManagement.Services;

import com.example.LibraryManagement.Entity.Book;
import com.example.LibraryManagement.Entity.Patron;
import com.example.LibraryManagement.Repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.util.List;

@Service
public class PatronService {
    @Autowired
    PatronRepository patronRepository;
    public ResponseEntity<String> saveDetails(Patron patron){
        patronRepository.save(patron);
        return ResponseEntity.status(200).body("Patron has been added successfully");
    }
    public List<Patron> getAllPatrons(){
        return patronRepository.findAll();
    }
    public Patron getPatronById(int id){
        return patronRepository.findById(id).orElse(null);
    }
    public ResponseEntity<String> updatePatron(int id,Patron patron){
        Patron updatedPatron = patronRepository.findById(id).orElse(null);
        if(updatedPatron!=null){
            updatedPatron.setEmail(patron.getEmail());
            updatedPatron.setName(patron.getName());
            patronRepository.save(updatedPatron);
            return ResponseEntity.status(200).body("Patron has been updated successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such a Patron");
    }
    public ResponseEntity<String> deletePatron(int id) {
        Patron deletedPatron = patronRepository.findById(id).orElse(null);
        if(deletedPatron!= null){
            patronRepository.deleteById(id);
            return ResponseEntity.status(200).body("Patron has been deleted successfully");

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No such a Patron");
    }
}
