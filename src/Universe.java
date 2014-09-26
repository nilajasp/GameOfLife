import java.util.ArrayList;
import java.util.List;

/**
 * Created by nilajapatankar on 3/28/14.
 */
public class Universe {

    public List<Cell> cells;

    public Universe() {
        cells = new ArrayList<Cell>();
    }

    public void Create(String[] input,int numberOfRows, int numberOfColumns) {
        PopulateUniverseWithUserData(input, numberOfRows, numberOfColumns);
    }

    private void PopulateUniverseWithUserData(String[] input, int numberOfRows, int numberOfColumns) {

        //Initialise first row as empty row
        for(int colNumber = 0 ; colNumber <= numberOfColumns+1; colNumber++)
        {
            Cell firstRowCell = new Cell(0, colNumber);
            cells.add(firstRowCell);
        }

        for (int k = 0; k < numberOfRows; k++) {
            if (input[k] != null) {
                Cell firstCellInRow = new Cell(k+1,0);
                cells.add(firstCellInRow);
                for (int i = 0; i < numberOfColumns; i++) {
                    Cell cell = new Cell(k+1, i+1);
                    if (input[k].charAt(i) == 'X')
                        cell.SetState(new AliveStateOfCell());
                    else
                        cell.SetState(new DeadStateOfCell());
                    cells.add(cell);
                }
                Cell lastCellInRow=new Cell(k+1,numberOfColumns+1);
                cells.add(lastCellInRow);
            }
        }

        //Initialize last row as empty row
        for(int colNumber = 0 ; colNumber <= numberOfColumns+1; colNumber++)
        {
            Cell firstRowCell = new Cell(numberOfRows+1, colNumber);
            cells.add(firstRowCell);
        }
    }

    public void InstantiateNeighbourCells() {
        for (Cell cell : cells) {
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
        for (Cell cell : cells) {
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
        for (Cell cell : cells) {
            Cell currentCell = new Cell(cell.GetRowNumber(), cell.GetColNumber());
            if(cell.GetCellState() == "X")
                currentCell.SetState(new AliveStateOfCell());
            currentCell.neighbourCells = cell.neighbourCells;
            currentCell.ChangeStateAfterTick();
            newCells.add(currentCell);
        }
        return newCells;
    }
}