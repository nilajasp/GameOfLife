/**
 * Created by nilajapatankar on 6/23/14.
 */
public interface IStateOfCell {
    IStateOfCell ChangeState(int numberOfLiveNeighbours);
}
