package com.verbovskiy.task9.entity;

import com.verbovskiy.task9.exception.TaskException;
import com.verbovskiy.task9.util.IdGenerator;

public class TriangularPyramid extends Shape{
    private Dot firstFoundationTop;
    private Dot secondFoundationTop;
    private Dot thirdFoundationTop;
    private Dot mainTop;

    public TriangularPyramid(Dot firstFoundationTop, Dot secondFoundationTop,
                             Dot thirdFoundationTop, Dot mainTop) throws TaskException {
        super(IdGenerator.generateId());
        if ((firstFoundationTop == null) || (secondFoundationTop == null) || (thirdFoundationTop == null)
                || (mainTop == null)) {
            throw new TaskException("incorrect data");
        }
        this.firstFoundationTop = firstFoundationTop;
        this.secondFoundationTop = secondFoundationTop;
        this.thirdFoundationTop = thirdFoundationTop;
        this.mainTop = mainTop;
    }

    public Dot getFirstFoundationTop() {
        return firstFoundationTop;
    }

    public Dot getSecondFoundationTop() {
        return secondFoundationTop;
    }

    public Dot getThirdFoundationTop() {
        return thirdFoundationTop;
    }

    public Dot getMainTop() {
        return mainTop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (this.getClass() != o.getClass())) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        TriangularPyramid pyramid = (TriangularPyramid) o;
        if (this.firstFoundationTop == null) {
            if (pyramid.firstFoundationTop != null) {
                return false;
            }
        } else {
            if (!this.firstFoundationTop.equals(pyramid.firstFoundationTop)) {
                return false;
            }
        }
        if (this.secondFoundationTop == null) {
            if (pyramid.secondFoundationTop != null) {
                return false;
            }
        } else {
            if (!this.secondFoundationTop.equals(pyramid.secondFoundationTop)) {
                return false;
            }
        }
        if (this.thirdFoundationTop == null) {
            if (pyramid.thirdFoundationTop != null) {
                return false;
            }
        } else {
            if (!this.thirdFoundationTop.equals(pyramid.thirdFoundationTop)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 1;

        result = 31 * result + super.hashCode();
        result = 31 * result + (firstFoundationTop == null ? 0 : firstFoundationTop.hashCode());
        result = 31 * result + (secondFoundationTop == null ? 0 : secondFoundationTop.hashCode());
        result = 31 * result + (thirdFoundationTop == null ? 0 : thirdFoundationTop.hashCode());
        result = 31 * result + (mainTop == null ? 0 : mainTop.hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(id);
        stringBuilder.append(firstFoundationTop);
        stringBuilder.append(secondFoundationTop);
        stringBuilder.append(thirdFoundationTop);
        stringBuilder.append(mainTop);
        return stringBuilder.toString();
    }
}
