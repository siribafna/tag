package org.improving.tag;

public class Adversary {

    private String name;
    private int hitPoints = 100;
    private int damageTaken = 0;
    private int attackDamage;
    private Location location;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public int getHitPoints() { return hitPoints; }

    public void setHitPoints(int hitPoints) { this.hitPoints = hitPoints; }

    public int getDamageTaken() { return damageTaken; }

    public void setDamageTaken(int damagePoints) { this.damageTaken = this.damageTaken + damagePoints; }

    public int getAttackDamage() { return attackDamage; }

    public void setAttackDamage(int attackDamage) { this.attackDamage = attackDamage; }
}
