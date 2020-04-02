package com.wahyuutomoputra.demo.controller;

import com.wahyuutomoputra.demo.dto.SaveBook;
import com.wahyuutomoputra.demo.useCase.BookUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Book")
public class BookController {
    @Autowired
    BookUseCaseImpl bookUseCase;

    @PostMapping("/createBook")
    public ResponseEntity<Object> createBook(@RequestBody SaveBook saveBook){
        return new ResponseEntity<>(bookUseCase.createBook(saveBook), HttpStatus.OK);
    }

    @GetMapping("/getBook/{id}")
    public ResponseEntity<Object> getBook(@PathVariable Integer id){
        return new ResponseEntity<>(bookUseCase.getBook(id), HttpStatus.OK);
    }

    @GetMapping("/getAllBook")
    public ResponseEntity<Object> getAllBook(){
        return new ResponseEntity<>(bookUseCase.getAllBook(), HttpStatus.OK);
    }

    @PostMapping("/updateBook")
    public ResponseEntity<Object> updateBook(@RequestBody SaveBook saveBook){
        return new ResponseEntity<>(bookUseCase.updateBook(saveBook), HttpStatus.OK);
    }
}
