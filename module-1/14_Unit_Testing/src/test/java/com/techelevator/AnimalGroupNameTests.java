package com.techelevator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalGroupNameTests {
	
	@Test
	public void ProvideKnownAnimalName_ExpectKnownHerdName() {
		// Arrange
		AnimalGroupName animalGroup = new AnimalGroupName();
		
		// Act
		String herdName = animalGroup.getHerd("giraffe");
		
		// Assert
		assertEquals("Tower", herdName);
	}
	
	@Test
	public void ProvideKnowAnimalName_CrazyCase_ExpectKnownHerdName() {
        //Arrange
        AnimalGroupName animalGroup = new AnimalGroupName();

        //Act
        String herdName = animalGroup.getHerd("GiRAffe");

        //Assert
        assertEquals("Tower", herdName);
	}
	
	@Test
	public void ProvideUnknownAnimalName_ExpectUnknownHerdName() {
        //Arrange
        AnimalGroupName animalGroup = new AnimalGroupName();

        //Act
        String herdName = animalGroup.getHerd("");
        String herdName2 = animalGroup.getHerd("elephants");

        //Assert
        assertEquals("unknown", herdName);
        assertEquals("unknown", herdName2);
    }

	
}
