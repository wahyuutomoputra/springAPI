package com.wahyuutomoputra.demo.useCase;

import com.wahyuutomoputra.demo.dto.SaveBook;
import com.wahyuutomoputra.demo.model.Book;
import com.wahyuutomoputra.demo.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BookUseCaseImpl implements BookUseCase {
    @Autowired
    BookRepo bookRepo;

    @Override
    public Map<String, Object> createBook(SaveBook saveBook) {
        Map<String, Object> newMap = new HashMap<>();

        Book book = new Book();
        book.setName(saveBook.getName());
        bookRepo.save(book);
        newMap.put("Sukses",book);

        return newMap;
    }

    @Override
    public Map<String, Object> updateBook(SaveBook saveBook) {
        //bikin map
        Map<String, Object> newMap = new HashMap<>();
        //optional buat ambil satu row data
        //trus get by id
        Optional<Book> book = bookRepo.findById(saveBook.getId());

        //check kalo datanya ada
        if (book.isPresent()){
            //set value baru
            book.get().setName(saveBook.getName());
            //save ulang, kalo optional harus di get dulu buat ambil data
            bookRepo.save(book.get());
            newMap.put("data", "data updated");
        }else {
            newMap.put("data", "data not found");
        }

        return newMap;
    }

    @Override
    public Map<String, Object> getBook(Integer id) {

        Optional<Book> book = bookRepo.findById(id);
        Map<String, Object> newMap = new HashMap<>();

        if(book.isPresent()){
            newMap.put("data", book.get());
        } else{
            newMap.put("data", null);
        }
        return newMap;
    }

    @Override
    public Map<String, Object> getAllBook() {

        List<Book> books = bookRepo.findAll();
        Map<String, Object> newMap = new HashMap<>();
        newMap.put("data", books);

        return newMap;
    }
}
