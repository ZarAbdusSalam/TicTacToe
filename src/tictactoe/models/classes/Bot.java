package tictactoe.models.classes;

import tictactoe.models.enums.BotDifficultyLevel;
import tictactoe.models.enums.PlayerType;
import tictactoe.strategies.botplayingstrategies.BotPlayerStrategy;

public class Bot extends Player{

    private BotDifficultyLevel botDifficultyLevel;
    private BotPlayerStrategy botPlayerStrategy;

//    Intellj automatically creates this super constructor, lets customise it
//    public Bot(Long id, Symbol symbol, String name, PlayerType playerType) {
//        super(id, symbol, name, playerType);
//    }


//    public Bot(Long id, Symbol symbol, String name, PlayerType playerType, BotDifficultyLevel botDifficultyLevel, BotPlayerStrategy botPlayerStrategy) {
    public Bot(Long id, Symbol symbol, String name, BotDifficultyLevel botDifficultyLevel, BotPlayerStrategy botPlayerStrategy) {

//        super(id, symbol, name, playerType);
        super(id, symbol, name, PlayerType.BOT);

        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayerStrategy = botPlayerStrategy;
    }

    public Move makeMove(Board board){
        Move move=botPlayerStrategy.makeMove(board); // gives the cell to which the bot can make the move based on difficulty level // move cell
        move.setPlayer(this);

        return move;
    }

    public BotDifficultyLevel getBotDifficultyLevel() {
        return botDifficultyLevel;
    }

    public void setBotDifficultyLevel(BotDifficultyLevel botDifficultyLevel) {
        this.botDifficultyLevel = botDifficultyLevel;
    }

    public BotPlayerStrategy getBotPlayerStrategy() {
        return botPlayerStrategy;
    }

    public void setBotPlayerStrategy(BotPlayerStrategy botPlayerStrategy) {
        this.botPlayerStrategy = botPlayerStrategy;
    }
}
