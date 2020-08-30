package com.verbovskiy.task9.observer;

import com.verbovskiy.task9.entity.TriangularPyramid;

import java.util.EventObject;

public class PyramidEvent extends EventObject {
    public PyramidEvent (Object source){
        super(source);
    }

    @Override
    public TriangularPyramid getSource() {
        return (TriangularPyramid) super.getSource();
    }
}
