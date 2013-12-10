package fr.plil.sio.jpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository("veterinarianRepository")
public class VeterinarianRepositoryJpa implements VeterinarianRepository {

    private final static Logger logger = LoggerFactory.getLogger(VeterinarianRepositoryJpa.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Veterinarian save(Veterinarian veterinarian) {
        entityManager.persist(veterinarian);
        return veterinarian;
    }

    @Override
    @Transactional
    public void delete(Veterinarian veterinarian) {
        entityManager.remove(veterinarian);
    }

    @Override
    @Transactional(readOnly = true)
    public Veterinarian findByName(String name) {
        Query q = entityManager.createQuery("SELECT v FROM Veterinarian v WHERE o.name = ?").setParameter(1, name);
        return (Veterinarian) q.getSingleResult();
    }

    @Override
    @Transactional(readOnly = true)
    public Veterinarian findOne(Long id) {
        return entityManager.find(Veterinarian.class, id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Veterinarian> findAll() {
        Query q = entityManager.createQuery("SELECT v FROM Veterinarian");
        return q.getResultList();
    }
}
