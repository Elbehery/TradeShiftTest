package Tradeshift;

import Tradeshift.factory.TriangleFactory;
import Tradeshift.model.Triangle;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by mustafa on 15.09.16.
 */
public class TriangleTypeDeterminer {

    private HashSet<Double> triangleSidesSet;

    public TriangleTypeDeterminer() {
        this.triangleSidesSet = new HashSet<Double>();
    }

    public Triangle determineTriangleTypeBySideLengths(Double sideOne, Double sideTwo, Double sideThree) {

        if (sideOne == null || sideTwo == null || sideThree == null)
            throw new NullPointerException("Triangle side length can not be null");

        if (sideOne.equals(0.0) || sideTwo.equals(0.0) || sideThree.equals(0.0))
            throw new IllegalArgumentException("Triangle side length can not equal to zero");

        // create a list of the side lengths, to avoid redundant code and utilize the overloaded method.
        List<Double> triangleSidesList = new ArrayList<Double>(3);
        triangleSidesList.add(sideOne);
        triangleSidesList.add(sideTwo);
        triangleSidesList.add(sideThree);

        return determineTriangleTypeBySideLengths(triangleSidesList);
    }


    public Triangle determineTriangleTypeBySideLengths(List<Double> triangleSidesList) {

        if (triangleSidesList == null)
            throw new NullPointerException("Triangle side length can not be null");

        if (triangleSidesList.size() != 3)
            throw new IllegalArgumentException("Triangle side must be exactly three sides");

        if (triangleSidesList.get(0).equals(0.0) || triangleSidesList.get(1).equals(0.0) || triangleSidesList.get(2).equals(0.0))
            throw new IllegalArgumentException("Triangle side length can not equal to zero");

        Triangle triangle = null;

        // The instance hashSet does not allow duplicates. It is an efficient way to determine the type of the triangle, by hashing the side lengths to check how many are equal.
        this.triangleSidesSet.addAll(triangleSidesList);

        if (triangleSidesSet.size() == 1) {
            triangle = TriangleFactory.createTriangle("Equilateral", triangleSidesList);
        } else if (triangleSidesSet.size() == 2) {
            triangle = TriangleFactory.createTriangle("Isosceles", triangleSidesList);
        } else
            triangle = TriangleFactory.createTriangle("Scalene", triangleSidesList);

        triangleSidesSet.clear();

        return triangle;
    }
}
