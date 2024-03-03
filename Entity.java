package com.humans.aliens;
import java.lang.Math;

public class Entity {
	
	private String name;	
	private int health = 100;
	private int endurance;
	private int athleticism;
  private int toughness;
  private Weapon weapon;
	
	public Entity(String name, int endurance, int athleticism, int toughness) {
		this.name = name;
		this.endurance = endurance;
		this.athleticism = athleticism;
    this.toughness = toughness;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHealth() {
		return this.health;
	}
	public void setHealth(int health) {
    if (health > 0) {
      this.health = health;
    } else {
      this.health = 0;
      System.out.println(this.getName() + " has been defeated");
    }
		
	}
	public int getEndurance() {
		return this.endurance;
	}
	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}	
	public int getAthleticism() {
		return this.athleticism;
	}
	public void setAthleticism(int athleticism) {
		this.athleticism = athleticism;
	}
  public int getToughness() {
    return this.toughness;
  }
  public void setToughness(int toughness) {
    this.toughness = toughness;
  }
	public Weapon getWeapon() {
		return this.weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}  

  public String toString() {
    return "Name: " + this.getName() + " Health: " + this.getHealth() + " Endurance: " + this.getEndurance() + " Athleticism: " + this.getAthleticism() + " Toughness: " + this.getToughness();
  }

  public boolean isEqualTo(Entity entity) {
    if (this.getName().equals(entity.getName())) {
      return true;
    } else {
      return false;
    }
  }
 
	
	public void strain(int time) {
		for (int i = 0; i < time; i++) {
			if (this.getEndurance() > Math.round(100 / this.getAthleticism())) {
				this.setEndurance(this.getEndurance() - Math.round(100 / this.getAthleticism()));
			} else {
				this.setEndurance(0);
        System.out.println(this.getName() + " is exhausted");
				break;
			}
		}
	}

	public void rest(int time) {
		for (int i = 0; i < time; i++) {
			if (endurance < 100) {
				this.setEndurance(this.getEndurance() + Math.round(500 / this.getAthleticism()));
			} else {
        System.out.println(this.getName() + " is fully rested");
				break;
			}
		}	
	}  

	public void takeDamage(int damageTaken) {
		this.setHealth(this.getHealth() - Math.round((100 * damageTaken) / this.getToughness()));
	}
	
	public int attack() {
		// return the value of damage inflicted	
		return this.weapon.use(this.getToughness() + Math.round(this.getAthleticism() / 10));
	}  



  public static void main(String[] args) {
    Environment battlefield = new Environment();
    Alien asgardian = new Alien("Thor");
    Human american = new Human("Bryan");
    Weapon axe = new Weapon(10, 100);
    battlefield.addWeapon(axe);
    battlefield.addEntity(asgardian);
    battlefield.addEntity(american);
    System.out.println(battlefield.toString());
    int preBattleTime = 5;
    Weapon humanWeapon = american.buildWeapon(preBattleTime);
    battlefield.addWeapon(humanWeapon);
    battlefield.pickUpWeapon(american, humanWeapon);
    asgardian.warmUp(preBattleTime);
    battlefield.pickUpWeapon(asgardian, axe);
    
    // View Current Attributes
    System.out.println(asgardian.toString());
    System.out.println(american.toString());
    System.out.println("Axe: " + axe.toString());
    System.out.println("Pitch Fork: " + humanWeapon.toString());    
    // Fight
    battlefield.fight(asgardian, american);
    battlefield.fight(american, asgardian);
    System.out.println();
    // View attributes after fight
    System.out.println(asgardian.toString());
    System.out.println(american.toString());

    asgardian.heal(10);
    american.buildArmor(5);
    american.eat();
    american.eat();
    american.eat();
    battlefield.fight(asgardian, american);
    battlefield.fight(american, asgardian);
    System.out.println(asgardian.toString());
    System.out.println(american.toString());    
    battlefield.fight(asgardian, american);
    battlefield.fight(american, asgardian); 
    System.out.println(asgardian.toString());
    System.out.println(american.toString());       
    battlefield.fight(asgardian, american);
    battlefield.fight(american, asgardian);
    System.out.println(asgardian.toString());
    System.out.println(american.toString());    
    battlefield.fight(asgardian, american);
    battlefield.fight(american, asgardian);
    System.out.println();
    System.out.println(asgardian.toString());
    System.out.println(american.toString());
    System.out.println("Axe: " + axe.toString());
    System.out.println("Pitch Fork: " + humanWeapon.toString());
  }
	
	
}