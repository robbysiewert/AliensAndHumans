package com.humans.aliens;
import java.lang.Math;

public class Weapon {

  private int damage;
  private int resilience;

  public Weapon(int damage, int resilience) {
    this.damage = damage;
    this.resilience = resilience;
  }

  public int getDamage() {
    return this.damage;
  }
  public void setDamage(int damage) {
    this.damage = damage;
  }
  public int getResilience() {
    return this.resilience;
  }
  public void setResilience(int resilience) {
    this.resilience = resilience;
  }

  public String toString() {
    return "Damage: " + this.getDamage() + " Resilience: " + this.getResilience();
  }
  
  public int use(int toughness) {
    this.setResilience(this.getResilience() - Math.round(500/toughness));
    return this.getDamage();
    }

  }