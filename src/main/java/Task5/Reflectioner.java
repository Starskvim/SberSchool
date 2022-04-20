package Task5;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Reflectioner {

    public static void printClassAndSuperMethods(Class<?> myclass) {
        Class<?> superClass = myclass.getSuperclass();
        if(superClass != null)
            printClassAndSuperMethods(superClass);

        System.out.println("");
        System.out.println("Class:" + myclass.getName());

        Class<?>[] interfaces =  myclass.getInterfaces();
        for (Class<?> interfaze : interfaces)
            System.out.println("Interface: " + interfaze.getName());

        Method[] methods = myclass.getDeclaredMethods();
        for (Method method : methods)
            System.out.println("Method: " + method.getName());
    }

    public static void printGetters(Class<?> myclass) {
        System.out.println("Class " + myclass.getName());
        Method[] methods = myclass.getDeclaredMethods();
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if(method.getName().contains("get") && Modifier.isPublic(modifiers)) {
                System.out.println("Getter: " + method.getName());
            }
        }
    }

    public static void weekDaysChecker(){
        WeekDays week = new WeekDays();
        Field[] fields = WeekDays.class.getFields();
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            if(field.getType().equals(String.class) && Modifier.isFinal(modifiers)) {
                try {
                    if(field.getName().compareTo((String) field.get(week)) != 0)
                        System.out.println("Неверное значение поля: " + field.getName() + " значение - " + field.get(week));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
