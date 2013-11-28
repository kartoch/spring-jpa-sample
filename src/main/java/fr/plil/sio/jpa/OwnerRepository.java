package fr.plil.sio.jpa;

import java.util.List;

public interface OwnerRepository {

    /**
     * Save or update an owner instance in the database. If the owner is not present in the database (i.e. if not
     * other owner in the database has the same name), set the id to an unique number and save it. If the owner is
     * already present in the database (i.e. an owner entry exist with the same id), update the name of the database
     * entry with the value of the instance passed in parameter.
     *
     * @param owner the instance of owner to save or update.
     * @return the owner instance
     * @throws NullPointerException          if owner is null or if owner name is null
     * @throws IllegalStateException         if an owner exist with the same name but different id
     * @throws UnsupportedOperationException in case of SQL problems
     */
    Owner save(Owner owner);

    /**
     * Remove the owner instance from the database.
     *
     * @param owner the owner to delete from the database.
     * @throws NullPointerException          if owner is null
     * @throws IllegalStateException         if owner is not present in the database
     * @throws UnsupportedOperationException in case of SQL problems
     */
    void delete(Owner owner);

    /**
     * Return an owner instance with specified name. Only one level dependencies are loaded (animals).
     *
     * @param name the name of the owner to return.
     * @return the owner instance or null if not found
     * @throws NullPointerException          if name is null
     * @throws UnsupportedOperationException in case of SQL problems
     */
    Owner findByName(String name);

    /**
     * Return an owner instance with specified id. Only one level dependencies are loaded (animals).
     *
     * @param id the id of the owner to return.
     * @return the owner instance or null if not found
     * @throws NullPointerException          if id is null
     * @throws UnsupportedOperationException in case of SQL problems
     */
    Owner findOne(Long id);

    /**
     * Return all owners in the database. Only one level dependencies are loaded (animals).
     *
     * @return The list of owners.
     * @throws UnsupportedOperationException in case of SQL problems
     */
    List<Owner> findAll();
}
