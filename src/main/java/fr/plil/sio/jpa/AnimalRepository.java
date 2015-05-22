package fr.plil.sio.jpa;

import java.util.List;

public interface AnimalRepository {

    /**
     * Save an animal instance in the database.
     *
     * @param animal the instance of animal to save.
     * @return the animal instance
     */
    Animal save(Animal animal);

    /**
     * Remove the animal instance from the database.
     *
     * @param animal the animal to delete from the database.
     */
    void delete(Animal animal);

    /**
     * Return an animal instance with specified name.
     *
     * @param name the name of the animal to return.
     * @return the animal instance or null if not found
     */
    Animal findByName(String name);

    /**
     * Return an animal instance with specified id.
     *
     * @param id the id of the animal to return.
     * @return the animal instance or null if not found
     */
    Animal findOne(Long id);

    /**
     * Return all animals in the database.
     *
     * @return The list of animals.
     */
    List<Animal> findAll();
}
