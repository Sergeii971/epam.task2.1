package com.verbovskiy.task9.entity;

public abstract class Shape {
    protected int id;

    public Shape(int id) {
    this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || o.getClass() != getClass()){
            return false;
        }

        Shape shape = (Shape) o;
        return (id == shape.id);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result += 31 * result + id;

        return result;
    }

    @Override
    public String toString() {
        return String.format("%d", id);
    }
}
