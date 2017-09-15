import processing.core.PApplet;

public class main extends PApplet {

    static Board board;

    public static void main(String args[]){
        PApplet.main("main", args);

        board = new Board(50,50);
    }

    public void settings(){
        size(600, 600);
    }

    public void setup(){
        background(255);
        frameRate(20);
    }

    public void draw(){

        width = board.getRows()/4;

        for (int i = 0; i < board.getRows(); i++) {

            for (int j = 0; j < board.getCols(); j++) {

                if(board.getState(i,j) == 0){
                    fill(255);
                }
                else {
                    fill(100);
                }
                rect(i * width, j*width, width, width);
            }
        }

        board.generate();
    }
}
