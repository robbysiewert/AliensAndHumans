package com.humans.aliens;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UnitTestAlien {

	private Alien testAlien;
	private String name = "ExampleName";

	private int endurance = 100;
	private int athleticism = 100;
	private int toughness = 100;

	@Before
	public void setUp() throws Exception {
		testAlien = new Alien(name);
	}

	@Test
	public void testAlien() { 
		assertEquals(name, testAlien.getName());
		assertEquals(100, testAlien.getHealth());
		assertEquals(endurance, testAlien.getEndurance());
		assertEquals(athleticism, testAlien.getAthleticism());
		assertEquals(toughness, testAlien.getToughness());    
  }

  @Test
  public void testHealth() {
    testAlien.setHealth(80);
    testAlien.heal(10);
    assertEquals(90, testAlien.getHealth());
    testAlien.heal(10);
    testAlien.heal(10);    
    assertEquals(100, testAlien.getHealth());    
  }

  @Test
  public void testWarmUp() {
    testAlien.warmUp(1);
    System.out.println(testAlien.getEndurance());
    System.out.println(testAlien.getAthleticism());
    assertEquals(98, testAlien.getEndurance());
    assertEquals(101, testAlien.getAthleticism());    
  }
       
}