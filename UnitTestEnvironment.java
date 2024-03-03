package com.humans.aliens;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;


public class UnitTestEnvironment {

  private Environment testEnvironment;
	private Human testHuman;
	private Alien testAlien;
	private Weapon testHumanWeapon;
  private Weapon testAlienWeapon;

	@Before
	public void setUp() throws Exception {
    testEnvironment = new Environment();
    testHuman = new Human("ExampleHumanName");
	testAlien = new Alien("ExampleAlienName");    
    testHumanWeapon = new Weapon(100, 100);
    testAlienWeapon = new Weapon(50, 50);
	}

  @Test
  public void testEnvironment() {
    assertEquals(0, testEnvironment.getEntities().size());
    assertEquals(0, testEnvironment.getWeapons().size());
  }

  @Test
  public void testAddGetRemove() {
    // Add
    testEnvironment.addEntity(testHuman);
    testEnvironment.addEntity(testAlien);
    testEnvironment.addWeapon(testHumanWeapon);
    testEnvironment.addWeapon(testAlienWeapon);
    // Get All
    assertEquals(2, testEnvironment.getEntities().size());
    assertEquals(2, testEnvironment.getWeapons().size());
    // Get One
    assertEquals("ExampleHumanName", testEnvironment.getEntity().getName());
    assertEquals("ExampleAlienName", testEnvironment.getEntity(1).getName());
    assertEquals(100, testEnvironment.getWeapon().getDamage());
    assertEquals(50, testEnvironment.getWeapon(1).getDamage());
    // Remove
    testEnvironment.removeEntity(testHuman);
    assertEquals(1, testEnvironment.getEntities().size());
    testEnvironment.removeWeapon(testHumanWeapon);
    assertEquals(1, testEnvironment.getWeapons().size());  
    
  }


 @Test
 public void testPickUpWeapon() {
    testEnvironment.addEntity(testHuman);
    testEnvironment.addEntity(testAlien);
    testEnvironment.addWeapon(testHumanWeapon);
    testEnvironment.addWeapon(testAlienWeapon);  

   testEnvironment.pickUpWeapon(testHuman, testHumanWeapon);
   assertEquals(testHumanWeapon.getDamage(), testHuman.getWeapon().getDamage());    
 }

 @Test
 public void testFight() {
    testEnvironment.addEntity(testHuman);
    testEnvironment.addEntity(testAlien);
    testEnvironment.addWeapon(testHumanWeapon);
    testEnvironment.addWeapon(testAlienWeapon);  

  testEnvironment.pickUpWeapon(testHuman, testHumanWeapon);
  testEnvironment.fight(testHuman, testAlien);
  System.out.println(testAlien.getHealth());
  System.out.println(testHuman.getEndurance());
  assertEquals(0, testAlien.getHealth());
  assertEquals(44, testHuman.getEndurance());
  
 }

      














}