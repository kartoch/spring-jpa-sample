package fr.plil.sio.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class VeterinarianServiceImpl implements VeterinarianService {

    private final static Logger logger = LoggerFactory.getLogger(VeterinarianServiceImpl.class);

    @Override
    public Veterinarian createVeterinarian(String name) {
        logger.error("to complete");
        return null;
    }

    @Override
    public void removeVeterinarian(String name) {
        logger.error("to complete");
    }

    @Override
    public List<Veterinarian> findAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Veterinarian findByName(String name) {
        logger.error("to complete");
        return null;
    }

    @Override
    public boolean addAnimalToVeterinarian(String animal_name, String veterinarian_name) {
        logger.error("to complete");
        return false;
    }

    @Override
    public boolean removeAnimalToVeterinarian(String animal_name, String veterinarian_name) {
        logger.error("to complete");
        return false;
    }
}
