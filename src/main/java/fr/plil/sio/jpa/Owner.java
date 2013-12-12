package fr.plil.sio.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * An owner is unique by name. An owner may be connected to zero, one or several animals.
 */

@Entity
@Table(name = "OWNER_T")
public class Owner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OWNER_ID")
    private long id;

    @Column(name = "NAME_C", unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "owner", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Animal> animals = new LinkedList<Animal>();

    public long getId() {
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
