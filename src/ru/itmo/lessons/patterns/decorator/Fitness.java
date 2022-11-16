package ru.itmo.lessons.patterns.decorator;

public class Fitness {
    private ILog logger;

    public Fitness(ILog logger) {
        this.logger = logger;
    }

    public void setLogger(ILog logger) {
        this.logger = logger;
    }

    public void logInfo(){
        String string = "данные для вывода";
        logger.log(string);
    }
}