package fr.plil.sio.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

/**
 * An veterinarian is unique by name. An veterinarian may be connected to zero, one or several animals.
 */

@Entity
@Table(name = "VETERINARIAN_T")
public class Veterinarian {

    private final static Logger logger = LoggerFactory.getLogger(Veterinarian.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "VETERINARIAN_ID")
    private Long id;

    @Column(name = "NAME_C", unique = true, nullable = false)
    private String name;

    @ManyToMany
    private List<Animal> animals = new LinkedList<Animal>();

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Animal> getAnimals() {
        return animals;
    }
}
