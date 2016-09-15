package Tradeshift.model;

import Tradeshift.factory.TriangleFactory;

import java.util.List;

/**
 * Created by mustafa on 14.09.16.
 */
public class IsoscelesTriangle extends Triangle {

    public final static String TRIANGLE_TYPE = "Isosceles";

    static {
        TriangleFactory.registerTriangleType(IsoscelesTriangle.TRIANGLE_TYPE, IsoscelesTriangle.class);
    }

    public IsoscelesTriangle(List<Double> sides) {
        super(sides);
    }

    @Override
    public String toString() {
        return "I am an " + TRIANGLE_TYPE + " Triangle ";
    }
}
