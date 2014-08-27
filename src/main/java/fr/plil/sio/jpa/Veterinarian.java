package fr.plil.sio.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * An veterinarian is unique by name. An veterinarian may be connected to zero, one or several animals.
 */

@Entity
@Table(name = "VETERINARIAN_T")
public class Veterinarian implements Serializable {

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
    /**
     * Add an animal to the veterinarian.
     *
     * @param animal the animal to add to the veterinarian
     * @throws IllegalStateException if animal already present
     * @throws NullPointerException  if parameter is null
     */
    public void addAnimal(Animal animal) {
        if (animal == null) {
            throw new NullPointerException("animal cannot be null");
        }
        if (animals.contains(animal)) {
            throw new IllegalStateException("animal already present");
        }
        animals.add(animal);
        animal.getVeterinarians().add(this);
    }

    /**
     * Remove an animal from the veterinarian.
     *
     * @param animal the animal to remove from the veterinarian
     * @throws IllegalStateException if animal not present in veterinarian
     * @throws NullPointerException  if parameter is null
     */
    public void removeAnimal(Animal animal) {
        logger.error("to complete");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Veterinarian veterinarian = (Veterinarian) o;

        if (!name.equals(veterinarian.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
