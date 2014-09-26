import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nilajapatankar on 9/26/14.
 */
public class AliveStateOfCellTest {
    @Test
    public void TestThatToStringReturnsX() {
        //Given
        IStateOfCell stateOfCell = new AliveStateOfCell();

        //Then
        Assert.assertEquals("X", stateOfCell.toString());
    }

    @Test
    public void TestThatCellBecomesDeadIfItDoesNotHaveTwoOrThreeAliveNeighbours() {
        //Given
        IStateOfCell stateOfCell = new AliveStateOfCell();
        int numberOfAliveNeighbours = 1;

        //When
        IStateOfCell newStateOfCell = stateOfCell.ChangeState(numberOfAliveNeighbours);

        //Then
        Assert.assertEquals(DeadStateOfCell.class, newStateOfCell.getClass());
    }

    @Test
    public void TestThatCellRemainsAliveIfItHasTwoAliveNeighbours() {
        //Given
        IStateOfCell stateOfCell = new AliveStateOfCell();
        int numberOfAliveNeighbours = 2;

        //When
        IStateOfCell newStateOfCell = stateOfCell.ChangeState(numberOfAliveNeighbours);

        //Then
        Assert.assertEquals(AliveStateOfCell.class, newStateOfCell.getClass());
    }

    @Test
    public void TestThatCellRemainsAliveIfItHasThreeAliveNeighbours() {
        //Given
        IStateOfCell stateOfCell = new AliveStateOfCell();
        int numberOfAliveNeighbours = 3;

        //When
        IStateOfCell newStateOfCell = stateOfCell.ChangeState(numberOfAliveNeighbours);

        //Then
        Assert.assertEquals(AliveStateOfCell.class, newStateOfCell.getClass());
    }
}
