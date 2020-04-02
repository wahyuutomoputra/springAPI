package com.wahyuutomoputra.demo.useCase;

import com.wahyuutomoputra.demo.dto.SaveBook;

import java.util.Map;

public interface BookUseCase {
    Map<String,Object> createBook(SaveBook saveBook);
    Map<String,Object> getBook(Integer id);
    Map<String,Object> getAllBook();
    Map<String,Object> updateBook(SaveBook saveBook);
}
