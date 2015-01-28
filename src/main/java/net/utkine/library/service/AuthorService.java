package net.utkine.library.service;

import java.util.ArrayList;
import java.util.List;

import net.utkine.library.form.Author;

public interface AuthorService {
    public void addAuthor(Author author);
    public List<Author> listAuthor(Integer authorId);
    public void removeAuthor(Integer id);
    public void updateAuthor(Author author);

}
