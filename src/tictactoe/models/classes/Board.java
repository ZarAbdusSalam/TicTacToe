package tictactoe.models.classes;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private int size;
    private List<List<Cell>> board;

    /*
            [   [_,_,_] ,
                [_,_,_] ,
                [_,_,_]   ]
    */

    public Board(int size){
        this.size=size; // example 3
        this.board = new ArrayList<>(); // Gives outer ArrayList -> []

        for(int i=0; i<size; i++){
//            this.getBoard().get(i).add(new ArrayList<>()); // adds new arraylist on each index of the outer arraylist [ [],[],[] ] -> error
//            this.getBoard().add(new ArrayList<>()); // adds new arraylist on each index of the outer arraylist [ [],[],[] ] -> this also works
            this.board.add(new ArrayList<>()); // adds new arraylist on each index of the outer arraylist [ [],[],[] ]

            for(int j=0; j<size; j++){
                this.getBoard().get(i).add(new Cell(i,j)); // add cell to each space in the 3x3 matrix
//                this.board.get(i).add(new Cell(i,j)); -> this also works

            }
        }
    }


    public void printBoard(){
        for(int i=0; i<size; i++){
            List<Cell> row = this.board.get(i);
            for(int j=0; j<size; j++){
                row.get(j).display(); // display() method from cell class
            }
            System.out.println();

        }

    }



//    setters and getters
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
}
