package com.cybage.bookManagementSystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cybage.bookManagementSystem.model.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Integer> {

}
