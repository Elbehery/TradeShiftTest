package Tradeshift.factory;

import Tradeshift.model.Triangle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mustafa on 14.09.16.
 */
public class TriangleFactory {

    // A hash map to register Triangle type. This avoids coupling the factory code to the different triangle types.
    // Adding more triangle types does not requires any change in the factory, results into decoupled, maintainable code.
    // The creation of each triangle type is dynamically using Reflection.
    private static Map<String, Class<? extends Triangle>> triangleTypesMap = new HashMap<String, Class<? extends Triangle>>();

    public static Triangle createTriangle(String type, List<Double> sides) {

        Class<? extends Triangle> triangleClass = null;
        Constructor<? extends Triangle> triangleConstructor = null;
        Triangle triangleObject = null;

        try {

            triangleClass = triangleTypesMap.get(type.toLowerCase());
            triangleConstructor = triangleClass.getConstructor(new Class[]{List.class});
            triangleObject = triangleConstructor.newInstance(sides);

        } catch (NullPointerException e) {

            System.err.println("Triangle type " + type.toUpperCase() + " is not registered. " + e);

        } catch (NoSuchMethodException e) {

            System.err.println("No Constructor with these arguments for " + triangleClass.getSimpleName() + ": " + e);

        } catch (IllegalAccessException e) {

            System.err.println("Illegal access for invoking constructor of " + triangleClass.getSimpleName() + ": " + e);

        } catch (InvocationTargetException e) {

            System.err.println("InvocationTargetException encountered invoking constructor of " + triangleClass.getSimpleName() + ": " + e);

        } catch (InstantiationException e) {
            System.err.println("Unable to instantiate " + triangleClass.getSimpleName() + ": " + e);
        }

        return triangleObject;
    }

    public static void registerTriangleType(String type, Class<? extends Triangle> triangleClass) {

        triangleTypesMap.put(type.toLowerCase(), triangleClass);
    }

}
