package com.graphqljava.tutorial.book.details;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl {
    public List<Book> getAllBooks() {
        return new ArrayList<>();
    }
}
