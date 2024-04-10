package com.example.LibraryManagement.Repository;

import com.example.LibraryManagement.Entity.Patron;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronRepository extends JpaRepository<Patron,Integer> {
}
