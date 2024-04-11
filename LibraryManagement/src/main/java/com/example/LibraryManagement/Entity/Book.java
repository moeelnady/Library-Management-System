package com.example.LibraryManagement.Entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "publication year")
    private int publicationYear;

    @Column(name = "author name")
    private String authorName;

    @Column(name = "ISBN")
    private long isbn13;
    @ManyToOne
    @JoinColumn(name = "patron_id") // Foreign key column
    private Patron patron;
    @Column(name = "return_date")
    private LocalDate returnDate; // New field for return da

}
