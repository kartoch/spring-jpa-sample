package fr.plil.sio.jpa;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    private Animal animal1, animal2, animal1b;

    @Before
    public void createInstance() {
        animal1 = new Animal();
        animal1.setName("animal1");
        animal2 = new Animal();
        animal2.setName("animal2");
        animal1b = new Animal();
        animal1b.setName("animal1");
    }

    @Test
    public void testEquals() {
        assertTrue(animal1.equals(animal1b));
        assertFalse(animal1.equals(animal2));
        assertFalse(animal1b.equals(animal2));
    }

    @Test
    public void testHashcode() {
        assertEquals(animal1.hashCode(), animal1b.hashCode());
        assertFalse(animal1.hashCode() == animal2.hashCode());
        assertFalse(animal1b.hashCode() == animal2.hashCode());
    }

    @Test
    public void testCompareTo() {
        assertTrue(animal1.compareTo(animal1b) == 0);
        assertFalse(animal1.compareTo(animal2) > 0);
        assertFalse(animal2.compareTo(animal1b) < 0);
    }
}
