/**
 * controller class for the game of life board
 */
public class Board {

    Cell[][] board;
    int generation;

     Board(int rows, int cols){
        board = new Cell[rows][cols];

         for (int i = 0; i < rows; i++) {
             for (int j = 0; j < cols; j++) {
                 board[i][j] = new Cell();
             }
         }

         generation = 0;
    }

    void printBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }

    int getRows(){
        return board.length;
    }

    int getCols(){
        return board[0].length;
    }

    Cell.State getState(int row, int col){
        return board[row][col].getState();
    }

    //this method returns the number of cells that are alive (1)
    //surrounding the cell at board[row][col], if cell is on the
    //edge of a board then a wrap around technique is used and the
    //cells on the edge across from it are analyzed
    int countNeighbors(int row, int col){

        int count = 0;

        for (int i = row-1; i <= row+1; i++) {
            int tempi = i;

            //wrap around
            if(tempi == -1) {
                tempi = getRows()-1;
            }
            else if(tempi == getRows()){
                tempi = 0;
            }

            for (int j = col-1; j <= col+1; j++) {

                int tempj = j;

                //wrap around
                if(tempj == -1) {
                    tempj = getCols()-1;
                }
                else if(tempj == getCols()){
                    tempj = 0;
                }

                if(board[tempi][tempj].getState() == Cell.State.ALIVE || board[tempi][tempj].getState() == Cell.State.BIRTHED)
                    count++;
            }
        }
        System.out.println();

        if (board[row][col].getState() == Cell.State.ALIVE || board[row][col].getState() == Cell.State.BIRTHED)
            count--;

        return count;
    }

    //this method checks the state of a cell and its # of neighbors
    //against a set of rules and returns the value of the new state
    Cell.State getStateFromRule(Cell.State currentState, int neighbors){
        if((currentState == Cell.State.ALIVE || currentState == Cell.State.BIRTHED) && (neighbors < 2 || neighbors>3))
            return Cell.State.DIED;
        else if((currentState == Cell.State.BLANK || currentState == Cell.State.DIED) && neighbors == 3)
            return Cell.State.BIRTHED;
        else
            if(currentState == Cell.State.BIRTHED)
                return Cell.State.ALIVE;
            else if(currentState == Cell.State.DIED)
                    return Cell.State.BLANK;
            else
                return currentState;
    }

    //generates a new board by applying rules to the current state of the board
    //the new board is reassigned to the board valuable
    void generate(){

        int rows = getRows();
        int cols = getCols();

        Cell[][] nextgen = new Cell[rows][cols];

        for(int i = 0; i < rows; i++){

            for (int j = 0; j < cols; j++) {
                nextgen[i][j] = new Cell(getStateFromRule(board[i][j].getState(), countNeighbors(i,j)));
            }
        }

        generation++;
        board = nextgen;
    }

}
