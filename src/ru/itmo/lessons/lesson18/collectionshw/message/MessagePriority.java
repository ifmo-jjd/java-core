package ru.itmo.lessons.lesson18.collectionshw.message;

enum MessagePriority {
    LOW, MEDIUM, HIGH, URGENT;

    public static MessagePriority getPriority(int ord){
        for (MessagePriority mp: values()){
            if (ord == mp.ordinal()) {
                return mp;
            }
        }
        throw new AssertionError("Wrong ordinal: " + ord);
    }
}