package com.humans.aliens;

public class Human extends Entity {

  private static int endurance = 50;
  private static int athleticism = 50;
  private static int toughness = 50;

  public Human(String name) {
    super(name, endurance, athleticism, toughness);
  }

  public void buildArmor(int time) {
    for (int i = 0; i < time; i++) {
      this.setToughness(this.getToughness() + Math.round(this.getEndurance() / 10));
    }
    this.strain(time);
  }

  public Weapon buildWeapon(int time) {
    int damage = 0;
    int resilience = 0;
    for (int i = 0; i < time; i++) {
      damage += 5;
      resilience += 20;
    }
    this.strain(time);
    Weapon humanBuiltWeapon = new Weapon(damage, resilience);
    System.out.println(this.getName() + " built a weapon!");
    return humanBuiltWeapon;    
  }

  public void eat() {
    if (this.getEndurance() < 100) {
      this.setEndurance(this.getEndurance() + 10);
    }
  }



}