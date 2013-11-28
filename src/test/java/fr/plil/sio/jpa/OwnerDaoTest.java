package fr.plil.sio.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/jpa-example.xml"})
@TransactionConfiguration
@Transactional
public class OwnerDaoTest {

    @Resource
    private OwnerRepository ownerRepository;

    @Resource
    private AnimalRepository animalRepository;

    @Test
    public void testSave() {
        Owner owner = new Owner();
        owner.setName("owner");
        ownerRepository.save(owner);
    }

    @Test
    public void testUpdate() {
        Owner owner = new Owner();
        owner.setName("owner");
        ownerRepository.save(owner);
        Owner o = ownerRepository.findByName("owner");
        o.setName("better owner");
        ownerRepository.save(o);
        o = ownerRepository.findByName("better owner");
        assertEquals("better owner", o.getName());
    }

    @Test
    public void testDelete() {
        Owner owner = new Owner();
        owner.setName("owner");
        ownerRepository.save(owner);
        Animal animal1 = new Animal();
        animal1.setName("animal1");
        owner.addAnimal(animal1);
        animalRepository.save(animal1);
        Animal animal2 = new Animal();
        animal2.setName("animal2");
        owner.addAnimal(animal2);
        animalRepository.save(animal2);
        Animal animal3 = new Animal();
        animal3.setName("animal");
        owner.addAnimal(animal3);
        animalRepository.save(animal3);

        Owner o = ownerRepository.findByName("owner");
        ownerRepository.delete(o);
        o = ownerRepository.findByName("owner");
        assertNull(o);
        assertEquals(0, animalRepository.findAll().size());
    }

    @Test
    public void testFindByName() {
        Owner owner = new Owner();
        owner.setName("owner");
        ownerRepository.save(owner);
        Animal animal1 = new Animal();
        animal1.setName("animal1");
        owner.addAnimal(animal1);
        animalRepository.save(animal1);
        Animal animal2 = new Animal();
        animal2.setName("animal2");
        owner.addAnimal(animal2);
        animalRepository.save(animal2);
        Animal animal3 = new Animal();
        animal3.setName("animal");
        owner.addAnimal(animal3);
        animalRepository.save(animal3);

        Owner o = ownerRepository.findByName("owner");
        assertEquals("owner", o.getName());
        assertEquals(3, o.getAnimals().size());
        for (Animal a : o.getAnimals()) {
            assertSame(o, a.getOwner());
        }
    }

    @Test
    public void testFindById() {
        Owner owner = new Owner();
        owner.setName("owner");
        ownerRepository.save(owner);
        Animal animal1 = new Animal();
        animal1.setName("animal1");
        owner.addAnimal(animal1);
        animalRepository.save(animal1);
        Animal animal2 = new Animal();
        animal2.setName("animal2");
        owner.addAnimal(animal2);
        animalRepository.save(animal2);
        Animal animal3 = new Animal();
        animal3.setName("animal");
        owner.addAnimal(animal3);
        animalRepository.save(animal3);

        Owner o = ownerRepository.findOne(owner.getId());
        assertEquals("owner", o.getName());
        assertEquals(3, o.getAnimals().size());
        for (Animal a : o.getAnimals()) {
            assertSame(o, a.getOwner());
        }
    }


    @Test
    public void testfindAll() {
        Owner owner = new Owner();
        owner.setName("owner");
        ownerRepository.save(owner);
        Animal animal1 = new Animal();
        animal1.setName("animal1");
        owner.addAnimal(animal1);
        animalRepository.save(animal1);
        Animal animal2 = new Animal();
        animal2.setName("animal2");
        owner.addAnimal(animal2);
        animalRepository.save(animal2);
        Animal animal3 = new Animal();
        animal3.setName("animal");
        owner.addAnimal(animal3);
        animalRepository.save(animal3);

        Owner owner2 = new Owner();
        owner2.setName("owner2");
        ownerRepository.save(owner2);
        Animal animal4 = new Animal();
        animal4.setName("animal4");
        owner2.addAnimal(animal4);
        animalRepository.save(animal4);
        Animal animal5 = new Animal();
        animal5.setName("animal5");
        owner2.addAnimal(animal5);
        animalRepository.save(animal5);

        assertEquals(2, ownerRepository.findAll().size());
        assertEquals(5, animalRepository.findAll().size());
    }
}
