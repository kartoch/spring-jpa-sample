package fr.plil.sio.jpa;

import java.util.List;

public interface VeterinarianRepository {

    /**
     * Save a veterinarian instance in the database.
     *
     * @param veterinarian the instance of veterinarian to save.
     * @return the veterinarian instance
     */
    Veterinarian save(Veterinarian veterinarian);

    /**
     * Remove the veterinarian instance from the database.
     *
     * @param veterinarian the veterinarian to delete from the database.
     */
    void delete(Veterinarian veterinarian);

    /**
     * Return an veterinarian instance with specified name.
     *
     * @param name the name of the veterinarian to return.
     * @return the veterinarian instance or null if not found
     */
    Veterinarian findByName(String name);

    /**
     * Return an veterinarian instance with specified id.
     *
     * @param id the id of the veterinarian to return.
     * @return the veterinarian instance or null if not found
     */
    Veterinarian findOne(Long id);

    /**
     * Return all veterinarians in the database.
     *
     * @return The list of veterinarians.
     */
    List<Veterinarian> findAll();

}
