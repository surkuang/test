package com.fpi.test.service;

import com.fpi.test.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public String insertOne(Book book){

        System.out.println("****mongo插入*****");
        book.setCreateTime(new Date());
        book.setUpdateTime(new Date());
        mongoTemplate.insert(book);
        return "插入成功";
    }

    public String insertMany(){
        System.out.println("******mongo批量插入******");
        List<Book> list = new ArrayList<>(3);
        list.add(new Book(1,1,"test1","test1"));
        list.add(new Book(2,2,"test2","test1"));
        list.add(new Book(3,3,"test3","test3"));
        mongoTemplate.insertAll(list);
        return "批量插入成功";
    }

    public Book findById(){
        System.out.println("******mongo根据id查询******");
        Query query = new Query(Criteria.where("id").is(1));
        return mongoTemplate.findOne(query,Book.class);
    }

    public List<Book> findAll(){
        return mongoTemplate.findAll(Book.class);
    }

    public List<Book> find(){
        return mongoTemplate.find(new Query(Criteria.where("info").is("test1")),Book.class);
    }

    public String updateBook(Book book){
        System.out.println("*****修改book******");
        Query query = new Query(Criteria.where("price").gt(2));
        Update update = new Update().set("updateTime",new Date());
        mongoTemplate.updateFirst(query,update,Book.class);
        return "修改成功";
    }

    public String deleteBook(Book book){
        System.out.println("******删除对象********");
        mongoTemplate.remove(book);
        return "删除成功";
    }

}
