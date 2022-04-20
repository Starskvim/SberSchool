package Task5;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanUtils {
    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */

    private static boolean isMethodSetter(Method method) {
        return method.getName().startsWith("set") && method.getParameterTypes().length == 1;
    }

    private static boolean isMethodGetter(Method method) {
        return method.getName().startsWith("get") && method.getParameterTypes().length == 0 && !void.class.equals(method.getReturnType());
    }

    public static void assign(Object to, Object from) {
        Map<String, Method> getters = new HashMap<>();
        Map<String, Method> setters = new HashMap<>();

        for (Method m : to.getClass().getMethods())
            if (isMethodSetter(m))
                setters.put(m.getName(), m);

        for (Method m : from.getClass().getMethods())
            if (isMethodGetter(m))
                getters.put(m.getName(), m);

        for (String getName : getters.keySet()) {
            String setName = "set" + getName.substring(3);
            Method setterMethod = setters.get(setName);
            Method getterMethod = getters.get(getName);
            try {
                if (setterMethod != null)
                    if (setterMethod.getParameterTypes()[0].isAssignableFrom(getterMethod.getReturnType()))
                        setterMethod.invoke(to, getterMethod.invoke(from));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
