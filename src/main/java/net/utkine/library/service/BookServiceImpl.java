package net.utkine.library.service;

import java.util.ArrayList;
import java.util.List;

import net.utkine.library.dao.BookDAO;
import net.utkine.library.form.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookDAO bookDAO;

    @Transactional
    public void addBook(Book book){
        bookDAO.addBook(book);
    }

    @Transactional
    public List<Book> listBook(Integer authorId){
        return bookDAO.listBook(authorId);
    }

    @Transactional
    public void removeBook(Integer id_book) {
        bookDAO.removeBook(id_book);
    }

    @Transactional
    public ArrayList<ArrayList> listBookExt(){
        return bookDAO.listBookExt();
    }

    @Transactional
    public List<Book> retBookOnId(Integer id_book){
       return bookDAO.retBookOnId(id_book);
    }

    @Transactional
    public void updateBook(Book book){
        bookDAO.updateBook(book);
    }

}