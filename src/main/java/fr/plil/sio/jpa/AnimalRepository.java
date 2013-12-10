package fr.plil.sio.jpa;

import java.util.List;

public interface AnimalRepository {

    /**
     * Save or update an animal instance in the database. If the animal is not present in the database (i.e. if not
     * other animal in the database has the same name), set the id to an unique number and save it.
     *
     * @param animal the instance of animal to save or update.
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
     * Return an animal instance with specified name and all dependencies.
     *
     * @param name the name of the animal to return.
     * @return the animal instance or null if not found
     */
    Animal findByName(String name);

    /**
     * Return an animal instance with specified id and all dependencies.
     *
     * @param id the id of the animal to return.
     * @return the animal instance or null if not found
     */
    Animal findOne(Long id);

    /**
     * Return all animals in the database and all dependencies.
     *
     * @return The list of animals.
     */
    List<Animal> findAll();
}
