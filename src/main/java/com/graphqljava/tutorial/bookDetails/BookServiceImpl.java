package com.graphqljava.tutorial.bookDetails;

import org.dataloader.BatchLoader;
import org.dataloader.DataLoader;
import org.dataloader.DataLoaderFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class BookServiceImpl {
    public List<Book> getAllBooks() {
        return new ArrayList<>();
    }

    public Book getBookById(String id) {
        return Book.books.get(0);
    }

    public List<Book> getAllById(List<String> ids) throws ExecutionException, InterruptedException {
        BatchLoader<String, Book> userBatchLoader = userIds -> CompletableFuture.supplyAsync(() -> Book.books);
        DataLoader<String, Book> userLoader = DataLoaderFactory.newDataLoader(userBatchLoader);
        return userLoader.loadMany(ids).get();
    }
}
