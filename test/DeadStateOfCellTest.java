import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nilajapatankar on 9/26/14.
 */
public class DeadStateOfCellTest {
    @Test
    public void TestThatToStringReturnsHyphen() {
        //Given
        IStateOfCell stateOfCell = new DeadStateOfCell();

        //Then
        Assert.assertEquals("-", stateOfCell.toString());
    }

    @Test
    public void TestThatCellBecomesAliveIfItHasThreeAliveNeighbours() {
        //Given
        IStateOfCell stateOfCell = new DeadStateOfCell();
        int numberOfAliveNeighbours = 3;

        //When
        IStateOfCell newStateOfCell = stateOfCell.ChangeState(numberOfAliveNeighbours);

        //Then
        Assert.assertEquals(AliveStateOfCell.class, newStateOfCell.getClass());
    }

    @Test
    public void TestThatCellRemainsDeadIfItDoesNotHaveThreeAliveNeighbours() {
        //Given
        IStateOfCell stateOfCell = new DeadStateOfCell();
        int numberOfAliveNeighbours = 2;

        //When
        IStateOfCell newStateOfCell = stateOfCell.ChangeState(numberOfAliveNeighbours);

        //Then
        Assert.assertEquals(DeadStateOfCell.class, newStateOfCell.getClass());
    }
}
