package com.team.Bok.service;

import com.team.Bok.dto.BookDto;
import com.team.Bok.exception.BadRequest;
import com.team.Bok.model.Book;
import com.team.Bok.repasitory.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class BookService {

    private BookRepository bookRepository;
    public BookDto get(Integer id) {
       Book entity =  check(id);
        BookDto dto = new BookDto();
        convertEntityToDTo(entity,dto);
        return dto;
    }

    private void convertEntityToDTo(Book entity, BookDto dto) {
        dto.setAuthor(entity.getAuthor());
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setImage(entity.getImage());
        dto.setPrice(entity.getPrice());

    }

    private Book check(Integer id) {
        Optional<Book> optional = bookRepository.findById(id);
        if (optional.isEmpty()){
            throw new BadRequest("Error");
        }
        return optional.get();

    }

    public BookDto create(BookDto bookDto) {
        Book entity = new Book();
        convertDtoToEntity(entity,bookDto);
        entity.setPublished_at(LocalDateTime.now());
        bookRepository.save(entity);

        return bookDto;

    }

    private void convertDtoToEntity(Book entity, BookDto bookDto) {
        entity.setTitle(bookDto.getTitle());
        entity.setImage(bookDto.getImage());
        entity.setPrice(bookDto.getPrice());
        entity.setAuthor(bookDto.getAuthor());
    }

    public boolean update(BookDto bookDto, Integer id) {
        Book entity = check(id);
        convertDtoToEntity(entity,bookDto);
        bookRepository.save(entity);
        return true;

    }

    public boolean delete(Integer id) {
        Book entity = check(id);
        bookRepository.delete(entity);
        return true;

    }
}
