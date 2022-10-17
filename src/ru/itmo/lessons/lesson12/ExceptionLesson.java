package ru.itmo.lessons.lesson12;

public class ExceptionLesson {
    public static void main(String[] args) {
        // Error - ошибки связаны с проблемами уровня JVM (например, нехватка памяти).
        // Ошибки нет смысла обрабатывать.
        // Exception:
        // 1. Исключения времени выполнения (наследники RuntimeException):
        // unchecked, необрабатываемые, неотслеживаемые, неконтролируемые.
        // Разработчики могут (по своему усмотрению) обработать данный тип исключений.

        // 2. Исключения времени компиляции (все остальные наследники Exception):
        // checked, обрабатываемые, отслеживаемые, контролируемые.
        // Разработчики обязаны обработать данный тип исключений.

        // RuntimeException
        int a = 1;
        int b = 0;
        int res;
        // res = a / b; java.lang.ArithmeticException

        int[] ints = new int[3];
        // ints[30] = 100; java.lang.ArrayIndexOutOfBoundsException

        String string = null;
        // string.equals("null"); java.lang.NullPointerException

        Object object = "123";
        String stringObject = (String) object;
        System.out.println(stringObject.toUpperCase());
        // Integer integer = (Integer) object; // java.lang.ClassCastException

        // обработка исключений (unchecked / checked)

        try { // в блок try помещается потенциально опасный код,
            // который может привести к исключению
            res = a / b; // java.lang.ArithmeticException
        } catch (ArithmeticException exception){ // перехватывает исключение
            // только указанного в нем типа (в данном случае ArithmeticException)
            System.out.println(exception.getMessage());
            res = a;
        }
        System.out.println(res);

        // Объединение блоков catch (перехват нескольких исключений)
        // 1. несколько блоков catch (если разные исключения нужно обработать разными способами)
        Integer integer = null;
        try {
            if (System.currentTimeMillis() % 2 == 0) integer = (Integer) object;
            else ints[30] = 100;
        } catch (ClassCastException exception) {
            System.out.println("Проблемы с приведением типов " + exception.getMessage());
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Выход за пределы массива " + exception.getMessage());
        }

        // 2. несколько исключений обрабатываются одинаковым способом
        try {
            if (System.currentTimeMillis() % 2 == 0) integer = (Integer) object;
            else ints[30] = 100;
        } catch (ClassCastException | ArrayIndexOutOfBoundsException exception){
            System.out.println("Проблемы с приведением типов или выход за пределы массива "
                    + exception.getMessage());
        }

        // 3. через общего родителя
        try {
            if (System.currentTimeMillis() % 2 == 0) integer = (Integer) object;
            else ints[30] = 100;
        } catch (RuntimeException exception) {
            System.out.println("Проблема времени выполнения " + exception.getMessage());
        }

        // 4. через общего родителя + несколько исключений обрабатываются
        // одним способом, остальные другим
        try {
            if (System.currentTimeMillis() % 2 == 0) integer = (Integer) object;
            else ints[30] = 100;
        } catch (ClassCastException exception){
            System.out.println("Проблемы с приведением типов " + exception.getMessage());
        } catch (RuntimeException exception) {
            System.out.println("Проблема времени выполнения " + exception.getMessage());
        }

        // Необязательный блок finally
        try {
            if (System.currentTimeMillis() % 2 == 0) integer = (Integer) object;
            else ints[30] = 100;
        } catch (ClassCastException | ArrayIndexOutOfBoundsException exception) {
            System.out.println("Проблемы с приведением типов или выход за пределы массива "
                    + exception.getMessage());
        } finally {
            // код выполнится в любом случае, в случае любого исключения блока try или его отсутствия
            // используется для инструкций связанных с закрытием ресурсов,
            // в большинстве ситуаций может быть заменен конструкцией try with resources
            // try(открытие ресурсов) {}
            System.out.println("Finally");
        }

    }
}
