package fr.plil.sio.jpa;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * At the persistence level:
 * - an animal is unique by name.
 * - an animal must have an owner.
 * - an animal may be connected to zero, one or several veterinarians.
 */

public class Animal implements Serializable {

    private Long id;

    private String name;

    private Owner owner;

    private List<Veterinarian> veterinarians = new LinkedList<Veterinarian>();

    public Long getId() {
        return id;
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
}