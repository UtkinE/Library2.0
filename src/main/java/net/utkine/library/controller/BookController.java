package net.utkine.library.controller;

import net.utkine.library.form.Book;
import net.utkine.library.service.AuthorService;
import net.utkine.library.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import javax.validation.constraints.Null;
import java.util.*;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/view_books/{authorID}",method = RequestMethod.GET)
    public String viewBooksAuthor(@PathVariable("authorID") Integer authorID, Map<String,Object> map){
        map.put("book", new Book());
        map.put("bookList",bookService.listBook(authorID));
    return "view_books";
    }

    @RequestMapping(value = "/delete_book_this_author/{bookId}",method = RequestMethod.POST)
    public String deleteBookOfThisAuthor(@PathVariable("bookId") Integer bookId, Map<String,Object> map){
        Book book = bookService.retBookOnId(bookId).get(0);
        book.setAuthorid(null);
        bookService.updateBook(book);
        return "back_to_menu";
    }

    @RequestMapping(value = "/view_all_books",method = RequestMethod.GET)
    public String viewAllBooks(Map<String,Object> map){
        //System.out.println(bookService.listBookExt());
        map.put("bookArr", new ArrayList());
        map.put("booksExt", bookService.listBookExt());


        return "view_all_books";
    }

    @RequestMapping(value = "/assign_book_of_this_author/{authorId}",method = RequestMethod.GET)
    public String showBookWithoutAuthor(@PathVariable("authorId") Integer authorId,Map<String,Object> map){
        map.put("book", new Book());
        map.put("bookList", bookService.retBookOnId(null));
        map.put("authorId", authorId);

        return "assign_book_of_this_author";
    }


    @RequestMapping(value = "/add_book_this_author/{authorId}/{bookId}",method = RequestMethod.POST)
    public String assignBookOfThisAuthor(@PathVariable("authorId") Integer authorId,@PathVariable("bookId") Integer bookId){
        Book book = bookService.retBookOnId(bookId).get(0);
        System.out.println(book.getNameBook());
        System.out.println(book.getId_book());
        book.setAuthorid(authorId);
        bookService.updateBook(book);

        return "assign_book_of_this_author";
    }

    @RequestMapping(value = "/remove_book/{bookId}",method = RequestMethod.GET)
    public String removeAuthor(@PathVariable("bookId") Integer bookId){
        bookService.removeBook(bookId);
        return "back_to_menu";
    }

    @RequestMapping(value="/view_this_book/{bookId}", method = RequestMethod.GET)
    public String viewThisBook(@PathVariable("bookId") Integer bookId,Map<String,Object> map ){
        map.put("book", bookService.retBookOnId(bookId).get(0));

        return "view_this_book";
    }

    @RequestMapping(value="/view_edit_book/{bookId}", method = RequestMethod.POST)
    public String editAllBook(@ModelAttribute("book") @Valid Book book,BindingResult result,@PathVariable("bookId") Integer bookId){
        if(result.hasErrors()){
            return "error_form";
        }
        else {
            book.setId_book(bookId);
            bookService.updateBook(book);
            return "back_to_menu";
        }
    }

    @RequestMapping(value = "/add_book_form",method = RequestMethod.GET)
    public String addAuthorForm(Map<String,Object> map){
        map.put("book", new Book());
        return "add_book";
    }

    @RequestMapping(value = "/add_book",method = RequestMethod.POST)
    public String addAuthor(@ModelAttribute("book") Book book){
        bookService.addBook(book);
        return "back_to_menu";
    }
}
