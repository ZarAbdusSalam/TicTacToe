package tictactoe.models.classes;

import tictactoe.exceptions.InvalidMoveException;
import tictactoe.models.enums.CellState;
import tictactoe.models.enums.PlayerType;

import java.util.List;
import java.util.Scanner;

public class Player {

    private Long id;
    private Symbol symbol;
    private String name;
    private PlayerType playerType;
    private Scanner scanner;

//    Constructor


//    public Player(Long id, Symbol symbol, String name, PlayerType playerType, Scanner scanner) {
    public Player(Long id, Symbol symbol, String name, PlayerType playerType) {

        this.id = id;
        this.symbol = symbol;
        this.name = name;
        this.playerType = playerType;
//        this.scanner = scanner; -> helps reduce declaring/initialising scanner everytime
        this.scanner = new Scanner(System.in);

    }

//    player will have a method called move, and he will make the move on the board

    public Move makeMove(Board board){
        System.out.println("Please enter the row for the move");
        int row = scanner.nextInt();

        System.out.println("Please enter the column for the move");
        int col = scanner.nextInt();

//        Code to validate the move

        if(row < 0 && row > board.getSize() && col < 0 && col > board.getSize()){
            throw new InvalidMoveException("The cell does not exist inside the board");
        }
        else{
            List<Cell> rows = board.getBoard().get(row);
            Cell cell = rows.get(col);
            if(cell.getCellState().equals(CellState.BLOCKED) || cell.getCellState().equals(CellState.FILLED)){
                throw new InvalidMoveException("This move is not allowed, since The cell is not empty");
            }
        }


//        Cell cell = new Cell (row,col,this);
//        return new Move(cell,this);
        return new Move(new Cell(row,col,this), this);
    }

//    All getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
