package com.verbovskiy.task9;

import com.verbovskiy.task9.creator.PyramidCreator;
import com.verbovskiy.task9.entity.Dot;
import com.verbovskiy.task9.entity.PyramidParameters;
import com.verbovskiy.task9.entity.TriangularPyramid;
import com.verbovskiy.task9.exception.TaskException;
import com.verbovskiy.task9.repository.PyramidRepository;
import com.verbovskiy.task9.repository.impl.PyramidIdSpecificationImpl;
import com.verbovskiy.task9.repository.impl.PyramidVolumeSpecificationImpl;
import com.verbovskiy.task9.service.PyramidService;
import com.verbovskiy.task9.warehouse.PyramidParametersWarehouse;

import java.util.List;

public class Main {
    public static void main(String[]args) throws TaskException {
        PyramidCreator creator = new PyramidCreator();
        List<TriangularPyramid> pyramids = creator.createPyramidsFile("data/pyramids.txt");
        PyramidService service = new PyramidService();
        PyramidParametersWarehouse warehouse = PyramidParametersWarehouse.getInstance();
        double volume = service.calculateVolume(pyramids.get(0));
        double area = service.calculateLateralSurfaceArea(pyramids.get(0));
        warehouse.add(pyramids.get(0).getId(), new PyramidParameters(volume,area));

        double volume1 = service.calculateVolume(pyramids.get(1));
        double area1 = service.calculateLateralSurfaceArea(pyramids.get(1));
        warehouse.add(pyramids.get(1).getId(), new PyramidParameters(volume1,area1));

        double volume2 = service.calculateVolume(pyramids.get(2));
        double area2 = service.calculateLateralSurfaceArea(pyramids.get(2));
        warehouse.add(pyramids.get(2).getId(), new PyramidParameters(volume2,area2));

        PyramidRepository repository = PyramidRepository.getInstance();
        repository.addAll(pyramids);
        System.out.println(repository.query(new PyramidVolumeSpecificationImpl(0,0)));
    }
}
