package be.abis.sandwich.test;

import be.abis.sandwich.exception.PersonalOrderNotFoundException;
import be.abis.sandwich.model.*;
import be.abis.sandwich.repository.FileSandwichRepository;
import be.abis.sandwich.repository.MemoryPersonRepository;
import be.abis.sandwich.repository.PersonRepository;
import be.abis.sandwich.repository.SandwichRepository;
import be.abis.sandwich.theenums.BreadType;
import be.abis.sandwich.theenums.Course;
import be.abis.sandwich.theenums.SandwichType;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TestFSRepositoryJU {
    @Mock
    SandwichRepository sr = new FileSandwichRepository();

    public TestFSRepositoryJU() throws IOException {
    }

    @Test
    public void testRepository() throws IOException {
        assertFalse(sr.findAllSandwiches().isEmpty());
    }

    @Test
    public void testFindSandwich() throws IOException {
        assertTrue(sr.findSandwichByNameandType("BRIE", SandwichType.CHEESE)!=null);
    }




}
