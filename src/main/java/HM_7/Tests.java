package HM_7;

import HM_5.Race;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;


public class Tests {

    public static void start (Class a) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = a.getDeclaredMethods();
        List<Method> methodsTest = new ArrayList<>();
        Method before = null;
        Method after = null;
        for (Method method : methods) {
            if (method.isAnnotationPresent(Test.class)) {
                int prior = method.getAnnotation(Test.class).priority();
                if (prior < 1 || prior > 10) throw new RuntimeException("Priority Exception");
                methodsTest.add(method);
            }
            else if (method.isAnnotationPresent(BeforeSuite.class)){
                if (before != null) throw new RuntimeException ("BeforeSuite Exception");
                    before = method;
            }
            else  if (method.isAnnotationPresent(AfterSuite.class)){
                if (after != null) throw new RuntimeException ("AfterSuite Exception");
              after = method;

            }
        }
        methodsTest.sort((o1, o2) -> o2.getAnnotation(Test.class).priority() - o1.getAnnotation(Test.class).priority());
        if (before != null ) methodsTest.add(0,before);
        if (after != null ) methodsTest.add(after);
        for (Method method:methodsTest) {
            if (Modifier.isStatic(method.getModifiers())) {
                method.invoke(null);
            }
            else {
                method.invoke(a);
            }
        }
    }
}

