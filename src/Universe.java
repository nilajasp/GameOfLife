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

    public void Create(String[] input,int numberOfRows, int numberOfColumns) {
        PopulateGridWithUserData(input,numberOfRows, numberOfColumns);
    }

    private void PopulateGridWithUserData(String[] input,int numberOfRows, int numberOfColumns) {

        //Initialise first row as empty row
        for(int colNumber = 0 ; colNumber <= numberOfColumns+1; colNumber++)
        {
            Cell firstRowCell = new Cell(0, colNumber);
            Cells.add(firstRowCell);
        }

        for (int k = 0; k < numberOfRows; k++) {
            if (input[k] != null) {
                Cell firstCellInRow = new Cell(k+1,0);
                Cells.add(firstCellInRow);
                for (int i = 0; i < numberOfColumns; i++) {
                    Cell cell = new Cell(k+1, i+1);
                    if (input[k].charAt(i) == 'X')
                        cell.SetState(new AliveStateOfCell());
                    else
                        cell.SetState(new DeadStateOfCell());
                    Cells.add(cell);
                }
                Cell lastCellInRow=new Cell(k+1,numberOfColumns+1);
                Cells.add(lastCellInRow);
            }
        }

        //Initialize last row as empty row
        for(int colNumber = 0 ; colNumber <= numberOfColumns+1; colNumber++)
        {
            Cell firstRowCell = new Cell(numberOfRows+1, colNumber);
            Cells.add(firstRowCell);
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

    public List<Cell> Play() {
        List<Cell> newCells = new ArrayList<Cell>();
        for (Cell cell : Cells) {
            Cell currentCell = new Cell(cell.GetRowNumber(), cell.GetColNumber());
            if(cell.GetCellState() == "X")
                currentCell.SetState(new AliveStateOfCell());
            currentCell._neighbourCells = cell._neighbourCells;
            currentCell.ChangeStateAfterTick();
            newCells.add(currentCell);
        }
        return newCells;
    }
}