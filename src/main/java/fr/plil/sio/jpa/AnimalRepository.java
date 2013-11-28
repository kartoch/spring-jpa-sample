package fr.plil.sio.jpa;

import java.util.List;

public interface AnimalRepository {

    /**
     * Save or update an animal instance in the database. If the animal is not present in the database (i.e. if not
     * other animal in the database has the same name), set the id to an unique number and save it. If the animal is
     * already present in the database (i.e. an animal entry exist with the same id), update the name of the database
     * entry with the value of the instance passed in parameter.
     *
     * @param animal the instance of animal to save or update.
     * @return the animal instance
     * @throws NullPointerException          if animal is null or if animal name is null
     * @throws IllegalStateException         if an animal exist with the same name but different id
     * @throws UnsupportedOperationException in case of SQL problems
     */
    Animal save(Animal animal);

    /**
     * Remove the animal instance from the database.
     *
     * @param animal the animal to delete from the database.
     * @throws NullPointerException          if animal is null
     * @throws IllegalStateException         if animal is not present in the database
     * @throws UnsupportedOperationException in case of SQL problems
     */
    void delete(Animal animal);

    /**
     * Return an animal instance with specified name and all dependencies.
     *
     * @param name the name of the animal to return.
     * @return the animal instance or null if not found
     * @throws NullPointerException          if name is null
     * @throws UnsupportedOperationException in case of SQL problems
     */
    Animal findByName(String name);

    /**
     * Return an animal instance with specified id and all dependencies.
     *
     * @param id the id of the animal to return.
     * @return the animal instance or null if not found
     * @throws NullPointerException          if id is null
     * @throws UnsupportedOperationException in case of SQL problems
     */
    Animal findOne(Long id);

    /**
     * Return all animals in the database and all dependencies.
     *
     * @return The list of animals.
     * @throws UnsupportedOperationException in case of SQL problems
     */
    List<Animal> findAll();
}
