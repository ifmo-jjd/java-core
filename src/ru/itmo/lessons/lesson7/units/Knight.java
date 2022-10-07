package ru.itmo.lessons.lesson7.units;

import ru.itmo.lessons.lesson7.base.BattleUnit;

public final class Knight extends BattleUnit {
    private int additionalHealth;

    public Knight(int healthScore, int attackScore,
                  int additionalHealth){
        super(healthScore, attackScore);
        if (additionalHealth < 1) {
            throw new IllegalArgumentException("additionalHealth не мб меньше 1");
        }
        this.additionalHealth = additionalHealth;
    }

    @Override
    public void attack(BattleUnit enemy) {
        System.out.println("Knight атакует");
        enemy.minusHealth(this.attackScore);
        if (!enemy.isAlive()) this.plusHealth(this.additionalHealth);
    }
}
