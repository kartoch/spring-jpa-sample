package fr.plil.sio.jpa;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * An animal is unique by name. An animal must have an owner (at the persistence level).
 * An animal may be connected to zero, one or several veterinarians.
 */

@Entity
@Table(name = "ANIMAL_T")
public class Animal implements Serializable, Comparable<Animal> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ANIMAL_ID")
    private Long id;

    @Column(name = "NAME_C", unique = true, nullable = false)
    private String name;

    @ManyToOne(optional = false)
    @JoinColumn(name = "OWNER_ID")
    private Owner owner;

    @ManyToMany(mappedBy = "animals", cascade = CascadeType.REMOVE)
    private List<Veterinarian> veterinarians = new LinkedList<Veterinarian>();

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Animal animal = (Animal) o;

        if (!name.equals(animal.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public int compareTo(Animal animal) {
        return this.name.compareTo(animal.getName());
    }
}