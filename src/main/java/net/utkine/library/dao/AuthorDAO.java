package net.utkine.library.dao;

import java.util.ArrayList;
import java.util.List;

import net.utkine.library.form.Author;

public interface AuthorDAO {
    public void addAuthor(Author author);
    public List<Author> listAuthor(Integer authorId);
    public void removeAuthor(Integer id);
    public void updateAuthor(Author author);
}
