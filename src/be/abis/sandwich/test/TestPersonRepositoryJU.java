package be.abis.sandwich.test;

import be.abis.sandwich.model.Manager;
import be.abis.sandwich.model.Role;
import be.abis.sandwich.repository.MemoryPersonRepository;
import be.abis.sandwich.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.jupiter.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestPersonRepositoryJU {
    @Mock PersonRepository pr = new MemoryPersonRepository();


    @Test
    public void testCreateMemoryPerson(){
        assertFalse(pr.findAllPersons().isEmpty());
    }

    @Test
    public void testHasRole(){
        pr.findAllPersons().get(0).addRole(new Manager());
        assertTrue(pr.findAllPersons().get(0).hasRole("Manager"));
    }
}
