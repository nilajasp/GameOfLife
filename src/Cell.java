import java.util.ArrayList;
import java.util.List;

/**
 * Created by nilajapatankar on 3/28/14.
 */
public class Cell {

    List<Cell> _neighbourCells;

    IStateOfCell _state;

    PositionOfCellInGrid _position;

    private int _numberOfLiveNeighbours;

    public Cell(int k, int i){
        _position = new PositionOfCellInGrid(k,i);
        _neighbourCells = new ArrayList<Cell>();
    }

    public void ChangeStateAfterTick()
    {
        CalculateNumberOfLiveNeighbours();
        _state = _state.ChangeState(_numberOfLiveNeighbours);
    }

    private void CalculateNumberOfLiveNeighbours() {
        for (Cell neighbourCell : _neighbourCells) {
            if(neighbourCell.GetCellState().compareToIgnoreCase("X") == 0)
                _numberOfLiveNeighbours++;
        }
    }

    public void AddToNeighbouringCells(Cell neighbourCell)
    {
        _neighbourCells.add(neighbourCell);
    }

    public int GetRowNumber() {
        return _position.GetRowNumber();
    }

    public int GetColNumber() {
        return _position.GetColNumber();
    }

    public void SetState(IStateOfCell stateOfCell) {
        _state = stateOfCell;
    }

    public String GetCellState() {
        return _state.toString();
    }
}
