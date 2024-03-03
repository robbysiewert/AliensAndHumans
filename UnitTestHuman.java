package com.humans.aliens;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UnitTestHuman {

	private Human testHuman;
	private String name = "ExampleName";

  private int endurance = 50;
  private int athleticism = 50;
  private int toughness = 50;

	@Before
	public void setUp() throws Exception {
		testHuman = new Human(name);
	}

	@Test
	public void testHuman() { 
		assertEquals(name, testHuman.getName());
		assertEquals(100, testHuman.getHealth());
		assertEquals(endurance, testHuman.getEndurance());
		assertEquals(athleticism, testHuman.getAthleticism());
    assertEquals(toughness, testHuman.getToughness());    
  }

  @Test
  public void testBuildArmor() {  
    testHuman.buildArmor(10);
    assertEquals(100, testHuman.getToughness());
    assertEquals(30, testHuman.getEndurance());
  }

  @Test
  public void testBuildWeapon() {
    Weapon testHumanBuiltWeapon = testHuman.buildWeapon(1);
    assertEquals(5, testHumanBuiltWeapon.getDamage());
    assertEquals(20, testHumanBuiltWeapon.getResilience());
  }

  @Test
  public void testEat() {
    testHuman.setEndurance(80);
    testHuman.eat();
    assertEquals(90, testHuman.getEndurance());
    testHuman.eat();
    testHuman.eat();    
    assertEquals(100, testHuman.getEndurance());    
  }    
      
}