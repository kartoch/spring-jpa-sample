package fr.plil.sio.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * At the persistence level:
 * - an animal is unique by name.
 * - an animal must have an owner.
 * - an animal may be connected to zero, one or several veterinarians.
 */

@Entity
@Table(name = "ANIMAL_T")
public class Animal implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ANIMAL_ID")
    private Long id;

    @Column(name = "NAME_C", unique = true, nullable = false)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;

    @ManyToMany(mappedBy = "animals")
    private List<Veterinarian> veterinarians = new LinkedList<Veterinarian>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public List<Veterinarian> getVeterinarians() {
        return veterinarians;
    }

    public void setVeterinarians(List<Veterinarian> veterinarians) {
        this.veterinarians = veterinarians;
    }
}