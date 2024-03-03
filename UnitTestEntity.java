package com.humans.aliens;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UnitTestEntity {
	
	private Entity testEntity;
	private Entity testDifferentEntity;
	private String name1 = "ExampleName1";
	private String name2 = "ExampleName2";	
	private int endurance = 100;
	private int athleticism = 100;	
	private int toughness = 100;

	@Before
	public void setUp() throws Exception {
		testEntity = new Entity(name1, endurance, athleticism, toughness);
		testDifferentEntity = new Entity(name2, endurance, athleticism, toughness);
	}

	@Test
	public void testEntity() { 
		assertEquals(name1, testEntity.getName());
		assertEquals(100, testEntity.getHealth());
		assertEquals(endurance, testEntity.getEndurance());
		assertEquals(athleticism, testEntity.getAthleticism());
	    assertEquals(toughness, testEntity.getToughness());
	    String newName = "NewName";
	    int newInt = 50;
	    testEntity.setName(newName);
	    testEntity.setHealth(newInt);
	    testEntity.setEndurance(newInt);
	    testEntity.setAthleticism(newInt);
	    testEntity.setToughness(newInt);
		assertEquals(newName, testEntity.getName());
		assertEquals(newInt, testEntity.getHealth());
		assertEquals(newInt, testEntity.getEndurance());
		assertEquals(newInt, testEntity.getAthleticism());
	    assertEquals(newInt, testEntity.getToughness());
	    testEntity.setHealth(-1);
	    assertEquals(0, testEntity.getHealth());

	}
  @Test
  public void testIsEqualTo() {  
	assertEquals(true, testEntity.isEqualTo(testEntity));
	assertEquals(false, testEntity.isEqualTo(testDifferentEntity));
  }
	
	@Test
	public void testStrain() {
		int time = 99;
		testEntity.strain(time);
		assertEquals(1, testEntity.getEndurance());
		testEntity.strain(1);
		assertEquals(0, testEntity.getEndurance());    
		testEntity.strain(1);
		assertEquals(0, testEntity.getEndurance());     
	}	

  @Test
  public void testTakeDamage() {
    testEntity.takeDamage(10);
    assertEquals(90, testEntity.getHealth());
  }

  @Test
  public void testAttack() {
    Weapon testWeapon = new Weapon(100, 100);
    testEntity.setWeapon(testWeapon);
    Weapon theSameWeapon = testEntity.getWeapon();
    assertEquals(100, testEntity.attack());
  }

  @Test
  public void testToString() {
    String testString = "Name: ExampleName1 Health: 100 Endurance: 100 Athleticism: 100 Toughness: 100";
    assertEquals(testString, testEntity.toString());
  }
  
}