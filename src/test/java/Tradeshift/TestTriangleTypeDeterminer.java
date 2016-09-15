package Tradeshift;

import Tradeshift.factory.TriangleFactory;
import Tradeshift.model.EquilateralTriangle;
import Tradeshift.model.IsoscelesTriangle;
import Tradeshift.model.ScaleneTriangle;
import Tradeshift.model.Triangle;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mustafa on 15.09.16.
 */
public class TestTriangleTypeDeterminer {

    private TriangleTypeDeterminer triangleTypeDeterminer;

    private List<Double> nullList = null;
    private List<Double> illegalListSizeOne;
    private List<Double> illegalListSizeTwo;
    private List<Double> zerosList;

    private List<Double> equilateralSidesOne;
    private List<Double> equilateralSidesTwo;
    private List<Double> equilateralSidesThree;

    private List<Double> isoscelesSidesOne;
    private List<Double> isoscelesSidesTwo;
    private List<Double> isoscelesSidesThree;

    private List<Double> scaleneSidesOne;
    private List<Double> scaleneSidesTwo;
    private List<Double> scaleneSidesThree;

    @Before
    public void setUp() {

        triangleTypeDeterminer = new TriangleTypeDeterminer();

        // Registration of the Types in the Factory
        TriangleFactory.registerTriangleType(EquilateralTriangle.TRIANGLE_TYPE, EquilateralTriangle.class);
        TriangleFactory.registerTriangleType(IsoscelesTriangle.TRIANGLE_TYPE, IsoscelesTriangle.class);
        TriangleFactory.registerTriangleType(ScaleneTriangle.TRIANGLE_TYPE, ScaleneTriangle.class);

        illegalListSizeOne = new ArrayList<Double>(Arrays.asList(new Double[]{new Double(1.0), new Double(1.0)}));
        illegalListSizeTwo = new ArrayList<Double>(Arrays.asList(new Double[]{new Double(1.0), new Double(1.0), new Double(1.0), new Double(1.0)}));
        zerosList = new ArrayList<Double>(Arrays.asList(new Double[]{new Double(0.0), new Double(0.0), new Double(0.0)}));

        equilateralSidesOne = new ArrayList<Double>(Arrays.asList(new Double[]{new Double(1.0), new Double(1.0), new Double(1.0)}));
        equilateralSidesTwo = new ArrayList<Double>(Arrays.asList(new Double[]{new Double(5.5), new Double(5.5), new Double(5.5)}));
        equilateralSidesThree = new ArrayList<Double>(Arrays.asList(new Double[]{new Double(100.7), new Double(100.7), new Double(100.7)}));

        isoscelesSidesOne = new ArrayList<Double>(Arrays.asList(new Double[]{new Double(1.0), new Double(1.0), new Double(2.0)}));
        isoscelesSidesTwo = new ArrayList<Double>(Arrays.asList(new Double[]{new Double(15.3), new Double(10.0), new Double(15.3)}));
        isoscelesSidesThree = new ArrayList<Double>(Arrays.asList(new Double[]{new Double(100.0), new Double(200.8), new Double(200.8)}));

        scaleneSidesOne = new ArrayList<Double>(Arrays.asList(new Double[]{new Double(1.0), new Double(2.0), new Double(3.0)}));
        scaleneSidesTwo = new ArrayList<Double>(Arrays.asList(new Double[]{new Double(24.3), new Double(88.7), new Double(12.0)}));
        scaleneSidesThree = new ArrayList<Double>(Arrays.asList(new Double[]{new Double(100.1), new Double(27.7), new Double(38.2)}));


    }


    @Test(expected = NullPointerException.class)
    public void testDetermineTriangleTypeBySideLengthsWithNullInput() {

        triangleTypeDeterminer.determineTriangleTypeBySideLengths(null, null, null);
        triangleTypeDeterminer.determineTriangleTypeBySideLengths(nullList);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDetermineTriangleTypeBySideLengthsWithIllegalInput() {

        triangleTypeDeterminer.determineTriangleTypeBySideLengths(0.0, 0.0, 0.0);
        triangleTypeDeterminer.determineTriangleTypeBySideLengths(illegalListSizeOne);
        triangleTypeDeterminer.determineTriangleTypeBySideLengths(illegalListSizeTwo);
        triangleTypeDeterminer.determineTriangleTypeBySideLengths(zerosList);

    }

    @Test
    public void testDetermineTriangleTypeBySideLengthsWithEquilateralInput() {

        Triangle actualTriangle = triangleTypeDeterminer.determineTriangleTypeBySideLengths(equilateralSidesOne);
        Assert.assertTrue("DetermineTriangleTypeBySideLengths Method is not working correctly with Equilateral Input", actualTriangle instanceof EquilateralTriangle);
        Assert.assertTrue("DetermineTriangleTypeBySideLengths Method is not working correctly with Equilateral Input", actualTriangle instanceof IsoscelesTriangle);
        Assert.assertFalse("DetermineTriangleTypeBySideLengths Method is not working correctly with Equilateral Input", actualTriangle instanceof ScaleneTriangle);

        actualTriangle = triangleTypeDeterminer.determineTriangleTypeBySideLengths(equilateralSidesTwo);
        Assert.assertTrue("DetermineTriangleTypeBySideLengths Method is not working correctly with Equilateral Input", actualTriangle instanceof EquilateralTriangle);
        Assert.assertTrue("DetermineTriangleTypeBySideLengths Method is not working correctly with Equilateral Input", actualTriangle instanceof IsoscelesTriangle);
        Assert.assertFalse("DetermineTriangleTypeBySideLengths Method is not working correctly with Equilateral Input", actualTriangle instanceof ScaleneTriangle);

        actualTriangle = triangleTypeDeterminer.determineTriangleTypeBySideLengths(equilateralSidesThree);
        Assert.assertTrue("DetermineTriangleTypeBySideLengths Method is not working correctly with Equilateral Input", actualTriangle instanceof EquilateralTriangle);
        Assert.assertTrue("DetermineTriangleTypeBySideLengths Method is not working correctly with Equilateral Input", actualTriangle instanceof IsoscelesTriangle);
        Assert.assertFalse("DetermineTriangleTypeBySideLengths Method is not working correctly with Equilateral Input", actualTriangle instanceof ScaleneTriangle);

    }


    @Test
    public void testDetermineTriangleTypeBySideLengthsWithIsoscelesInput() {

        Triangle actualTriangle = triangleTypeDeterminer.determineTriangleTypeBySideLengths(isoscelesSidesOne);
        Assert.assertTrue("DetermineTriangleTypeBySideLengths Method is not working correctly with Isosceles Input", actualTriangle instanceof IsoscelesTriangle);
        Assert.assertFalse("DetermineTriangleTypeBySideLengths Method is not working correctly with Isosceles Input", actualTriangle instanceof EquilateralTriangle);
        Assert.assertFalse("DetermineTriangleTypeBySideLengths Method is not working correctly with Isosceles Input", actualTriangle instanceof ScaleneTriangle);

        actualTriangle = triangleTypeDeterminer.determineTriangleTypeBySideLengths(isoscelesSidesTwo);
        Assert.assertTrue("DetermineTriangleTypeBySideLengths Method is not working correctly with Isosceles Input", actualTriangle instanceof IsoscelesTriangle);
        Assert.assertFalse("DetermineTriangleTypeBySideLengths Method is not working correctly with Isosceles Input", actualTriangle instanceof EquilateralTriangle);
        Assert.assertFalse("DetermineTriangleTypeBySideLengths Method is not working correctly with Isosceles Input", actualTriangle instanceof ScaleneTriangle);

        actualTriangle = triangleTypeDeterminer.determineTriangleTypeBySideLengths(isoscelesSidesThree);
        Assert.assertTrue("DetermineTriangleTypeBySideLengths Method is not working correctly with Isosceles Input", actualTriangle instanceof IsoscelesTriangle);
        Assert.assertFalse("DetermineTriangleTypeBySideLengths Method is not working correctly with Isosceles Input", actualTriangle instanceof EquilateralTriangle);
        Assert.assertFalse("DetermineTriangleTypeBySideLengths Method is not working correctly with Isosceles Input", actualTriangle instanceof ScaleneTriangle);

    }


    @Test
    public void testDetermineTriangleTypeBySideLengthsWithScaleneInput() {

        Triangle actualTriangle = triangleTypeDeterminer.determineTriangleTypeBySideLengths(scaleneSidesOne);
        Assert.assertTrue("DetermineTriangleTypeBySideLengths Method is not working correctly with Scalene Input", actualTriangle instanceof ScaleneTriangle);
        Assert.assertFalse("DetermineTriangleTypeBySideLengths Method is not working correctly with Scalene Input", actualTriangle instanceof EquilateralTriangle);
        Assert.assertFalse("DetermineTriangleTypeBySideLengths Method is not working correctly with Scalene Input", actualTriangle instanceof IsoscelesTriangle);

        actualTriangle = triangleTypeDeterminer.determineTriangleTypeBySideLengths(scaleneSidesTwo);
        Assert.assertTrue("DetermineTriangleTypeBySideLengths Method is not working correctly with Scalene Input", actualTriangle instanceof ScaleneTriangle);
        Assert.assertFalse("DetermineTriangleTypeBySideLengths Method is not working correctly with Scalene Input", actualTriangle instanceof EquilateralTriangle);
        Assert.assertFalse("DetermineTriangleTypeBySideLengths Method is not working correctly with Scalene Input", actualTriangle instanceof IsoscelesTriangle);

        actualTriangle = triangleTypeDeterminer.determineTriangleTypeBySideLengths(scaleneSidesThree);
        Assert.assertTrue("DetermineTriangleTypeBySideLengths Method is not working correctly with Scalene Input", actualTriangle instanceof ScaleneTriangle);
        Assert.assertFalse("DetermineTriangleTypeBySideLengths Method is not working correctly with Scalene Input", actualTriangle instanceof EquilateralTriangle);
        Assert.assertFalse("DetermineTriangleTypeBySideLengths Method is not working correctly with Scalene Input", actualTriangle instanceof IsoscelesTriangle);

    }

}
