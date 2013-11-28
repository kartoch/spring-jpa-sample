package fr.plil.sio.jpa;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/jpa-example.xml"})
@TransactionConfiguration
@Transactional
public class AnimalDaoTest {

    @Resource
    private AnimalRepository animalRepository;

    @Resource
    private OwnerRepository ownerRepository;

    private Owner owner, owner2;

    private Animal animal, animal1, animal2, animal3, animal4, animal5;

    @Before
    public void createInstances() {
        animal = new Animal();
        animal.setName("animal");
        owner = new Owner();
        owner.setName("owner");
        ownerRepository.save(owner);
        owner.addAnimal(animal);
        animalRepository.save(animal);
        animal1 = new Animal();
        animal1.setName("animal1");
        owner.addAnimal(animal1);
        animalRepository.save(animal1);
        animal2 = new Animal();
        animal2.setName("animal2");
        owner.addAnimal(animal2);
        animalRepository.save(animal2);
        animal3 = new Animal();
        animal3.setName("animal3");
        owner.addAnimal(animal3);
        animalRepository.save(animal3);

        owner2 = new Owner();
        owner2.setName("owner2");
        ownerRepository.save(owner2);
        animal4 = new Animal();
        animal4.setName("animal4");
        owner2.addAnimal(animal4);
        animalRepository.save(animal4);
        animal5 = new Animal();
        animal5.setName("animal5");
        owner2.addAnimal(animal5);
        animalRepository.save(animal5);
    }

    @Test
    public void testSave() {
        List<Animal> animals = animalRepository.findAll();
        assertEquals(6, animals.size());
    }

    @Test
    public void testUpdate() {
        Animal a = animalRepository.findByName("animal4");
        a.setName("better animal");
        animalRepository.save(a);
        a = animalRepository.findByName("better animal");
        assertEquals("better animal", a.getName());
    }

    @Test
    public void testDelete() {
        Animal a = animalRepository.findByName("animal");
        animalRepository.delete(a);
        assertEquals(5, animalRepository.findAll().size());
        a = animalRepository.findByName("animal1");
        animalRepository.delete(a);
        assertEquals(4, animalRepository.findAll().size());
        a = animalRepository.findByName("animal2");
        animalRepository.delete(a);
        assertEquals(3, animalRepository.findAll().size());
        a = animalRepository.findByName("animal3");
        animalRepository.delete(a);
        assertEquals(2, animalRepository.findAll().size());
        a = animalRepository.findByName("animal4");
        animalRepository.delete(a);
        assertEquals(1, animalRepository.findAll().size());
        a = animalRepository.findByName("animal5");
        animalRepository.delete(a);
        assertEquals(0, animalRepository.findAll().size());
    }

    @Test
    public void testFindByName() {
        Animal a = animalRepository.findByName("animal");
        Owner o1 = a.getOwner();
        assertEquals(4, o1.getAnimals().size());
        for (Animal as1 : o1.getAnimals()) {
            assertSame(as1.getOwner(), o1);
        }
        Animal a1 = animalRepository.findByName("animal1");
        assertEquals(o1, a1.getOwner());
        Animal a2 = animalRepository.findByName("animal2");
        assertEquals(o1, a2.getOwner());
        Animal a3 = animalRepository.findByName("animal3");
        assertEquals(o1, a3.getOwner());

        Animal abis = animalRepository.findByName("animal4");
        Owner o2 = abis.getOwner();
        assertEquals(2, o2.getAnimals().size());
        for (Animal as2 : o2.getAnimals()) {
            assertSame(as2.getOwner(), o2);
        }
        Animal a4 = animalRepository.findByName("animal4");
        assertEquals(o2, a4.getOwner());
        Animal a5 = animalRepository.findByName("animal5");
        assertEquals(o2, a5.getOwner());
    }
}
