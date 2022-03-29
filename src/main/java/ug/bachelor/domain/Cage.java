package ug.bachelor.domain;
import javax.persistence.*;
import ug.bachelor.domain.enums.*;



@Entity
public class Cage {

    private Long id;

    private Size size;
    boolean isEmpty;

    public Cage() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //gettery

    //settery

    //constructory
}