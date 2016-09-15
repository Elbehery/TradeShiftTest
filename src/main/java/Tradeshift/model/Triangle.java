package Tradeshift.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public abstract class Triangle {

    private List<Double> triangleSidesList;

    public Triangle(List<Double> sides) {

        this.triangleSidesList = Collections.unmodifiableList(new ArrayList<Double>(sides));

    }

    public List<Double> getTriangleSides() {
        return triangleSidesList;
    }
}
