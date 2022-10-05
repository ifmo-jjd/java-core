package ru.itmo.lessons.lesson7.base;

// ru.itmo.lessons.lesson7.base.Unit
public class Unit {
    // int healthScore; - default / package-private - доступ
    // только внутри пакета

    // protected - доступ в дочернем классе или внутри пакета
    protected int healthScore;

    public Unit(int healthScore){
        if (healthScore < 1) {
            throw new IllegalArgumentException("healthScore не может меньше 1");
        }
        this.healthScore = healthScore;
    }

    public boolean isAlive(){
        // возвращает true, если здоровье больше 0 и false, если меньше или равно 0
        // if (healthScore > 0) return true;
        // return false;

        // return healthScore > 0 ? true : false;

        return healthScore > 0;
    }

    public void plusHealth(int healthScore) {
        // если юнит жив, увеличить здоровье на healthScore
    }

    public void minusHealth(int healthScore) {
        // если юнит жив, уменьшить здоровье на healthScore
    }




}
