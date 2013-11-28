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

    @ManyToMany(cascade = CascadeType.REMOVE)
    private List<Animal> animals = new LinkedList<Animal>();

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
        logger.error("to complete");
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
        logger.error("to complete");
        return true;
    }

    @Override
    public int hashCode() {
        logger.error("to complete");
        return 0;
    }
}
