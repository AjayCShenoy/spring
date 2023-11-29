package com.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


class BookAlreadyExistsException extends RuntimeException{
    BookAlreadyExistsException(String message){
        super(message);
    }
}

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookRepository br;

    @GetMapping 
    public List<Book>retrieveAllBooks()
    {
       return br.findAll();
    }

    @GetMapping("/{id}")
    public Book  findBookById(@PathVariable("id") Integer id){
        Optional<Book>temp=br.findById(id);
        Book b= null;
        if(temp.isPresent())
        {
            b=temp.get();
        }
        return b;
    }

    @PostMapping 
    public Book addBook(@RequestBody Book book){
        if(book.getId()==null){
            return br.save(book);
        }
        Book b=findBookById(book.getId());
        if(b==null)
        {
            br.save(b);
        }
        else{
            throw new BookAlreadyExistsException("Book exists" + book.getId());
        }
        return book;
    }
    
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable("id") Integer id, @RequestBody Book book){
        Book b=findBookById(id);
        if(b!=null){
            b=book;
            br.save(b);
        }
        return b;
    }
        
    @DeleteMapping("/{id}")
    public Book deleteBook(@PathVariable("id") Integer id){
        Book b=findBookById(id);
        if(b!=null){
            br.delete(b);
        }
        return b;
    }
    }


