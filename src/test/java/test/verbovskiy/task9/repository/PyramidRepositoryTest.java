package test.verbovskiy.task9.repository;

import com.verbovskiy.task9.comparator.PyramidComparator;
import com.verbovskiy.task9.creator.PyramidCreator;
import com.verbovskiy.task9.entity.TriangularPyramid;
import com.verbovskiy.task9.exception.TaskException;
import com.verbovskiy.task9.repository.PyramidRepository;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class PyramidRepositoryTest {
    private final String FILE_NAME = "data/pyramids.txt";

    @BeforeClass
    public void setUp() throws TaskException {
        PyramidCreator creator = new PyramidCreator();
        List<TriangularPyramid> pyramids = creator.createPyramidsFile(FILE_NAME);
        PyramidRepository repository = PyramidRepository.getInstance();

        repository.addAll(pyramids);
    }

    @Test
    public void sortPositiveTest() throws TaskException {
        PyramidRepository repository = PyramidRepository.getInstance();
        Comparator comparator = PyramidComparator.MAIN_TOP_X_COORDINATE.getComparator();
        List<TriangularPyramid> actual = repository.sort(comparator);
        List<TriangularPyramid> expected = new ArrayList<>();
        expected.add(repository.get(2));
        expected.add(repository.get(1));
        expected.add(repository.get(0));
        assertEquals(actual, expected);
    }

    @Test
    public void sortNegativeTest() throws TaskException {
        PyramidRepository repository = PyramidRepository.getInstance();
        Comparator comparator = PyramidComparator.MAIN_TOP_X_COORDINATE.getComparator();
        List<TriangularPyramid> actual = repository.sort(comparator);
        List<TriangularPyramid> expected = new ArrayList<>();
        expected.add(repository.get(1));
        expected.add(repository.get(2));
        expected.add(repository.get(0));
        assertNotEquals(actual, expected);
    }
}