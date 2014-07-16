/**
 * Created by nilajapatankar on 6/23/14.
 */
public class DeadStateOfCell implements IStateOfCell {

    @Override
    public IStateOfCell ChangeState(int numberOfLiveNeighbours) {
        if(numberOfLiveNeighbours == 3)
            return new AliveStateOfCell();
        return this;
    }

    @Override
    public String toString()
    {
        return "-";
    }
}
