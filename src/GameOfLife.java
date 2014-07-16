import java.util.Scanner;

/**
 * Created by nilajapatankar on 3/26/14.
 */
public class GameOfLife {

    static Universe Universe = new Universe();

    public void Start() {
        String[] inputLines = GetInputFromUser();
        Universe.Create(inputLines);
        Universe.InstantiateNeighbourCells();
        Universe.Play();
        DisplayOutputOfGame();
    }

    private void DisplayOutputOfGame() {
        for (Cell cell : Universe.Cells) {
            System.out.print(cell.GetCellState());
        }
    }

    private String[] GetInputFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter matrix as per your requirement:\n'X'\t: ForLive Cell\n'-'\t: For dead Cell\n'Q'\t: Enter Q on new line for ending input\n");
        String[] inputLines = new String[10];
        int i = 0;
        String singleLineFromInput = scanner.nextLine();
        while (!singleLineFromInput.equalsIgnoreCase("Q")) {
            inputLines[i] = singleLineFromInput;
            singleLineFromInput = scanner.nextLine();
            i++;
        }
        return inputLines;
    }
}
