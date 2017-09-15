/**
 * this class manages the initialization and use of a game of life cell
 */
public class Cell {

    int state;

     Cell(){
        if(Math.random() < 0.5){
            state = 0;
        }
        else{
            state = 1;
        }
    }

    Cell(int s){
        state = s;
    }

    int getState(){
        return state;
    }

}
