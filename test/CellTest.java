//import org.junit.Assert;
//import org.junit.Test;
//
///**
// * Created by nilajapatankar on 3/28/14.
// */
//public class CellTest {
//    @Test
//    public void TestThatCellIsDeadByDefault() throws Exception {
//        //Given
//        Cell cell = new Cell();
//
//        //Then
//        Assert.assertFalse(cell.IsAlive);
//    }
//
//    @Test
//    public void TestThatDyingFunctionMakesCellDead() throws Exception {
//        //Given
//        Cell cell = new Cell();
//
//        //When
//        cell.Dying();
//
//        //Then
//        Assert.assertFalse(cell.IsAlive);
//    }
//
//    @Test
//    public void TestThatFunctionComingBackToLifeMakesCellAlive() throws Exception {
//        //Given
//        Cell cell = new Cell();
//
//        //When
//        cell.ComingBackToLife();
//
//        //Then
//        Assert.assertTrue(cell.IsAlive);
//    }
//
//    @Test
//    public void TestThatNumberOfLiveNeighboursOfCellIsZeroByDefault() throws Exception {
//        //Given
//        Cell cell = new Cell();
//
//        //Then
//        Assert.assertEquals(0,cell._numberOfLiveNeighbours);
//    }
//}
