import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nilajapatankar on 3/28/14.
 */
//public class GridTest {
//    @Test
//    public void TestThatCreateGridCreatesGridFromStringInput() throws Exception {
//        //Given
//        Universe grid = new Universe();
//        String[] input = {"XX","XX"};
//        Cell[][] actualGrid = new Cell[10][10];
//
//        //When
//        grid.Create(input);
//        actualGrid = grid.Cells;
//        input = new String[10];
//        grid.Create(input);
//        Cell[][] expectedGrid = grid.Cells;
//        expectedGrid[1][1].IsAlive = true;
//        expectedGrid[1][2].IsAlive = true;
//        expectedGrid[2][1].IsAlive = true;
//        expectedGrid[2][2].IsAlive = true;
//
//        //Then
//        Assert.assertArrayEquals(expectedGrid, actualGrid);
//    }
//
//    @Test
//    public void TestThatCalculateNumberOfLiveNeighboursForEachCellCalculatesNumberOfLiveNeighbours() throws Exception {
//        //Given
//        Universe grid = new Universe();
//        String[] input = {"XX","XX"};
//        grid.Create(input);
//
//        //When
//        grid.CalculateNumberOfLiveNeighboursForEachCell();
//        int LiveNeighbours1 = grid.Cells[1][1]._numberOfLiveNeighbours;
//        int LiveNeighbours2 = grid.Cells[1][2]._numberOfLiveNeighbours;
//        int LiveNeighbours3 = grid.Cells[2][1]._numberOfLiveNeighbours;
//        int LiveNeighbours4 = grid.Cells[2][2]._numberOfLiveNeighbours;
//
//        //Then
//        Assert.assertEquals(3,LiveNeighbours1);
//        Assert.assertEquals(3,LiveNeighbours2);
//        Assert.assertEquals(3,LiveNeighbours3);
//        Assert.assertEquals(3, LiveNeighbours4);
//    }
//
//    @Test
//    public void TestThatResultOfGameIsReturnedCorrect() throws Exception {
//        //Given
//        Universe grid = new Universe();
//        String[] input = {"XX","XX"};
//        grid.Create(input);
//
//        //When
//        grid.InstantiateNeighbourCells();
//        Cell[][] actualGrid =grid.Cells;
//
//        input = new String[10];
//        grid.Create(input);
//        Cell[][] expectedGrid = grid.Cells;
//        expectedGrid[1][1].IsAlive = true;
//        expectedGrid[1][2].IsAlive = true;
//        expectedGrid[2][1].IsAlive = true;
//        expectedGrid[2][2].IsAlive = true;
//        //Then
//        Assert.assertArrayEquals(expectedGrid,actualGrid);
//    }
//}
