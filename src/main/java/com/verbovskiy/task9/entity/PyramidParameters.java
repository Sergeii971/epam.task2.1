package com.verbovskiy.task9.entity;

public class PyramidParameters {
    private double volume;
    private double lateralSurfaceArea;

    public PyramidParameters(double volume, double lateralSurfaceArea) {
        this.volume = volume;
        this.lateralSurfaceArea = lateralSurfaceArea;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setLateralSurfaceArea(double lateralSurfaceArea) {
        this.lateralSurfaceArea = lateralSurfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public double getLateralSurfaceArea() {
        return lateralSurfaceArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (this.getClass() != o.getClass())) {
            return false;
        }
        PyramidParameters parameters = (PyramidParameters) o;

        return ((this.volume == parameters.volume) && (this.lateralSurfaceArea == parameters.lateralSurfaceArea));
    }

    @Override
    public int hashCode() {
        int result = 1;

        result = 31 * result + Double.hashCode(volume);
        result = 31 * result + Double.hashCode(lateralSurfaceArea);
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(volume);
        stringBuilder.append(lateralSurfaceArea);
        return stringBuilder.toString();
    }
}
