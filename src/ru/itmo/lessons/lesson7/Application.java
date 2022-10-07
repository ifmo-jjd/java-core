package ru.itmo.lessons.lesson7;

import ru.itmo.lessons.lesson7.base.BattleUnit;
import ru.itmo.lessons.lesson7.units.Infantry;
import ru.itmo.lessons.lesson7.units.King;
import ru.itmo.lessons.lesson7.units.Knight;

// ru.itmo.lessons.lesson7.Application
public class Application {
    public static void main(String[] args) {
        King king01 = new King(2000);
        king01.rest();

        King king02 = new King(2000);
        king02.rest(king01);

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
