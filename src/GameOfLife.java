import java.util.List;
import java.util.Scanner;

/**
 * Created by nilajapatankar on 3/26/14.
 */
public class GameOfLife {

    Universe universe = new Universe();
    int numberOfRows;
    int numberOfColumns;

    public void Start() {
        String[] inputLines = GetInputFromUser();
        CalculateNumebrOfRowsAndColumns(inputLines);
        universe.Create(inputLines, numberOfRows, numberOfColumns);
        universe.InstantiateNeighbourCells();
        List<Cell> result = universe.Play();
        DisplayOutputOfGame(result);
    }

    private void CalculateNumebrOfRowsAndColumns(String[] inputLines) {
        for (int k = 0; k < numberOfRows; k++) {
            if (inputLines[k] != null) {
                int lineLength = inputLines[k].length();
                if (lineLength > numberOfColumns) numberOfColumns = lineLength;
            }
        }
    }

    private void DisplayOutputOfGame(List<Cell> result) {
        numberOfRows += 2;
        numberOfColumns +=2;

        for(int rowNumber = 0; rowNumber<numberOfRows; rowNumber++) {
            System.out.println();
            for (int colNumber =0; colNumber<numberOfColumns; colNumber++) {
                for (Cell cell : result) {
                    if (cell.GetRowNumber() == rowNumber && cell.GetColNumber() == colNumber) {
                        System.out.print(cell.GetCellState());
                        break;
                    }
                }
            }
        }
    }

    private String[] GetInputFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter matrix as per your requirement:\n'X'\t: For Live Cell\n'-'\t: For dead Cell\n'Q'\t: Enter Q on new line for ending input\n");
        String[] inputLines = new String[10];
        int i = 0;
        String singleLineFromInput = scanner.nextLine();
        while (!singleLineFromInput.equalsIgnoreCase("Q")) {
            inputLines[i] = singleLineFromInput;
            singleLineFromInput = scanner.nextLine();
            numberOfRows = ++i;
        }
        return inputLines;
    }
}
