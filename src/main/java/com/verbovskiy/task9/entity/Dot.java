package com.verbovskiy.task9.entity;

public class Dot {
    private double xCoordinate;
    private double yCoordinate;
    private double zCoordinate;

    public Dot(double xCoordinate, double yCoordinate, double zCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.zCoordinate = zCoordinate;
    }

    public void setXCoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setYCoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public void setZCoordinate(double zCoordinate) {
        this.zCoordinate = zCoordinate;
    }

    public double getXCoordinate() {
        return xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public double getZCoordinate() {
        return zCoordinate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (this.getClass() != o.getClass())) {
            return false;
        }
        Dot dot = (Dot) o;

        return ((this.xCoordinate == dot.xCoordinate) && (this.yCoordinate == dot.yCoordinate)
                && (this.zCoordinate == dot.zCoordinate));
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Double.hashCode(this.xCoordinate);
        result = 31 * result + Double.hashCode(this.yCoordinate);
        result = 31 * result + Double.hashCode(this.zCoordinate);
        return result;
    }

    @Override
    public String toString() {
        return String.format("[%f; %f; %f]",this.xCoordinate, this.yCoordinate, this.zCoordinate);
    }
}
