package fr.plil.sio.jpa;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OwnerTest {

    private Owner owner1, owner1b, owner2;
    private Animal animal1;

    @Before
    public void createInstance() {
        owner1 = new Owner();
        owner1.setName("owner1");
        owner2 = new Owner();
        owner2.setName("owner2");
        owner1b = new Owner();
        owner1b.setName("owner1");
        animal1 = new Animal();
        animal1.setName("animal1");
    }

    @Test
    public void testAddAnimal() {
        owner1.addAnimal(animal1);
        assertEquals(1, owner1.getAnimals().size());
        assertSame(animal1, owner1.getAnimals().iterator().next());
        assertSame(owner1, animal1.getOwner());
    }

    @Test
    public void testRemoveAnimal() {
        owner1.addAnimal(animal1);
        owner1.removeAnimal(animal1);
        assertEquals(0, owner1.getAnimals().size());
        assertNull(animal1.getOwner());
    }

    @Test
    public void testEquals() {
        assertTrue(owner1.equals(owner1b));
        assertFalse(owner1.equals(owner2));
        assertFalse(owner1b.equals(owner2));
    }

    @Test
    public void testHashcode() {
        assertEquals(owner1.hashCode(), owner1b.hashCode());
        assertFalse(owner1.hashCode() == owner2.hashCode());
        assertFalse(owner1b.hashCode() == owner2.hashCode());
    }

    @Test
    public void testCompareTo() {
        assertTrue(owner1.compareTo(owner1b) == 0);
        assertFalse(owner1.compareTo(owner2) > 0);
        assertFalse(owner2.compareTo(owner1b) < 0);
    }
}