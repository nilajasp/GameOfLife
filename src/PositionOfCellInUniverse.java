/**
 * Created by nilajapatankar on 6/25/14.
 */
public class PositionOfCellInUniverse {
    private int row;
    private int col;

    public PositionOfCellInUniverse(int k, int i) {
        row = k;
        col = i;
    }

    public int GetRowNumber() {
        return row;
    }

    public int GetColNumber() {
        return col;
    }
}
