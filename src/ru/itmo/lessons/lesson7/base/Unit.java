package ru.itmo.lessons.lesson7.base;

// ru.itmo.lessons.lesson7.base.Unit
// нельзя создать экземпляр (объект) abstract класса
// может содержать абстрактные методы (методы без реализации)
abstract public class Unit {
    // int healthScore; - default / package-private - доступ
    // только внутри пакета

    // protected - доступ в дочернем классе или внутри пакета
    protected int healthScore;
    private int maxHealthScore;

    public Unit(int healthScore){
        if (healthScore < 1) {
            throw new IllegalArgumentException("healthScore не может меньше 1");
        }
        this.healthScore = healthScore;
        maxHealthScore = healthScore;
    }

    public boolean isAlive(){
        // возвращает true, если здоровье больше 0 и false, если меньше или равно 0
        // if (healthScore > 0) return true;
        // return false;

        // return healthScore > 0 ? true : false;

        return healthScore > 0;
    }

    public void plusHealth(int healthScore) {
        // если юнит жив, увеличить здоровье на healthScore,
        // но не больше изначального (изначальное значение сохраняйте в
        // дополнительном свойстве maxHealthScore)
        if (!isAlive()) return;
        this.healthScore = Math.min(this.healthScore + healthScore, maxHealthScore);
    }

    public void minusHealth(int healthScore) {
        if (isAlive()) this.healthScore -= healthScore;
        /*
        if (!isAlive()) return;
        this.healthScore -= healthScore;
        */
    }

    public int getHealthScore(){
        return healthScore;
    }

    public void rest(){
        plusHealth(1);
        System.out.println("Unit восстанавливает силы");
    }
}
