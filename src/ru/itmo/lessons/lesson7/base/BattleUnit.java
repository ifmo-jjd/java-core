package ru.itmo.lessons.lesson7.base;

abstract public class BattleUnit extends Unit {
    protected int attackScore;

    public BattleUnit(int healthScore, int attackScore){
        super(healthScore);
        if (attackScore < 1) {
            throw new IllegalArgumentException("attackScore дб больше 0");
        }
        this.attackScore = attackScore;
    }

    public int getAttackScore(){
        return attackScore;
    }

    // абстрактный метод - метод без реализации (без {})
    abstract public void attack(BattleUnit enemy);
}
