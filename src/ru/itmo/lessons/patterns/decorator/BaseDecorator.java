package ru.itmo.lessons.patterns.decorator;

// родительский класс для всех классов-декораторов
// декораторы должны ссылаться на общий тип,
// ссылка должна устанавливаться через конструктор
public abstract class BaseDecorator implements ILog {
    private ILog logger;

    public BaseDecorator(ILog logger) {
        this.logger = logger;
    }

    @Override
    public void log(String data) {
        logger.log(data);
    }
}