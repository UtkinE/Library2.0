package net.utkine.library.controller;

import java.util.*;

import net.utkine.library.form.Author;

import net.utkine.library.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.Valid;


@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value="/view_all_authors", method = RequestMethod.GET)
    public String viewAllAuthor(Map<String,Object> map){
        map.put("author", new Author());
        map.put("authorList", authorService.listAuthor(null));

        return "view_all_authors";
    }

    @RequestMapping(value="/view_this_author/{authorId}", method = RequestMethod.GET)
    public String viewThisAuthor(@PathVariable("authorId") Integer authorId, Model model,Map<String,Object> map ){
        map.put("author", authorService.listAuthor(authorId).get(0));

        return "view_this_author";
    }


    @RequestMapping(value="/view_edit_author/{authorId}", method = RequestMethod.POST)
     public String editAllAuthor(@ModelAttribute("author") @Valid Author author,BindingResult result,@PathVariable("authorId") Integer authorId){
        if(result.hasErrors()){
            return "error_form";
        }
        else {
            author.setId(authorId);
            authorService.updateAuthor(author);
            return "back_to_menu";
        }
    }
    @RequestMapping(value = "/add_author_form",method = RequestMethod.GET)
    public String addAuthorForm(Map<String,Object> map){
        map.put("author", new Author());
        return "add_author";
    }

    @RequestMapping(value = "/add_author",method = RequestMethod.POST)
    public String addAuthor(@ModelAttribute("author") Author author){
        authorService.addAuthor(author);
        return "back_to_menu";
    }

    @RequestMapping(value = "/remove_author/{authorId}",method = RequestMethod.GET)
    public String removeAuthor(@PathVariable("authorId") Integer authorId){
        authorService.removeAuthor(authorId);
        return "back_to_menu";
    }
}
