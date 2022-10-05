package ru.itmo.lessons.lesson7.units;

import ru.itmo.lessons.lesson7.base.Unit;

import java.util.concurrent.SynchronousQueue;

// класс King наследуется от класса Unit (или расширяет класс Unit)
// класс King - дочерний класс
// класс Unit - родительский класс (или суперкласс)
// множественное наследование классов запрещено
public class King extends Unit  {
    private int gold = 500;

    // конструкторы не наследуются
    public King(int healthScore){
        super(healthScore); // вызов констркуктора родителя
    }

    public int getGold(){
        return gold;
    }

    // переопределение метода родителя или интерфейса
    @Override // необязательная аннотация времени компиляции
    public void rest(){
        // можно новый функционал
        if (gold < 10) return;
        gold -= 10;

        // можно вызвать метод родителя
        super.rest(); // выполнятся все инструкции метода rest класса Unit
        // метод родителя вызывается по желанию разработчика

        System.out.println("King восстанавливает силы");
    }
    // метод rest перегружен
    // одинаковые названия, но разное количество аргументов или их типов
    public void rest(Unit unit){ // new Unit / new King
        if (gold < 20) return;
        gold -= 20;
        plusHealth(2);
        unit.plusHealth(1);
        System.out.println("King и Unit восстанавливают силы");
    }
}
