package fr.plil.sio.jpa;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class OwnerServiceTest {

    @Resource
    private OwnerService ownerService;

    @Resource
    private AnimalService animalService;

    private Owner owner;

    @Before
    public void before() {
        owner = ownerService.create("owner");
        animalService.create("animal1", "owner");
        animalService.create("animal2", "owner");
    }

    @Test
    public void testCreateOwner() {
        assertNotNull(owner);
        assertEquals("owner", owner.getName());
        assertEquals(1, ownerService.findAll().size());
        assertEquals(2, owner.getAnimals().size());
    }

    @Test(expected = NullPointerException.class)
    public void testCreateOwnerFailsIfOwnerNull() {
        ownerService.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateOwnerFailsIfOwnerPresent() {
        ownerService.create("owner");
    }

    @Test
    public void testRemoveOwner() {
        ownerService.remove("owner");
        assertEquals(0, ownerService.findAll().size());
        assertEquals(0, animalService.findAll().size());
        assertNull(animalService.findByName("animal1"));
        assertNull(animalService.findByName("animal2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveOwnerFailsIfOwnerNotPresent() {
        ownerService.remove("owner-dummy");
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveOwnerFailsIfOwnerNull() {
        ownerService.remove(null);
    }

    @Test
    public void testfindAll() {
        ownerService.create("owner2");
        assertEquals(2, ownerService.findAll().size());
    }

    @Test
    public void testFindByName() {
        Owner owner1 = ownerService.findByName("owner");
        assertNotNull(owner1);
        Owner owner2 = ownerService.findByName("dummy");
        assertNull(owner2);
    }

    @Test(expected = NullPointerException.class)
    public void testFindByNameFailsIfNameNull() {
        ownerService.findByName(null);
    }
}