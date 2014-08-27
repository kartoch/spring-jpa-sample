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

    /**
     * Add an animal to the owner.
     *
     * @param animal the animal to add to the owner
     * @throws IllegalStateException if animal already present
     * @throws NullPointerException  if parameter is null
     */
    public void addAnimal(Animal animal) {
        if (animal == null)
            throw new NullPointerException("animal must be not null");
        if (animals.contains(animal))
            throw new IllegalStateException("animal already present in owner");
        animals.add(animal);
        animal.setOwner(this);
    }

    /**
     * Remove an animal from the owner.
     *
     * @param animal the animal to remove from the owner
     * @throws IllegalStateException if animal not present in owner
     * @throws NullPointerException  if parameter is null
     */
    public void removeAnimal(Animal animal) {
        if (animal == null)
            throw new NullPointerException("animal must be not null");
        if (!animals.contains(animal))
            throw new IllegalStateException("animal not present in owner");
        animals.remove(animal);
        animal.setOwner(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Owner owner = (Owner) o;

        if (!name.equals(owner.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
