/**
 * this class manages the initialization and use of a game of life cell
 */
public class Cell {

    public enum State{
        ALIVE,
        BIRTHED,
        DIED,
        BLANK
    }

    State state;

     Cell(){
        if(Math.random() < 0.5){
            state = State.BLANK;
        }
        else{
            state = State.ALIVE;
        }
    }

    Cell(State s){
        state = s;
    }

    State getState(){
        return state;
    }

}
