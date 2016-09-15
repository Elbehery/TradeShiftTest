package Tradeshift.model;

import Tradeshift.factory.TriangleFactory;

import java.util.List;

/**
 * Created by mustafa on 14.09.16.
 */
public class EquilateralTriangle extends IsoscelesTriangle {

    public final static String TRIANGLE_TYPE = "Equilateral";

    static {
        TriangleFactory.registerTriangleType(EquilateralTriangle.TRIANGLE_TYPE, EquilateralTriangle.class);
    }

    public EquilateralTriangle(List<Double> sides) {
        super(sides);
    }

    @Override
    public String toString() {

        return "I am an " + TRIANGLE_TYPE + " Triangle ";
    }
}
