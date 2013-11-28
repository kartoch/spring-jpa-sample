package fr.plil.sio.jpa;

import java.util.List;

public interface VeterinarianRepository {

    /**
     * Save or update an veterinarian instance in the database. If the veterinarian is not present in the database
     * (i.e. if not other veterinarian in the database has the same name), set the id to an unique number and save it.
     * If the veterinarian is already present in the database (i.e. an veterinarian entry exist with the same id),
     * update the name of the database entry with the value of the instance passed in parameter.
     *
     * @param veterinarian the instance of veterinarian to save or update.
     * @return the veterinarian instance
     * @throws NullPointerException          if parameter is null or if veterinarian name is null
     * @throws IllegalStateException         if an veterinarian exist with the same name but different id
     * @throws UnsupportedOperationException in case of SQL problems
     */
    Veterinarian save(Veterinarian veterinarian);

    /**
     * Remove the veterinarian instance from the database.
     *
     * @param veterinarian the veterinarian to delete from the database.
     * @throws NullPointerException          if parameter is null
     * @throws IllegalStateException         if veterinarian is not present in the database
     * @throws UnsupportedOperationException in case of SQL problems
     */
    void delete(Veterinarian veterinarian);

    /**
     * Return an veterinarian instance with specified name. Only one level dependencies are loaded (animals).
     *
     * @param name the name of the veterinarian to return.
     * @return the veterinarian instance or null if not found
     * @throws NullPointerException          if parameter is null
     * @throws UnsupportedOperationException in case of SQL problems
     */
    Veterinarian findByName(String name);

    /**
     * Return an veterinarian instance with specified id. Only one level dependencies are loaded (animals).
     *
     * @param id the id of the veterinarian to return.
     * @return the veterinarian instance or null if not found
     * @throws NullPointerException          if id is null
     * @throws UnsupportedOperationException in case of SQL problems
     */
    Veterinarian findOne(Long id);

    /**
     * Return all veterinarians in the database. Only one level dependencies are loaded (animals).
     *
     * @return The list of veterinarians.
     * @throws UnsupportedOperationException in case of SQL problems
     */
    List<Veterinarian> findAll();

}
