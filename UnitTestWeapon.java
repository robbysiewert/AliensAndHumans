package com.humans.aliens;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UnitTestWeapon {

	private Entity testEntity;
	private Weapon testWeapon;
	private int damage = 100;
	private int resilience = 100;  
	private String name = "ExampleName";
	private int endurance = 100;
	private int athleticism = 100;	
	private int toughness = 100;

	@Before
	public void setUp() throws Exception {
    testWeapon = new Weapon(damage, resilience);
	testEntity = new Entity(name, endurance, athleticism, toughness);
	}

	@Test
	public void testWeapon() { 
	assertEquals(damage, testWeapon.getDamage());
	assertEquals(resilience, testWeapon.getResilience());
	int testInt = 50;
	testWeapon.setDamage(testInt);
	testWeapon.setResilience(testInt);
	assertEquals(testInt, testWeapon.getDamage());
	assertEquals(testInt, testWeapon.getResilience());
	}

  @Test
  public void testUse() {
    assertEquals(100, testWeapon.use(100));    
    // Calling .use() should have affected the resilience:
    assertEquals(95, testWeapon.getResilience());
  }

  @Test
  public void testToString() {
	String testString = "Damage: 100 Resilience: 100";
	System.out.println(testString);
	System.out.println(testWeapon.toString());
	assertEquals(testString, testWeapon.toString());
  }    


    
      
}