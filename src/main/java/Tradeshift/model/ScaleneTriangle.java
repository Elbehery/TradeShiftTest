package Tradeshift.model;

import Tradeshift.factory.TriangleFactory;

import java.util.List;

/**
 * Created by mustafa on 14.09.16.
 */
public class ScaleneTriangle extends Triangle {

    public final static String TRIANGLE_TYPE = "Scalene";

    static {
        TriangleFactory.registerTriangleType(ScaleneTriangle.TRIANGLE_TYPE, ScaleneTriangle.class);
    }

    public ScaleneTriangle(List<Double> sides) {
        super(sides);
    }

    @Override
    public String toString() {
        return "I am a " + TRIANGLE_TYPE + " Triangle";
    }
}
