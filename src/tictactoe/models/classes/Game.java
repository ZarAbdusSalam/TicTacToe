package tictactoe.models.classes;

import tictactoe.exceptions.DuplicateSymbolException;
import tictactoe.exceptions.InvalidDimensionException;
import tictactoe.exceptions.InvalidNumberOfPlayersException;
import tictactoe.models.enums.GameState;
import tictactoe.models.enums.PlayerType;
import tictactoe.strategies.winningstrategy.WinningStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Game {
    private List<Player> players;
    private Board board;
    private List<Move> moves;
    private Player winner;
    private GameState gameState;
    private int nextPlayerIndex;
    private List<WinningStrategy> winningStrategies;

//    public Game(List<Player> players, Board board, List<Move> moves, Player winner, GameState gameState, int nextPlayerIndex, List<WinningStrategy> winningStrategies) {
//    public Game(List<Player> players, Board board, List<Move> moves, Player winner, int nextPlayerIndex, List<WinningStrategy> winningStrategies) {
    private Game(List<Player> players, Board board, List<WinningStrategy> winningStrategies) {
        this.players = players;
        this.board = board;
//        this.moves = moves;
        this.moves = new ArrayList<Move>();
//        this.winner = winner;
//        this.gameState = gameState;
        this.gameState = GameState.IN_PROGRESS;
//        this.nextPlayerIndex = nextPlayerIndex;
        this.nextPlayerIndex = 0;
        this.winningStrategies = winningStrategies;
    }

//    Generate only getter methods, since we should be able to set through builder class

    public List<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public Player getWinner() {
        return winner;
    }

    public GameState getGameState() {
        return gameState;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public List<WinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public static Builder builder(){
        return new Builder();
    }

//    below is code for builder inner class, we need to create an outer class using above static method
    public static class Builder{
        private List<Player> players;
        private List<WinningStrategy> winningStrategies;
        private int dimension; //Board Size

//        public Builder(List<Player> players, List<WinningStrategy> winningStrategies, int dimension) {
//            this.players = players;
//            this.winningStrategies = winningStrategies;
//            this.dimension = dimension;
//        }

//        create constructor for builder, make it private, don't use inputs, initialize with some basic values, we will use setter methods to get the values

        private Builder() {
            this.players = new ArrayList<Player>();
            this.winningStrategies = new ArrayList<WinningStrategy>();
            this.dimension = 0;
        }

        public void setPlayers(List<Player> players) {
            this.players = players;
        }

        public void setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
        }

        public void setDimension(int dimension) {
            this.dimension = dimension;
        }

//        players and winning strategies are a list, lets give the user the option to add a single player and a single strategy

        public void addPlayer(Player player){
            players.add(player);
        }

        public void addWinningStrategies(WinningStrategy winningStrategy){
            winningStrategies.add(winningStrategy);
        }

//        code to validate bot count, there should be only 1 bot in a game

        private void validateBotCount(){
            int botCount=0;
            for (Player player: players) {
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    botCount++;
                }
            }

            if(botCount>1){
                throw new IndexOutOfBoundsException("BOT Count has exceeded 1");
            }
        }

//        Code to validate dimension, value should be 3-10

        private void validateDimension(){
            if(dimension<3 || dimension>10){
                throw new InvalidDimensionException("Dimension can either be more than 2 or less tah 11");
            }
        }

//        Code to validate no. of players, value should be boardSize / Dimension - 1

        private void validateNumberOfPlayers(){
            if(players.size() != dimension-1){
                throw new InvalidNumberOfPlayersException("Players should be 1 less than the dimension");
            }
        }

//        Code to validate duplicate symbols

        private void validateUniqueSymbolForAllPlayers(){

            HashSet<Character> set = new HashSet<>();

            for(Player player:players){
                set.add(player.getSymbol().getSymbolChar());
            }

            if(set.size()!= players.size()){
                throw new DuplicateSymbolException("Every player should have unique symbol");
            }
        }

//        Code to call all the above validate methods

        private void validate(){
            validateBotCount();
            validateDimension();
            validateNumberOfPlayers();
            validateUniqueSymbolForAllPlayers();
        }

//        Code for build method, which will actually create the game

        private Game build(){
            validate();
            return new Game(players,new Board(dimension), winningStrategies);
        }


    }


}
