package com.humans.aliens;
import java.lang.Math;

public class Alien extends Entity {

  private static int endurance = 100;
  private static int athleticism = 100;
  private static int toughness = 100;

  public Alien(String name) {
    super(name, endurance, athleticism, toughness);
  }  

  public void heal(int time) {
    for (int i = 0; i < time; i++) {
      if (this.getHealth() < 100) {
        this.setHealth(this.getHealth() + Math.round(this.getAthleticism()) / 100);
      }
    }
    System.out.println(this.getName() + " healed!");
  }

  public void warmUp(int time) {
    for (int i = 0; i < time; i++) {
      this.setEndurance(this.getEndurance() - Math.round(200 / this.getAthleticism()));
      this.setAthleticism(this.getAthleticism() + Math.round(100 / this.getToughness()));
    }
    System.out.println(this.getName() + " is warmed up!");
  }

}