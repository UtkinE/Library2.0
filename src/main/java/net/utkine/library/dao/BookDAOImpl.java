package net.utkine.library.dao;

import java.util.*;

import net.utkine.library.form.Book;
import net.utkine.library.form.Author;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAOImpl implements BookDAO {
    @Autowired
    private SessionFactory sessionFactory;

    //@Override
    public void addBook(Book book) {
        sessionFactory.getCurrentSession().save(book);
    }

    // @Override
    public List<Book> listBook(Integer authorId) {
        if(authorId!=null) {
            Query query = sessionFactory.getCurrentSession().createSQLQuery("SELECT book.* FROM book WHERE book.authorid=:authorId").addEntity(Book.class);
            query.setInteger("authorId", authorId);
            return query.list();
        }
        else
        {
           return sessionFactory.getCurrentSession().createSQLQuery("SELECT book.* FROM book").addEntity(Book.class).list();
        }
    }

    // @Override
    public void removeBook(Integer id_book) {
        Book book = (Book) sessionFactory.getCurrentSession().load(Book.class,id_book);
        if(null!=book){
            sessionFactory.getCurrentSession().delete(book);
        }
    }

    public ArrayList<ArrayList> listBookExt(){
        ArrayList<ArrayList> bookExt = new ArrayList<ArrayList>();
        ArrayList<Book> bookArr= new ArrayList<Book>(listBook(null));
        for(int j=0;j<bookArr.size();j++){
            ArrayList fieldBook = new ArrayList();
            fieldBook.add(bookArr.get(j).getId_book());
            fieldBook.add(bookArr.get(j).getNameBook());
            fieldBook.add(bookArr.get(j).getDatePublic());
            fieldBook.add(bookArr.get(j).getGenre());
            fieldBook.add(bookArr.get(j).getAuthorid());
            System.out.println((bookArr.get(j).getAuthorid()+" LEVEL 1 "+j));
            if(fieldBook.get(4)!=null){
                Query query = sessionFactory.getCurrentSession().createSQLQuery("SELECT author.* FROM author WHERE author.id_author=:idAuthor").addEntity(Author.class);
                query.setInteger("idAuthor", (Integer) fieldBook.get(4));
                ArrayList<Author> authorArr = new ArrayList<Author>(query.list());
                fieldBook.add(authorArr.get(0).getFio());
            }
            else {
                fieldBook.add("");
            }
            bookExt.add(fieldBook);
        }

        return  bookExt;
    }

    public List<Book> retBookOnId(Integer id_book){
        Query query;
        if(id_book!=null) {
            query = sessionFactory.getCurrentSession().createSQLQuery("SELECT book.* FROM book WHERE book.id_book=:idBook").addEntity(Book.class);
            query.setInteger("idBook",id_book);
        }
        else {
            query = sessionFactory.getCurrentSession().createSQLQuery("SELECT book.* FROM book WHERE book.authorid is NULL").addEntity(Book.class);
        }

        return query.list();
    }

    public void updateBook(Book book){
        sessionFactory.getCurrentSession().update(book);
    }
}