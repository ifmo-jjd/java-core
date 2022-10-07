package ru.itmo.lessons.lesson7.units;

import ru.itmo.lessons.lesson7.base.AppSettings;
import ru.itmo.lessons.lesson7.base.BattleUnit;
import ru.itmo.lessons.lesson7.base.Unit;

import java.util.concurrent.SynchronousQueue;

// класс King наследуется от класса Unit (или расширяет класс Unit)
// класс King - дочерний класс
// класс Unit - родительский класс (или суперкласс)
// множественное наследование классов запрещено
public class King extends Unit  {
    private int gold = AppSettings.GOLD;

    private BattleUnit[] army;

    // конструкторы не наследуются
    public King(int healthScore){
        super(healthScore); // вызов констркуктора родителя
    }

    public int getGold(){
        return gold;
    }

    // создание армии
    public void generateArmy(){
        if (gold < AppSettings.ARMY_PRICE) {
            System.out.println("Стоимость армии " + AppSettings.ARMY_PRICE);
            return;
        }
        gold -= AppSettings.ARMY_PRICE;
        army = BattleUnit.getBattleUnits(AppSettings.UNITS_COUNT);
    }

    public void updateArmy(){
        for (int i = 0; i < army.length; i++) {
            if (gold < AppSettings.UNIT_PRICE) {
                System.out.println("Стоимость юнита " + AppSettings.UNIT_PRICE);
                return;
            }
            if (!army[i].isAlive()) {
                gold -= AppSettings.UNIT_PRICE;
                army[i] = BattleUnit.getBattleUnit();
            }
        }
    }


    public void startBattle(King enemy){
        // TODO:: написать реализацию метода
        // юниты армии нападающего короля (this) должны атаковать юнитов армии противника (enemy)
        // последовательность атаки юнитов, отдыха юнитов, бонусы королю и т.д. на Ваше усмотрение!
    }

    // переопределение метода родителя или интерфейса
    @Override // необязательная аннотация времени компиляции
    public void rest(){
        // можно новый функционал
        if (gold < AppSettings.REST_PRICE) return;
        gold -= AppSettings.REST_PRICE;

        // можно вызвать метод родителя
        super.rest(); // выполнятся все инструкции метода rest класса Unit
        // метод родителя вызывается по желанию разработчика

        System.out.println("King восстанавливает силы");
    }
    // метод rest перегружен
    // одинаковые названия, но разное количество аргументов или их типов
    // final метод нельзя переопределить в дочерних класса
    public final void rest(Unit unit){ // new Unit / new King
        if (gold < 20) return;
        gold -= 20;
        plusHealth(2);
        unit.plusHealth(1);
        System.out.println("King и Unit восстанавливают силы");
    }
}
