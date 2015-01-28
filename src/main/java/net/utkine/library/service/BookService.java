package net.utkine.library.service;

import java.util.ArrayList;
import java.util.List;

import net.utkine.library.form.Book;

public interface BookService {
    public void addBook(Book book);
    public List<Book> listBook(Integer authorId);
    public void removeBook(Integer id);
    public ArrayList<ArrayList> listBookExt();
    public List<Book> retBookOnId(Integer id_book);
    public void updateBook(Book book);
}
