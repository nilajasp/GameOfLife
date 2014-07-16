/**
 * Created by nilajapatankar on 6/25/14.
 */
public class PositionOfCellInGrid {
    private int _row;
    private int _col;

    public PositionOfCellInGrid(int k, int i) {
        _row = k;
        _col = i;
    }

    public int GetRowNumber() {
        return _row;
    }

    public int GetColNumber() {
        return _col;
    }
}
