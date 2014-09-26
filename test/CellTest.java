import org.junit.Assert;
import org.junit.Test;

/**
* Created by nilajapatankar on 3/28/14.
*/
public class CellTest {
    @Test
    public void TestThatCellIsDeadByDefault() {
        //Given
        Cell cell = new Cell(0,0);

        //Then
        Assert.assertEquals("-",cell.GetCellState());
    }

    @Test
    public void TestThatDeadCellBecomesAliveAfterOneTickIfItHasThreeAliveNeighbours() throws Exception {
        //Given
        Cell cell = new Cell(0,0);
        Cell neighbourCell1 = new Cell(0,1);
        neighbourCell1.SetState(new AliveStateOfCell());
        Cell neighbourCell2 = new Cell(1,1);
        neighbourCell2.SetState(new AliveStateOfCell());
        Cell neighbourCell3 = new Cell(1,0);
        neighbourCell3.SetState(new AliveStateOfCell());

        cell.AddToNeighbouringCells(neighbourCell1);
        cell.AddToNeighbouringCells(neighbourCell2);
        cell.AddToNeighbouringCells(neighbourCell3);

        //When
        cell.ChangeStateAfterTick();

        //Then
        Assert.assertEquals("X",cell.GetCellState());
    }

    @Test
    public void TestThatDeadCellRemainsDeadAfterOneTickIfItDoesNotHaveThreeAliveNeighbours() {
        //Given
        Cell cell = new Cell(0,0);

        //When
        cell.ChangeStateAfterTick();

        //Then
        Assert.assertEquals("-",cell.GetCellState());
    }

    @Test
    public void TestThatAliveCellBecomesDeadAfterOneTickIfItHasLessThanTwoAliveNeighbourCells() {
        //Given
        Cell cell = new Cell(0,0);
        Cell neighbourCell1 = new Cell(0,1);
        neighbourCell1.SetState(new AliveStateOfCell());

        cell.AddToNeighbouringCells(neighbourCell1);

        //When
        cell.ChangeStateAfterTick();

        //Then
        Assert.assertEquals("-", cell.GetCellState());
    }

    @Test
    public void TestThatAliveCellBecomesDeadAfterOneTickIfItHasMoreThanThreeAliveNeighbourCells() {
        //Given
        Cell cell = new Cell(1,1);
        cell.SetState(new AliveStateOfCell());
        Cell neighbourCell1 = new Cell(0,1);
        neighbourCell1.SetState(new AliveStateOfCell());
        Cell neighbourCell2 = new Cell(1,0);
        neighbourCell2.SetState(new AliveStateOfCell());
        Cell neighbourCell3 = new Cell(1,2);
        neighbourCell3.SetState(new AliveStateOfCell());
        Cell neighbourCell4 = new Cell(2,1);
        neighbourCell4.SetState(new AliveStateOfCell());

        cell.AddToNeighbouringCells(neighbourCell1);

        //When
        cell.ChangeStateAfterTick();

        //Then
        Assert.assertEquals("-", cell.GetCellState());
    }

    @Test
    public void TestThatAliveCellRemainsAliveAfterOneTickIfItTwoAliveNeighbours() {
        //Given
        Cell cellWithTwoNeighbours = new Cell(0,0);
        cellWithTwoNeighbours.SetState(new AliveStateOfCell());
        Cell neighbourCell1 = new Cell(0,1);
        neighbourCell1.SetState(new AliveStateOfCell());
        Cell neighbourCell2 = new Cell(1,1);
        neighbourCell2.SetState(new AliveStateOfCell());

        cellWithTwoNeighbours.AddToNeighbouringCells(neighbourCell1);
        cellWithTwoNeighbours.AddToNeighbouringCells(neighbourCell2);

        //When
        cellWithTwoNeighbours.ChangeStateAfterTick();

        //Then
        Assert.assertEquals("X", cellWithTwoNeighbours.GetCellState());
    }

    @Test
    public void TestThatAliveCellRemainsAliveAfterOneTickIfItThreeAliveNeighbours() {
        //Given
        Cell cellWithThreeNeighbours = new Cell(0,0);
        cellWithThreeNeighbours.SetState(new AliveStateOfCell());
        Cell neighbourCell1 = new Cell(0,1);
        neighbourCell1.SetState(new AliveStateOfCell());
        Cell neighbourCell2 = new Cell(1,1);
        neighbourCell2.SetState(new AliveStateOfCell());
        Cell neighbourCell3 = new Cell(1,0);
        neighbourCell3.SetState(new AliveStateOfCell());

        cellWithThreeNeighbours.AddToNeighbouringCells(neighbourCell1);
        cellWithThreeNeighbours.AddToNeighbouringCells(neighbourCell2);
        cellWithThreeNeighbours.AddToNeighbouringCells(neighbourCell3);

        //When
        cellWithThreeNeighbours.ChangeStateAfterTick();

        //Then
        Assert.assertEquals("X", cellWithThreeNeighbours.GetCellState());
    }

    @Test
    public void TestThatAddToNeighbouringCellsAddsCellToListOfNeighbourCell() {
        //Given
        Cell cell = new Cell(0,0);
        Cell neighbourCell = new Cell(0,1);
        cell.AddToNeighbouringCells(neighbourCell);

        //Then
        Assert.assertEquals(1, cell._neighbourCells.size());
    }

    @Test
    public void TestThatGetRowNumberReturnsRowPositionOfCell() {
        //Given
        Cell cell = new Cell(3,2);

        //Then
        Assert.assertEquals(3, cell.GetRowNumber());
    }

    @Test
    public void TestThatGetColNumberReturnsColPositionOfCell() {
        //Given
        Cell cell = new Cell(3,2);

        //Then
        Assert.assertEquals(2, cell.GetColNumber());
    }

    @Test
    public void TestThatSetStateToAliveReturnsCorrectState() {
        //Given
        Cell cell = new Cell(3,2);

        //When
        cell.SetState(new AliveStateOfCell());

        //Then
        Assert.assertEquals("X", cell.GetCellState());
    }

    @Test
    public void TestThatSetStateToDeadReturnsCorrectState() {
        //Given
        Cell cell = new Cell(3,2);

        //When
        cell.SetState(new DeadStateOfCell());

        //Then
        Assert.assertEquals("-", cell.GetCellState());
    }
}