import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by nilajapatankar on 9/26/14.
 */
public class UniverseTest {
    @Test
    public void TestThatCreateGeneratesListOfCells() {
        //Given
        String[] input = new String[]{"XX","XX"};
        int numberOfRows = 2;
        int numberOfColumns = 2;

        //When
        Universe universe = new Universe();
        universe.Create(input, numberOfRows, numberOfColumns);

        //Then
        Assert.assertNotNull(universe.Cells);
        Assert.assertEquals(16, universe.Cells.size());
    }

    @Test
    public void TestThatInstantiateNeighbourCells() {
        //Given
        String[] input = new String[]{"XX","XX"};
        int numberOfRows = 2;
        int numberOfColumns = 2;

        //When
        Universe universe = new Universe();
        universe.Create(input, numberOfRows, numberOfColumns);
        universe.InstantiateNeighbourCells();

        //Then
        for (Cell cell : universe.Cells) {
            Assert.assertNotNull(cell._neighbourCells);
            Assert.assertNotEquals(0,cell._neighbourCells.size());
        }
    }

    @Test
    public void TestThatPlayReturnsDifferentStateOfUniverseAfterOneTick() {
        //Given
        String[] input = new String[]{"XX","XX"};
        int numberOfRows = 2;
        int numberOfColumns = 2;

        //When
        Universe universe = new Universe();
        universe.Create(input, numberOfRows, numberOfColumns);
        universe.InstantiateNeighbourCells();
        List<Cell> result = universe.Play();

        //Then
        Assert.assertNotEquals(result,universe.Cells);
        Assert.assertEquals(result.size(),universe.Cells.size());
    }
}
