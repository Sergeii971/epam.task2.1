package com.verbovskiy.task9.comparator;

import com.verbovskiy.task9.entity.TriangularPyramid;

import java.util.Comparator;

public enum PyramidComparator {
        ID((TriangularPyramid pyramid1, TriangularPyramid pyramid2) -> Integer.compare(pyramid1.getId(),
                pyramid2.getId())),
        MAIN_TOP_X_COORDINATE((TriangularPyramid pyramid1, TriangularPyramid pyramid2)
                -> Double.compare(pyramid1.getMainTop().getXCoordinate(), pyramid2.getMainTop().getXCoordinate())),
    MAIN_TOP_Y_COORDINATE((TriangularPyramid pyramid1, TriangularPyramid pyramid2)
            -> Double.compare(pyramid1.getMainTop().getYCoordinate(), pyramid2.getMainTop().getYCoordinate()));

        private Comparator<TriangularPyramid> comparator;

        PyramidComparator(Comparator<TriangularPyramid> comparator){
            this.comparator = comparator;
        }

        public Comparator<TriangularPyramid> getComparator(){
            return comparator;
        }
}
