package fr.plil.sio.jpa;

import java.util.List;

public interface OwnerRepository {

    /**
     * Save an owner instance in the database.
     *
     * @param owner the instance of owner to save.
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
     * Return an owner instance with specified name.
     *
     * @param name the name of the owner to return.
     * @return the owner instance or null if not found
     */
    Owner findByName(String name);

    /**
     * Return an owner instance with specified id.
     *
     * @param id the id of the owner to return.
     * @return the owner instance or null if not found
     */
    Owner findOne(Long id);

    /**
     * Return all owners in the database.
     *
     * @return The list of owners.
     */
    List<Owner> findAll();
}
