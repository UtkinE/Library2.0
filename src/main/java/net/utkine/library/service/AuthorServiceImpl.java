package net.utkine.library.service;

import java.util.ArrayList;
import java.util.List;

import net.utkine.library.dao.AuthorDAO;
import net.utkine.library.form.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorServiceImpl implements AuthorService{

    @Autowired
    private AuthorDAO authorDAO;

    @Transactional
    public void addAuthor(Author author){
        authorDAO.addAuthor(author);
    }

    @Transactional
    public List<Author> listAuthor(Integer authorId){
        return authorDAO.listAuthor(authorId);
    }

    @Transactional
    public void removeAuthor(Integer id_author){
        authorDAO.removeAuthor(id_author);
    }


    @Transactional
    public void updateAuthor(Author author){
        authorDAO.updateAuthor(author);
    }
}
