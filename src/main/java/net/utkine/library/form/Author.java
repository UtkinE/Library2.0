package net.utkine.library.form;



import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name="author")
public class Author {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_author;

    @Column(name="fio")
    @NotEmpty
    @NotNull
    private String fio;

    @Column(name="birthDate")
    @Length(min=3,max=4)
    @NotNull
    private String birthDate;

    @Column(name="bio")
    private String bio;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL,orphanRemoval = true)
    public Integer getId(){
        return id_author;
    }

    public void setId(Integer id_author) {
        this.id_author = id_author;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}

