package ru.itmo.lessons.lesson29.reflection;

public class ReflectionTextMessage extends ReflectionMessage{

    private String text;
    public final String code = "ТЕКСТОВОЕ СООБЩЕНИЕ";


    public ReflectionTextMessage(String sender) {
        super(sender);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private void printInfo(){
        System.out.println("Экземпляр типа TextMessage. Свойства и значения: sender(" + getSender() + "), " +
                "text(" + text + "), " +
                "code(" + code + ") ");
    }

    @Override
    public String toString() {
        return "TextMessage{" +
                "text='" + text + '\'' +
                "} " + super.toString();
    }
}