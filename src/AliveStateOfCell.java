/**
 * Created by nilajapatankar on 6/23/14.
 */
public class AliveStateOfCell implements IStateOfCell {

    @Override
    public IStateOfCell ChangeState(int numberOfLiveNeighbours) {
        if(numberOfLiveNeighbours != 2 && numberOfLiveNeighbours != 3)
            return new DeadStateOfCell();
        return this;
    }

    @Override
    public String toString()
    {
        return "X";
    }
}
