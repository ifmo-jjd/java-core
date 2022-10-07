package ru.itmo.lessons.lesson7.units;

import ru.itmo.lessons.lesson7.base.BattleUnit;

public class Infantry extends BattleUnit {
    private int additionalAttack;

    public Infantry(int healthScore, int attackScore,
                    int additionalAttack){
        super(healthScore, attackScore);
        if (additionalAttack < 1) {
            throw new IllegalArgumentException("additionalAttack не мб меньше 1");
        }
        this.additionalAttack = additionalAttack;
    }

    public void upAdditionalAttack(){
        additionalAttack += (int) (Math.random() * 3);
    }

    @Override
    public void attack(BattleUnit enemy){
        System.out.println("Infantry атакует");
        enemy.minusHealth(this.attackScore);
        if (Math.random() < 0.5) enemy.minusHealth(this.additionalAttack);
    }

}

// Infantry inf01 = new Infantry(45, 78, 12);
// Infantry inf02 = new Infantry(15, 100, 12);

// inf01.rest();
// inf01.attack(inf02);
