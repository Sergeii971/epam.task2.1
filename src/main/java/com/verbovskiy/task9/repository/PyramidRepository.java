package com.verbovskiy.task9.repository;

import com.verbovskiy.task9.entity.TriangularPyramid;
import com.verbovskiy.task9.exception.TaskException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PyramidRepository {
    private List<TriangularPyramid> pyramids;
    private static PyramidRepository instance;

    private PyramidRepository(){
        pyramids = new ArrayList<>();
    }

    public static PyramidRepository getInstance(){
        if (instance == null){
            instance = new PyramidRepository();
        }
        return instance;
    }

    public void add(TriangularPyramid pyramid){
        pyramids.add(pyramid);
    }

    public void addAll(List<TriangularPyramid> pyramid){
        pyramids.addAll(pyramid);
    }

    public TriangularPyramid get(int index) throws TaskException {
        if ((index >= pyramids.size()) || (index < 0)) {
            throw new TaskException("incorrect index");
        } else {
            return pyramids.get(index);
        }
    }

    public void remove(TriangularPyramid pyramid){
        pyramids.remove(pyramid);
    }

    public List<TriangularPyramid> query(Specification specification) {
        return pyramids.stream().filter(specification).collect(Collectors.toList());
    }

    public List<TriangularPyramid> sort(Comparator<TriangularPyramid> comparator){
        return pyramids.stream().sorted(comparator).collect(Collectors.toList());
    }
}
