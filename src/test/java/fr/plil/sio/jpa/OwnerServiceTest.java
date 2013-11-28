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
public class OwnerServiceTest {

    @Resource
    public OwnerService ownerService;

    @Test
    public void testCreateOwner() {
        Owner owner = ownerService.createOwner("owner");
        assertNotNull(owner);
        assertEquals("owner", owner.getName());
        assertEquals(1, ownerService.findAll().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateOwnerFailsIfOwnerNull() {
        ownerService.createOwner(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateOwnerFailsIfOwnerPresent() {
        ownerService.createOwner("owner");
        ownerService.createOwner("owner");
    }

    @Test
    public void testRemoveOwner() {
        Owner owner = ownerService.createOwner("owner");
        ownerService.removeOwner("owner");
        assertEquals(0, ownerService.findAll().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveOwnerFailsIfOwnerNotPresent() {
        ownerService.removeOwner("owner");
    }

    @Test
    public void testfindAll() {
        ownerService.createOwner("owner1");
        ownerService.createOwner("owner2");
        List<Owner> owners = ownerService.findAll();
        assertEquals(2, owners.size());
    }

    @Test
    public void testFindByName() {
        ownerService.createOwner("owner1");
        Owner owner1 = ownerService.findByName("owner1");
        assertNotNull(owner1);
        Owner owner2 = ownerService.findByName("dummy");
        assertNull(owner2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByNameFailsIfNameNull() {
        ownerService.findByName(null);
    }
}