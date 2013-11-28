package fr.plil.sio.jpa;

import java.util.List;

public interface VeterinarianService {

    /**
     * Create an veterinarian.
     *
     * @param name name of the veterinarian
     * @return the new veterinarian instance
     * @throws NullPointerException  if name is null
     * @throws IllegalStateException if an veterinarian with the same name exist in the database
     */
    Veterinarian createVeterinarian(String name);

    /**
     * Delete an veterinarian from the database and remove all attached animals.
     *
     * @param name name of the veterinarian to delete
     * @throws NullPointerException  if name is null
     * @throws IllegalStateException if veterinarian does not exist in the database.
     */
    void removeVeterinarian(String name);

    /**
     * Return all veterinarians in the database. Only one level dependencies are loaded (animals).
     *
     * @return The list of veterinarians.
     */
    List<Veterinarian> findAll();

    /**
     * Return a veterinarian instance with specified name. Only one level dependencies are loaded (animals).
     *
     * @param name the name of the veterinarian to return.
     * @return the veterinarian instance or null if not found
     * @throws NullPointerException if parameter is null
     */
    Veterinarian findByName(String name);

    /**
     * Add an animal to a veterinarian in the database.
     *
     * @param animal_name       the animal name to add
     * @param veterinarian_name the veterinarian name added to the animal
     * @return false if animal was already associated to veterinarian, false else
     * @throws NullPointerException if animal name or veterinarian name is null
     */
    boolean addAnimalToVeterinarian(String animal_name, String veterinarian_name);


    /**
     * Remove an animal to a veterinarian in the database.
     *
     * @param animal_name       the animal name to remove
     * @param veterinarian_name the veterinarian name removed from the animal
     * @return false if animal was not associated to veterinarian, false else
     * @throws NullPointerException  if animal name or veterinarian name is null
     * @throws IllegalStateException if animal or veterinarian is not found in the database
     */
    boolean removeAnimalToVeterinarian(String animal_name, String veterinarian_name);
}
