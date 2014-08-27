package fr.plil.sio.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class VeterinarianServiceImpl implements VeterinarianService {

    private final static Logger logger = LoggerFactory.getLogger(VeterinarianServiceImpl.class);

    @Override
    public Veterinarian create(String name) {
        logger.debug("to complete");
        return null;
    }

    @Override
    public void remove(String name) {
        logger.debug("to complete");
    }

    @Override
    public List<Veterinarian> findAll() {
        logger.debug("to complete");
        return null;
    }

    @Override
    public Veterinarian findByName(String name) {
        logger.debug("to complete");
        return null;
    }

    @Override
    public boolean addAnimal(String animalName, String veterinarianName) {
        logger.debug("to complete");
        return false;
    }

    @Override
    public boolean removeAnimal(String animalName, String veterinarianName) {
        logger.debug("to complete");
        return false;
    }
}
