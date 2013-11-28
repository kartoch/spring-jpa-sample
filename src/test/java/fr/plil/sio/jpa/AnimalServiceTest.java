package fr.plil.sio.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/jpa-example.xml"})
@TransactionConfiguration
@Transactional
public class AnimalServiceTest {

    @Resource
    private AnimalService animalService;

    @Resource
    private OwnerService ownerService;

    @Test
    public void testCreateAnimal() {
        ownerService.createOwner("owner");
        Owner owner = ownerService.findByName("owner");
        animalService.createAnimal("animal", "owner");
        assertEquals(1, animalService.findAll().size());
        Animal animal = animalService.findByName("animal");
        assertEquals(owner, animal.getOwner());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAnimalFailsIfNameNull() {
        ownerService.createOwner("owner");
        Owner owner = ownerService.findByName("owner");
        animalService.createAnimal(null, "owner");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAnimalFailsIfOwnerNotFound() {
        animalService.createAnimal("animal", "not-an-owner");
    }

    @Test
    public void testRemoveAnimal() {
        ownerService.createOwner("owner");
        Owner owner = ownerService.findByName("owner");
        Animal animal = animalService.createAnimal("animal", "owner");
        animalService.removeAnimal("animal");
        assertEquals(0, animalService.findAll().size());
        assertNull(animalService.findByName("animal"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAnimalFailsIfAnimalNotFound() {
        animalService.removeAnimal("not-an-animal");
    }

    @Test
    public void testGetAnimals() {
        ownerService.createOwner("owner");
        Owner owner = ownerService.findByName("owner");
        animalService.createAnimal("animal1", "owner");
        animalService.createAnimal("animal2", "owner");
        List<Animal> animals = animalService.findAll();
        assertEquals(2, animals.size());
        for (Animal animal : animals) {
            assertEquals(animal.getOwner(), owner);
        }
    }

    @Test
    public void testFindAnimalByName() {
        ownerService.createOwner("owner");
        Owner owner = ownerService.findByName("owner");
        animalService.createAnimal("animal1", "owner");
        Animal animal = animalService.findByName("animal1");
        assertNotNull(animal);
        assertEquals(owner, animal.getOwner());
    }
}