package fr.plil.sio.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("animalRepository")
public class AnimalRepositoryJpa implements AnimalRepository {

    private final static Logger logger = LoggerFactory.getLogger(AnimalRepositoryJpa.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Animal save(Animal animal) {
        entityManager.persist(animal);
        return animal;
    }

    @Override
    @Transactional
    public void delete(Animal animal) {
        entityManager.remove(animal);
    }

    @Override
    @Transactional(readOnly = true)
    public Animal findByName(String name) {
        try {
            Query q = entityManager.createQuery("SELECT a FROM Animal a WHERE a.name = ?").setParameter(1, name);
            return (Animal) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    @Transactional
    public Animal findOne(Long id) {
        return entityManager.find(Animal.class, id);
    }

    @Override
    @Transactional
    public List<Animal> findAll() {
        Query q = entityManager.createQuery("SELECT a FROM Animal a");
        return q.getResultList();
    }
}
