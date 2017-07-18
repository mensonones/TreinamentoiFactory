package br.ufc.demo1.pubs;

import br.ufc.demo1.author.Author;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

/**
 * Created by emerson on 18/07/17.
 */

@Entity
public class Pubs implements Serializable {

    private static final int serialVersionUID = (int) 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createAt;
    private String namePub;
    private String contentPub;

    @OneToOne
    @JoinColumn(name = "author_id")
    private Author authorPub;

    public Pubs(){}

    public Pubs(Integer id, Date createAt, String namePub, String contentPub) {
        this.id = id;
        this.createAt = createAt;
        this.namePub = namePub;
        this.contentPub = contentPub;
    }

    public Author getAuthorPub() {
        return authorPub;
    }

    public void setAuthorPub(Author authorPub) {
        this.authorPub = authorPub;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getNamePub() {
        return namePub;
    }

    public void setNamePub(String namePub) {
        this.namePub = namePub;
    }

    public String getContentPub() {
        return contentPub;
    }

    public void setContentPub(String contentPub) {
        this.contentPub = contentPub;
    }
}
