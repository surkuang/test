package com.fpi.test.api;

import com.fpi.test.model.Book;
import com.fpi.test.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mongo")
public class MongoController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public String insertOne(@RequestBody Book book){
        return bookService.insertOne(book);
    }

    @PostMapping("/many")
    public String insertMany(){
        return bookService.insertMany();
    }

    @GetMapping
    public Book findById(){
        return bookService.findById();
    }

    @GetMapping("/many")
    public List<Book> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/want")
    public List<Book> find(){
        return bookService.find();
    }

}
