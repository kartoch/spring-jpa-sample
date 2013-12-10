package fr.plil.sio.jpa;

import java.util.List;

public interface VeterinarianRepository {

    /**
     * Save or update an veterinarian instance in the database. If the veterinarian is not present in the database
     * (i.e. if not other veterinarian in the database has the same name), set the id to an unique number and save it.
     *
     * @param veterinarian the instance of veterinarian to save or update.
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
     * Return an veterinarian instance with specified name. Only one level dependencies are loaded (animals).
     *
     * @param name the name of the veterinarian to return.
     * @return the veterinarian instance or null if not found
     */
    Veterinarian findByName(String name);

    /**
     * Return an veterinarian instance with specified id. Only one level dependencies are loaded (animals).
     *
     * @param id the id of the veterinarian to return.
     * @return the veterinarian instance or null if not found
     */
    Veterinarian findOne(Long id);

    /**
     * Return all veterinarians in the database. Only one level dependencies are loaded (animals).
     *
     * @return The list of veterinarians.
     */
    List<Veterinarian> findAll();

}
