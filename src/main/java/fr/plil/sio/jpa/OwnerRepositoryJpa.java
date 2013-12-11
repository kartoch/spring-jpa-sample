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

@Repository("ownerRepository")
public class OwnerRepositoryJpa implements OwnerRepository {

    private final static Logger logger = LoggerFactory.getLogger(OwnerRepositoryJpa.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Owner save(Owner owner) {
        entityManager.persist(owner);
        return owner;
    }

    @Override
    @Transactional
    public void delete(Owner owner) {
        entityManager.remove(owner);
    }

    @Override
    @Transactional(readOnly = true)
    public Owner findByName(String name) {
        try {
            Query q = entityManager.createQuery("SELECT o FROM Owner o WHERE o.name = ?").setParameter(1, name);
            return (Owner) q.getSingleResult();
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Owner findOne(Long id) {
        return entityManager.find(Owner.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Owner> findAll() {
        Query q = entityManager.createQuery("SELECT o FROM Owner o");
        return q.getResultList();
    }
}
