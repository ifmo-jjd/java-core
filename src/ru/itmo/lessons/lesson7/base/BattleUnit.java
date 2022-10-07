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

    // фабричный метод
    public static BattleUnit getBattleUnit(){
        String[] types = {"knight", "infantry"};
        // TODO: дописать реализацию метода
        // тип создаваемого юнита определяем через Math.random
        // в зависимости от типа создаем объект того или иного юнита
    }

    public static BattleUnit[] getBattleUnits(int count){
        BattleUnit[] units = new BattleUnit[count];
        for (int i = 0; i < units.length; i++) {
            // в статических методах можно обратиться ТОЛЬКО
            // к статическим свойствам или вызвать статические методы
            // класса
            units[i] = getBattleUnit();
        }
        return units;
    }
}

