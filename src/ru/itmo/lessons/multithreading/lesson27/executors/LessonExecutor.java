package ru.itmo.lessons.multithreading.lesson27.executors;

import java.util.concurrent.*;

public class LessonExecutor extends ThreadPoolExecutor {
    // очередь для задач мб свойством со значением по умолчанию
    public LessonExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue
    ) {

        super(corePoolSize, // изначальное (минимальное) количество потоков
                maximumPoolSize, // максимальное количество потоков
                keepAliveTime, // как долго избыточные потоки будут простаивать перед удалением
                unit, // ед. измерения (относятся к пункту keepAliveTime)
                workQueue // очередь для задач
        );
    }

    // можно переопределить любые доступные (согласно модификаторам) методы родителя
    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        System.out.println("BEFORE");
    }
}