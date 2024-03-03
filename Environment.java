package com.humans.aliens;
import java.util.ArrayList;

public class Environment {

  private ArrayList<Entity> entities;
  private ArrayList<Weapon> weapons;

  public Environment() {
    this.entities = new ArrayList<Entity>();
    this.weapons = new ArrayList<Weapon>();
  }

  public String toString() {
    String environmentString = "Environment has the following entities: ";
    for(int i = 0; i < this.getEntities().size(); i++) {
      if (i > 0) {
        environmentString = environmentString + ", ";
      }
      environmentString = environmentString + this.getEntity(i).getName();
    }
    return environmentString;
  }

  public ArrayList<Entity> getEntities() {
    return this.entities;
  }
  public Entity getEntity(int index) {
    return this.getEntities().get(index);
  }    
  public Entity getEntity() {
    return this.getEntities().get(0);
  }      
  public void addEntity(Entity entity) {
    this.entities.add(entity);
  }
  public void removeEntity(Entity entity) {
    this.entities.remove(entity);
  }
 // Weapon
  public ArrayList<Weapon> getWeapons() {
    return this.weapons;
  }
  public Weapon getWeapon(int index) {
    return this.getWeapons().get(index);
  }    
  public Weapon getWeapon() {
    return this.getWeapons().get(0);
  }      
  public void addWeapon(Weapon weapon) {
    this.weapons.add(weapon);
  }
  public void removeWeapon(Weapon weapon) {
    this.weapons.remove(weapon);
  }

   public void pickUpWeapon(Entity entity, Weapon weapon) {
    for (Weapon environmentWeapon: this.getWeapons()) {
      if (weapon.getDamage() == environmentWeapon.getDamage() && weapon.getResilience() == environmentWeapon.getResilience()) {
        entity.setWeapon(weapon);
      }
    }
    if (entity.getWeapon() == null) {
        System.out.println("Weapon Unavailable");
      }
    }

  public void fight(Entity attackingEntity, Entity receivingEntity) {
    boolean attackingEntityInEnvironment = false;
    boolean receivingEntityInEnvironment = false;
    for (Entity entity: this.getEntities()) {
      if (entity.isEqualTo(attackingEntity)) {
        attackingEntityInEnvironment = true;
      }
      if (entity.isEqualTo(receivingEntity)) {
        receivingEntityInEnvironment = true;
      }
    }
    if (attackingEntityInEnvironment && receivingEntityInEnvironment) {
      receivingEntity.takeDamage(attackingEntity.attack());
      attackingEntity.setEndurance(attackingEntity.getEndurance() - Math.round(300 / attackingEntity.getAthleticism()));  
    }    
  }  
  
}