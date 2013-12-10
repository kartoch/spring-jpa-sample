package fr.plil.sio.jpa;

import java.util.List;

public interface OwnerRepository {

    /**
     * Save or update an owner instance in the database. If the owner is not present in the database (i.e. if not
     * other owner in the database has the same name), set the id to an unique number and save it.
     *
     * @param owner the instance of owner to save or update.
     * @return the owner instance
     */
    Owner save(Owner owner);

    /**
     * Remove the owner instance from the database.
     *
     * @param owner the owner to delete from the database.
     */
    void delete(Owner owner);

    /**
     * Return an owner instance with specified name. Only one level dependencies are loaded (animals).
     *
     * @param name the name of the owner to return.
     * @return the owner instance or null if not found
     */
    Owner findByName(String name);

    /**
     * Return an owner instance with specified id. Only one level dependencies are loaded (animals).
     *
     * @param id the id of the owner to return.
     * @return the owner instance or null if not found
     */
    Owner findOne(Long id);

    /**
     * Return all owners in the database. Only one level dependencies are loaded (animals).
     *
     * @return The list of owners.
     */
    List<Owner> findAll();
}
