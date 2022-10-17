package ru.itmo.lessons.lesson12;
// можно создать собственные типы исключений
// если мы хотим создать исключение времени выполнения, то класс должен
// наследоваться от RuntimeException

// если мы хотим создать исключение времени компиляции, то класс должен
// наследоваться от Exception

public class CalculatorException extends Exception {
    // можно добавлять собственные свойства, методы и конструкторы
    // можно вызвать конструкторы родителя
    public CalculatorException(String message) {
        super(message);
    }

    public CalculatorException(String message, Throwable cause) {
        super(message, cause);
    }

    // можно переопределять методы
    @Override
    public String getMessage(){
        return super.getMessage() + ". Будьте внимательны";
    }
}
