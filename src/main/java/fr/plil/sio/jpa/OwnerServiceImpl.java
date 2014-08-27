package fr.plil.sio.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

public class OwnerServiceImpl implements OwnerService {

    private final static Logger logger = LoggerFactory.getLogger(AnimalServiceImpl.class);

    @Override
    public Owner create(String name) {
        logger.debug("to complete");
        return null;
    }

    @Override
    public void remove(String name) {
        logger.debug("to complete");
    }

    @Override
    public List<Owner> findAll() {
        logger.debug("to complete");
        return null;
    }

    @Override
    public Owner findByName(String name) {
        logger.debug("to complete");
        return null;
    }
}
