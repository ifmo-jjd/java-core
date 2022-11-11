package ru.itmo.lessons.lesson22.anonymous;

public class Anonymous {
    public static void main(String[] args) {
        Button clear = new Button("Reset");

        int a = 90;
        clear.setAction(new Clickable() {
            @Override
            public void click() {
                int a = 10; // затеняют свойства внешнего класса и локальные переменные
                System.out.println(a);
                // инструкции, связанные с очисткой поля ввода пароля
            }

            @Override
            public void dbClick() {
                clear.setColor("yellow");
                System.out.println("Clear the password field");
            }
        });

        clear.getAction().click();
        clear.getAction().dbClick();

        Button send = new Button("Send data");
        Clickable sendAction = new Clickable() {
            @Override
            public void click() {
                // инструкции, связанные с отправкой данных
            }

            @Override
            public void dbClick() {
                send.setColor("green");
                System.out.println("Send your data");
            }
        };
        send.setAction(sendAction);

        send.getAction().click();
        send.getAction().dbClick();

    }
}