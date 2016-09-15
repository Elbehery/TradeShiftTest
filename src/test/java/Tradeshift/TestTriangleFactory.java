package Tradeshift;

import Tradeshift.factory.TriangleFactory;
import Tradeshift.model.EquilateralTriangle;
import Tradeshift.model.IsoscelesTriangle;
import Tradeshift.model.ScaleneTriangle;
import Tradeshift.model.Triangle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by mustafa on 15.09.16.
 */
public class TestTriangleFactory {

    private List<Double> equilateralSides;
    private List<Double> isoscelesSides;
    private List<Double> scaleneSides;


    @Before
    public void setUp() {

        // Registration of the Types in the Factory. It should be done here, because it is required for testing all the methods in this class. So, it is preferable to be done once only BEFORE all the test.
        TriangleFactory.registerTriangleType(EquilateralTriangle.TRIANGLE_TYPE, EquilateralTriangle.class);
        TriangleFactory.registerTriangleType(IsoscelesTriangle.TRIANGLE_TYPE, IsoscelesTriangle.class);
        TriangleFactory.registerTriangleType(ScaleneTriangle.TRIANGLE_TYPE, ScaleneTriangle.class);

        equilateralSides = new ArrayList<Double>(Arrays.asList(new Double[]{new Double(1.0), new Double(1.0), new Double(1.0)}));
        isoscelesSides = new ArrayList<Double>(Arrays.asList(new Double[]{new Double(100.0), new Double(200.8), new Double(200.8)}));
        scaleneSides = new ArrayList<Double>(Arrays.asList(new Double[]{new Double(24.3), new Double(88.7), new Double(12.0)}));

    }

    @Test
    public void testRegisterTriangleType() {

        // Retrieving the Map is required only for this test method, therefore it is recommended to be here, not in  the setUp() method, to be executed only for this test case.
        Map<String, Class<? extends Triangle>> testTriangleTypesMap = null;
        Field privateTriangleTypesMap = null;
        try {
            privateTriangleTypesMap = TriangleFactory.class.getDeclaredField("triangleTypesMap");
            privateTriangleTypesMap.setAccessible(true);
            testTriangleTypesMap = (Map<String, Class<? extends Triangle>>) privateTriangleTypesMap.get(TriangleFactory.class);

        } catch (NoSuchFieldException e) {
            System.err.println("Triangle Factory does not contains a Map " + e);
        } catch (IllegalAccessException e) {
            System.err.println("Can not create instance of Triangle Factory " + e);
        }

        Assert.assertTrue("RegisterTriangleType Method is not working properly", testTriangleTypesMap.containsKey(EquilateralTriangle.TRIANGLE_TYPE.toLowerCase()));
        Assert.assertTrue("RegisterTriangleType Method is not working properly", testTriangleTypesMap.get(EquilateralTriangle.TRIANGLE_TYPE.toLowerCase()).equals(EquilateralTriangle.class));

        Assert.assertTrue("RegisterTriangleType Method is not working properly", testTriangleTypesMap.containsKey(IsoscelesTriangle.TRIANGLE_TYPE.toLowerCase()));
        Assert.assertTrue("RegisterTriangleType Method is not working properly", testTriangleTypesMap.get(IsoscelesTriangle.TRIANGLE_TYPE.toLowerCase()).equals(IsoscelesTriangle.class));

        Assert.assertTrue("RegisterTriangleType Method is not working properly", testTriangleTypesMap.containsKey(ScaleneTriangle.TRIANGLE_TYPE.toLowerCase()));
        Assert.assertTrue("RegisterTriangleType Method is not working properly", testTriangleTypesMap.get(ScaleneTriangle.TRIANGLE_TYPE.toLowerCase()).equals(ScaleneTriangle.class));

        Assert.assertTrue("RegisterTriangleType Method is not working properly", testTriangleTypesMap.size() == 3);

    }

    @Test
    public void testCreateTriangle() {

        Triangle actualTriangle = TriangleFactory.createTriangle(EquilateralTriangle.TRIANGLE_TYPE, equilateralSides);
        Assert.assertTrue("CreateTriangle Method is not working properly", actualTriangle.getClass().equals(EquilateralTriangle.class));
        Assert.assertFalse("CreateTriangle Method is not working properly", actualTriangle.getClass().equals(IsoscelesTriangle.class));
        Assert.assertFalse("CreateTriangle Method is not working properly", actualTriangle.getClass().equals(ScaleneTriangle.class));

        actualTriangle = TriangleFactory.createTriangle(IsoscelesTriangle.TRIANGLE_TYPE, isoscelesSides);
        Assert.assertTrue("CreateTriangle Method is not working properly", actualTriangle.getClass().equals(IsoscelesTriangle.class));
        Assert.assertFalse("CreateTriangle Method is not working properly", actualTriangle.getClass().equals(EquilateralTriangle.class));
        Assert.assertFalse("CreateTriangle Method is not working properly", actualTriangle.getClass().equals(ScaleneTriangle.class));

        actualTriangle = TriangleFactory.createTriangle(ScaleneTriangle.TRIANGLE_TYPE, scaleneSides);
        Assert.assertTrue("CreateTriangle Method is not working properly", actualTriangle.getClass().equals(ScaleneTriangle.class));
        Assert.assertFalse("CreateTriangle Method is not working properly", actualTriangle.getClass().equals(IsoscelesTriangle.class));
        Assert.assertFalse("CreateTriangle Method is not working properly", actualTriangle.getClass().equals(EquilateralTriangle.class));

    }


}
