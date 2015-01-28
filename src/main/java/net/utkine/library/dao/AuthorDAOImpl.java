package net.utkine.library.dao;

import java.util.List;
import java.util.*;

import net.utkine.library.form.Author;
import net.utkine.library.form.Book;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDAOImpl implements AuthorDAO {
    @Autowired
    private SessionFactory sessionFactory;

    //@Override
    public void addAuthor(Author author) {
        sessionFactory.getCurrentSession().save(author);
    }

   // @Override
    public List<Author> listAuthor(Integer authorId) {
        if(authorId==null){ return sessionFactory.getCurrentSession().createQuery("from Author").list();}
        else
        {
            Query query = sessionFactory.getCurrentSession().createSQLQuery("SELECT author.* FROM author WHERE author.id_author=:authorId").addEntity(Author.class);
            query.setInteger("authorId",authorId);
            return query.list();
        }
    }

   // @Override
    public void removeAuthor(Integer id_author) {
        Author author = (Author) sessionFactory.getCurrentSession().load(Author.class,id_author);
        if(null!=author){
            sessionFactory.getCurrentSession().delete(author);
        }
    }

    public void updateAuthor(Author author){
        sessionFactory.getCurrentSession().update(author);
    }


    /*
    public ArrayList<ArrayList> listAuthorExt(){
        ArrayList<Author> authorsArr= new ArrayList<Author>(listAuthor());
        ArrayList<ArrayList> authorExt = new ArrayList<ArrayList>();

        for(int j=0;j<authorsArr.size();j++){
            ArrayList fieldAuthor = new ArrayList();
            ArrayList<Book> bookArr = new ArrayList<Book>(listAuthorSBooks(authorsArr.get(j).getId()));
            fieldAuthor.add(authorsArr.get(j).getFio());
            fieldAuthor.add(authorsArr.get(j).getBirthDate());
            fieldAuthor.add(authorsArr.get(j).getBio());
            /*
            String bufForListBooks="";
            for(int i=0;i<bookArr.size();i++){
                bufForListBooks +=  bookArr.get(i).getNameBook();
                if(i!=bookArr.size()-1){bufForListBooks +=", ";}
            }
            fieldAuthor.add( bufForListBooks);

            authorExt.add(fieldAuthor);
        }
        return  authorExt;
    }*/



}
