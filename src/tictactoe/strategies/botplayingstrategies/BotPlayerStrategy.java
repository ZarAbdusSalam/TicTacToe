package tictactoe.strategies.botplayingstrategies;

import tictactoe.models.classes.Board;
import tictactoe.models.classes.Move;

public interface BotPlayerStrategy {

    Move makeMove(Board board);
}
