package ru.itmo.lessons.lesson7;

import ru.itmo.lessons.lesson7.base.BattleUnit;
import ru.itmo.lessons.lesson7.units.Infantry;
import ru.itmo.lessons.lesson7.units.King;
import ru.itmo.lessons.lesson7.units.Knight;

import java.util.Scanner;

// ru.itmo.lessons.lesson7.Application
public class Application {
    // 1. final класс - запрет наследования
    // 2. final метод - запрет переопределения метода
    // 3. final свойства - запрет изменения значений,
    // значение final свойству нужно присвоить либо при объявлении,
    // либо в конструкторе (сеттеры запрещены)
    // 4. final аргумент метода доступен только для чтения

    public void finalArgs(final int a, final Infantry infantry){
        System.out.println(a);
        int b = a * a;
        // a = 90; ошибка, тк аргумент final

        System.out.println(infantry);
        System.out.println(infantry.getHealthScore());
        // infantry = new Infantry(12, 22, 1); ошибка, тк аргумент final
        // НО можно изменять значения свойст объекта
        infantry.plusHealth(100);
    }

    public static void main(String[] args) {

        King king01 = new King(2000);
        king01.rest();

        King king02 = new King(2000);
        king02.rest(king01);

        king01.startBattle(king02);

        System.out.println(king01.getHealthScore());

        Infantry infantry01 = new Infantry(30, 10, 5);
        infantry01.upAdditionalAttack();
        infantry01.rest();
        System.out.println(infantry01.getAttackScore());
        System.out.println(infantry01.getHealthScore());

        Knight knight01 = new Knight(30, 10, 5);
        infantry01.attack(knight01);

        // public void attack(BattleUnit enemy){
        // }

        BattleUnit battleUnit01 = new Infantry(30, 10, 5);
        BattleUnit battleUnit02 = new Knight(30, 10, 5);

        // полиморфизм наследования
        BattleUnit[] battleUnits = {infantry01, battleUnit01, battleUnit02};
        for (BattleUnit battleUnit : battleUnits) {
            battleUnit.rest();
            battleUnit.attack(knight01);
        }

    }
}


