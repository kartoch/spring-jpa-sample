package fr.plil.sio.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.List;

public class VeterinarianRepositoryJpa implements VeterinarianRepository {

    private final static Logger logger = LoggerFactory.getLogger(VeterinarianRepositoryJpa.class);

    private Connection connection;

    @Override
    public Veterinarian save(Veterinarian veterinarian) {
        logger.error("to complete");
        return null;
    }

    @Override
    public void delete(Veterinarian veterinarian) {
        logger.error("to complete");
    }

    @Override
    public Veterinarian findByName(String name) {
        logger.error("to complete");
        return null;
    }

    @Override
    public Veterinarian findOne(Long id) {
        logger.error("to complete");
        return null;
    }

    @Override
    public List<Veterinarian> findAll() {
        logger.error("to complete");
        return null;
    }

    public Veterinarian findOneWithoutDependencies(Long id) {
        logger.warn("recommanded useful function");
        return null;
    }
}
