import java.util.ArrayList;
import java.util.List;

/**
 * Created by nilajapatankar on 3/28/14.
 */
public class Cell {

    List<Cell> neighbourCells;

    IStateOfCell state;

    PositionOfCellInUniverse position;

    private int numberOfLiveNeighbours;

    public Cell(int k, int i){
        position = new PositionOfCellInUniverse(k,i);
        neighbourCells = new ArrayList<Cell>();
        state = new DeadStateOfCell();
    }

    public void ChangeStateAfterTick()
    {
        CalculateNumberOfLiveNeighbours();
        state = state.ChangeState(numberOfLiveNeighbours);
    }

    private void CalculateNumberOfLiveNeighbours() {
        for (Cell neighbourCell : neighbourCells) {
            if(neighbourCell.GetCellState().compareToIgnoreCase("X") == 0)
                numberOfLiveNeighbours++;
        }
    }

    public void AddToNeighbouringCells(Cell neighbourCell)
    {
        neighbourCells.add(neighbourCell);
    }

    public int GetRowNumber() {
        return position.GetRowNumber();
    }

    public int GetColNumber() {
        return position.GetColNumber();
    }

    public void SetState(IStateOfCell stateOfCell) {
        state = stateOfCell;
    }

    public String GetCellState() {
        return state.toString();
    }
}
