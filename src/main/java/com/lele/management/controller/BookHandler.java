package com.lele.management.controller;

import com.lele.management.entity.Book;
import com.lele.management.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
public class BookHandler {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return bookRepository.findAll(request);
    }

    @PostMapping("/save")
    public String addBook(@RequestBody Book book){
        bookRepository.save(book);
        return "sucessful";
    }

    @PutMapping("/update")
    public String editBook(@RequestBody Book book){
        /*
         * 有主键,就修改;
         * 没有主键时保存新数据.
         */
        bookRepository.save(book);
        return "sucessful";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable(name = "id") Integer id){
        bookRepository.deleteById(id);
        return "sucessful";
    }

    @Bean
    public Book getBook(){
        return new Book();
    }
}
