package fr.plil.sio.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/jpa-example.xml"})
@TransactionConfiguration
@Transactional
public class ExampleFromCourseTest {

    @PersistenceContext
    private EntityManager entityManager;

    private final static Logger logger = LoggerFactory.getLogger(ExampleFromCourseTest.class);

    @Test
    public void testEntityManager() {

        Owner owner = new Owner();
        owner.setName("Mickey");
        entityManager.persist(owner);

        logger.debug("Mickey persisted");

        Animal animal = new Animal();
        animal.setName("pluto");
        owner.addAnimal(animal);
        entityManager.persist(animal);

        logger.debug("Pluto persisted");

        owner.setName("Minnie");
        entityManager.merge(owner);

        logger.debug("Minnie merged");

        animal.setName("Mickey");
        entityManager.merge(animal);

        logger.debug("Mickey merged");

        Query query = entityManager.createQuery("SELECT a FROM Animal a");
        List<Animal> animals = query.getResultList();

        logger.debug("Get animals");

        Animal animal1 = animals.get(0);
        animal1.setName("Plutooooo");
        entityManager.merge(animal1);

        logger.debug("reference animal: " + animal + ", reference animal1: " + animal1);

        entityManager.remove(owner);

        // need to avoid rollback effect on last operations
        entityManager.flush();
    }

}
