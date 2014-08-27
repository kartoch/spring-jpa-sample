package fr.plil.sio.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("animalService")
public class AnimalServiceImpl implements AnimalService {

    private final static Logger logger = LoggerFactory.getLogger(AnimalServiceImpl.class);

    @Override
    public Animal create(String nameAnimal, String nameOwner) {
        logger.debug("to complete");
        return null;
    }

    @Override
    public void remove(String name) {
        logger.debug("to complete");
    }

    @Override
    public List<Animal> findAll() {
        logger.debug("to complete");
        return null;
    }

    @Override
    public Animal findByName(String name) {
        logger.debug("to complete");
        return null;
    }
}