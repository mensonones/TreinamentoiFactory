package br.ufc.demo1.author;

import br.ufc.demo1.pubs.Pubs;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * Created by emerson on 17/07/17.
 */
@Entity
public class Author implements Serializable{

    private static final int serialVersionUID = (int) 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "O primeiro nome não pode ser em branco")
    private String firstName;
    @NotBlank(message = "O segundo nome não pode ser em branco")
    private String lastName;

    @OneToMany
    @JoinTable(name = "author_pub",
    joinColumns = @JoinColumn(name = "author_id"), inverseJoinColumns = @JoinColumn(name = "pub_id"))
    private List<Pubs> pubsList;

    public List<Pubs> getPubsList() {
        return pubsList;
    }

    public void setPubsList(List<Pubs> pubsList) {
        this.pubsList = pubsList;
    }

    public Author(){}

    public Author(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
