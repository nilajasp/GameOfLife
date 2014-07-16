import java.util.ArrayList;
import java.util.List;

/**
 * Created by nilajapatankar on 3/28/14.
 */
public class Universe {

    public List<Cell> Cells;

    public Universe() {
        Cells = new ArrayList<Cell>();
    }

    public void Create(String[] input) {
        PopulateGridWithUserData(input);
    }

    private void PopulateGridWithUserData(String[] input) {
        for (int k = 0; k < input.length; k++) {
            if (input[k] != null) {
                int line = input[k].length();
                for (int i = 0; i < line; i++) {
                    Cell cell = new Cell(k, i);
                    if (input[k].charAt(i) == 'X')
                        cell.SetState(new AliveStateOfCell());
                    else
                        cell.SetState(new DeadStateOfCell());
                    Cells.add(cell);
                }
            }
        }
    }

    public void InstantiateNeighbourCells() {
        for (Cell cell : Cells) {
            int rowNumber = cell.GetRowNumber();
            int colNumber = cell.GetColNumber();
            Cell neighbourCell;

            if (rowNumber > 0) {
                neighbourCell = SelectNeighbourCellFromAllCells(rowNumber - 1, colNumber);
                cell.AddToNeighbouringCells(neighbourCell);
                neighbourCell = SelectNeighbourCellFromAllCells(rowNumber - 1, colNumber + 1);
                cell.AddToNeighbouringCells(neighbourCell);
            }

            if (colNumber > 0) {
                neighbourCell = SelectNeighbourCellFromAllCells(rowNumber, colNumber - 1);
                cell.AddToNeighbouringCells(neighbourCell);
                neighbourCell = SelectNeighbourCellFromAllCells(rowNumber + 1, colNumber - 1);
                cell.AddToNeighbouringCells(neighbourCell);
            }

            if (rowNumber > 0 && colNumber > 0) {
                neighbourCell = SelectNeighbourCellFromAllCells(rowNumber - 1, colNumber - 1);
                cell.AddToNeighbouringCells(neighbourCell);
            }
            neighbourCell = SelectNeighbourCellFromAllCells(rowNumber, colNumber + 1);
            cell.AddToNeighbouringCells(neighbourCell);
            neighbourCell = SelectNeighbourCellFromAllCells(rowNumber + 1, colNumber);
            cell.AddToNeighbouringCells(neighbourCell);
            neighbourCell = SelectNeighbourCellFromAllCells(rowNumber + 1, colNumber + 1);
            cell.AddToNeighbouringCells(neighbourCell);
        }
    }

    private Cell SelectNeighbourCellFromAllCells(int rowNumber, int colNumber) {
        Cell neighbourCell = null;
        for (Cell cell : Cells) {
            if (cell.GetRowNumber() == rowNumber && cell.GetColNumber() == colNumber) {
                neighbourCell = cell;
                break;
            }
        }
        if (neighbourCell == null)
            neighbourCell = new Cell(rowNumber, colNumber);
        return neighbourCell;
    }

    public void Play() {
        for (Cell cell : Cells) {
            cell.ChangeStateAfterTick();
        }
    }
}