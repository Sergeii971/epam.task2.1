package com.verbovskiy.task9.repository.impl;

import com.verbovskiy.task9.entity.TriangularPyramid;
import com.verbovskiy.task9.repository.Specification;

public class PyramidIdSpecificationImpl implements Specification {
    private int pyramidId;

    public PyramidIdSpecificationImpl(int pyramidId){
        this.pyramidId = pyramidId;
    }

    @Override
    public boolean test(TriangularPyramid pyramid) {
        return pyramidId == pyramid.getId();
    }
}
