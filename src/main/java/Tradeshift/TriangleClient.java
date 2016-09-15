package Tradeshift;

import Tradeshift.factory.TriangleFactory;
import Tradeshift.model.*;


/**
 * Created by mustafa on 15.09.16.
 */
public class TriangleClient {

    public static void main(String[] args) {

        // Ideally, the registration of each triangle type should be done during bootstrap, using the the Static block in each Type.
        TriangleFactory.registerTriangleType(EquilateralTriangle.TRIANGLE_TYPE, EquilateralTriangle.class);
        TriangleFactory.registerTriangleType(IsoscelesTriangle.TRIANGLE_TYPE, IsoscelesTriangle.class);
        TriangleFactory.registerTriangleType(ScaleneTriangle.TRIANGLE_TYPE, ScaleneTriangle.class);

        TriangleTypeDeterminer triangleTypeDeterminer = new TriangleTypeDeterminer();
        System.out.println(triangleTypeDeterminer.determineTriangleTypeBySideLengths(2.0, 2.0, 2.0));

    }
}
