package ru.itmo.lessons.lesson29.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionLesson {
    public static void main(String[] args) throws
            IllegalAccessException,
            NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            NoSuchFieldException {
        /*
        Рефлексия в Java — это механизм, с помощью которого можно вносить изменения
        и получать информацию о классах, интерфейсах, полях и методах
        во время выполнения, при этом не зная имен этих классов, методов и полей.
        Кроме того, Reflection API дает возможность создавать новые экземпляры классов,
        вызывать методы, а также получать или устанавливать значения полей.
        */

        // Все классы в языке являются объектами типа Class (даже примитивы).
        // Все свойства являются объектами типа Field
        // Все методы являются объектами типа Method
        // Все конструкторы являются объектами типа Constructor

        // получение ссылок на классы
        Class<String> stringClass = String.class; // ссылка на класс String
        System.out.println("stringClass: " + stringClass);

        Class<Integer> intClass = int.class; // ссылка на int
        System.out.println("intClass: " + intClass);

        ReflectionTextMessage textMessage = new ReflectionTextMessage("qwerty");
        textMessage.setText("Все классы в языке являются объектами");

        Class<ReflectionTextMessage> textMessageClass = ReflectionTextMessage.class;
        System.out.println("textMessageClass: " + textMessageClass);

        Class<? extends ReflectionTextMessage> textMessageClass02 = textMessage.getClass();
        System.out.println("textMessageClass02: " + textMessageClass02);

        // получение имен классов и пакетов
        System.out.println("имя пакета: " + textMessageClass.getPackageName());
        System.out.println("имя пакета + имя класса: " + textMessageClass.getName());
        System.out.println("имя класса: " + textMessageClass.getSimpleName());

        // получение ссылок на интерфейсы, которые реализует класс (но не родитель)
        Class<?>[] interfaces = textMessageClass.getInterfaces();
        System.out.println("интерфейсы класса, без учета интерфейсов родителя: "
                + Arrays.toString(interfaces));

        // получение ссылки на родительский класс
        System.out.println("родительский класс [1]: " +
                textMessageClass.getSuperclass());

        System.out.println("родительский класс [2]: " +
                textMessageClass.getSuperclass().getSuperclass()); // Object

        System.out.println("родительский класс [3]: " +
                textMessageClass.getSuperclass().getSuperclass().getSuperclass()); // null

        // получение ссылок на интерфейсы родительского класса
        System.out.println("интерфейсы родительского класса: "
                + Arrays.toString(textMessageClass.getSuperclass().getInterfaces()));


        textMessageClass = ReflectionTextMessage.class;

        // доступ к компонентам класса (свойствам, методам, конструкторам)

        // получение ссылок на поля класса

        // возвращает ссылки на все публичные поля класса (включая родительские)
        Field[] fields = textMessageClass.getFields();
        System.out.println("ссылки на public поля класса: " + Arrays.toString(fields));

        // возвращает ссылки на все поля класса
        // (включая private и protected, но не родителя)
        Field[] declaredFields = textMessageClass.getDeclaredFields();
        System.out.println("ссылки на поля класса: " + Arrays.toString(declaredFields));

        // при переборе можно узнать имя, тип, модификаторы и значение каждого поля
        for (Field field : declaredFields) {
            System.out.println("имя поля: " + field.getName());

            System.out.println("тип поля: " + field.getType());

            System.out.println("наличие модификатора final: " +
                    Modifier.isFinal(field.getModifiers()));

            System.out.println("наличие модификатора volatile: " +
                    Modifier.isVolatile(field.getModifiers()));

            field.setAccessible(true);
            System.out.println("значение поля для конкретного объекта: " +
                    field.get(textMessage)); // textMessage.code
        }

        // получение ссылок на методы
        // возвращает ссылки на все публичные методы класса (включая родительские)
        Method[] methods = textMessageClass.getMethods();
        System.out.println("ссылки на public методы класса: " + Arrays.toString(methods));

        // возвращает ссылки на все методы класса (включая private и protected, но не родителя)
        Method[] declaredMethods = textMessageClass.getDeclaredMethods();
        System.out.println("ссылки на методы класса: " + Arrays.toString(declaredMethods));

        // при переборе по каждому методу можно узнать какие у него параметры, модификатор, тип возвращаемого значения и тд
        for (Method method : methods) {
            System.out.println("---имя метода: " + method.getName());
            System.out.println("тип возвращаемого значения: " + method.getReturnType());
            System.out.println("наличие модификатора final: " + Modifier.isFinal(method.getModifiers()));
            System.out.println("наличие модификатора synchronized: " + Modifier.isSynchronized(method.getModifiers()));
            System.out.println("количество параметров: " + method.getParameterCount());
            System.out.println("типы параметров: " + Arrays.toString(method.getParameterTypes()));
            System.out.println("выбрасываемые исключения: " + Arrays.toString(method.getExceptionTypes()));
        }

        // получение ссылок на конструкторы
        Constructor<?>[] declaredConstructors = textMessageClass.getDeclaredConstructors();
        System.out.println("ссылки на конструкторы: " + Arrays.toString(declaredConstructors));

        for (Constructor<?> constructor : declaredConstructors) {
            System.out.println("количество параметров: " + constructor.getParameterCount());
            System.out.println("типы параметров: " + Arrays.toString(constructor.getParameterTypes()));
            System.out.println("выбрасываемые исключения: " + Arrays.toString(constructor.getExceptionTypes()));
        }
        // создание экземпляров с использованием рефлексии

        // в первую очередь необходимо получить ссылку на конструктор,
        // необходимо знать, последовательность аргументов
        // выбранного конструктора и их типы
        textMessageClass = ReflectionTextMessage.class;

        Constructor<ReflectionTextMessage> tmConstructor =
                textMessageClass.getDeclaredConstructor(String.class);

        // после получения ссылки на конструктор можно создавать экземпляр
        // в метод newInstance необходимо передать экземпляры, передаваемые в конструктор
        ReflectionTextMessage reflectMessage = tmConstructor.newInstance("Reflect Message");
        System.out.println("рефлексивный экземпляр: " + reflectMessage);

        // у созданного экземпляра можно вызывать методы и обращаться к свойствам через рефлексию

        // получение ссылки на поле по его имени в классе
        Field textField = textMessageClass.getDeclaredField("text");
        // установить возможность работать с private и protected полями, как с public
        textField.setAccessible(true);

        // возвращает значение поля для конкретного объекта, если позволяет модификатор доступа,
        // в противном случае - IllegalAccessException
        System.out.println("значение свойства text объекта reflectMessage: "
                + textField.get(reflectMessage));

        // устанавливает значение поля для конкретного объекта, если позволяет модификатор доступа,
        // в противном случае - IllegalAccessException
        // reflectMessage.text = "Значение поля объекта reflectMessage установлено через рефлексию";
        textField.set(reflectMessage,
                "Значение поля объекта reflectMessage установлено через рефлексию");

        // с рефлексивными объектами можно работать, как с обычными и наоборот
        System.out.println(reflectMessage.getText());

        // получение ссылки на поле по его имени в классе
        // необходимо знать, последовательность аргументов выбранного метода и их типы
        Method setTextMethod = textMessageClass.getDeclaredMethod("setText", String.class);
        // вызов метода конкретного объекта, передача необходимых аргументов
        setTextMethod.invoke(reflectMessage, "НОВЫЙ ТЕКСТ");
        System.out.println(reflectMessage.getText());

        Method printInfoMethod = textMessageClass.getDeclaredMethod("printInfo");
        printInfoMethod.setAccessible(true);
        printInfoMethod.invoke(reflectMessage);

    }
}