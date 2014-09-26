import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nilajapatankar on 9/26/14.
 */
public class PositionOfCellInUniverseTest {
    @Test
    public void TestThatGetRowNumberReturnsRowPositionOfCell() {
        //Given
        PositionOfCellInUniverse position = new PositionOfCellInUniverse(3,2);

        //Then
        Assert.assertEquals(3, position.GetRowNumber());
    }

    @Test
    public void TestThatGetColNumberReturnsColPositionOfCell() {
        //Given
        PositionOfCellInUniverse position = new PositionOfCellInUniverse(3,2);

        //Then
        Assert.assertEquals(2, position.GetColNumber());
    }
}
