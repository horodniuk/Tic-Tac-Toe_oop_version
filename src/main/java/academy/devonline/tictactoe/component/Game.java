/*
 * Copyright (c) 2019. http://devonline.academy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package academy.devonline.tictactoe.component;

import academy.devonline.tictactoe.component.console.ConsoleDataPrinter;
import academy.devonline.tictactoe.component.move.user.mapping.MappingTable;
import academy.devonline.tictactoe.model.GameTable;
import academy.devonline.tictactoe.model.Player;

import java.util.Random;

/**
 * @author devonline
 * @link http://devonline.devonline.academy/java
 * tic-tac-toe
 */
public class Game {
    private final ConsoleDataPrinter consoleDataPrinter;

    private Player player1;
    private Player player2;

/*    private final ComputerMove computerMove;

    private final UserMove userMove;*/

    private final WinnerVerifier winnerVerifier;

    private final CellVerifier cellVerifier;

    private final MappingTable mappingTable;

    private final boolean canSecondPlayerMakeFirstMove;

    public Game(final ConsoleDataPrinter consoleDataPrinter,
                final Player player1,
                final Player player2,
        /*        final ComputerMove computerMove,
                final UserMove userMove,*/
                final WinnerVerifier winnerVerifier,
                final CellVerifier cellVerifier,
                final MappingTable mappingTable,
                final boolean canSecondPlayerMakeFirstMove) {
        this.consoleDataPrinter = consoleDataPrinter;
        this.player1 = player1;
        this.player2 = player2;
/*        this.computerMove = computerMove;
        this.userMove = userMove;*/
        this.winnerVerifier = winnerVerifier;
        this.cellVerifier = cellVerifier;
        this.mappingTable = mappingTable;
        this.canSecondPlayerMakeFirstMove = canSecondPlayerMakeFirstMove;
    }

    /*  public Game(final DataPrinter dataPrinter,
                final ComputerMove computerMove,
                final UserMove userMove,
                final WinnerVerifier winnerVerifier,
                final CellVerifier cellVerifier,
                final MappingTable mappingTable) {
        this.dataPrinter = dataPrinter;
        this.computerMove = computerMove;
        this.userMove = userMove;
        this.winnerVerifier = winnerVerifier;
        this.cellVerifier = cellVerifier;
        this.mappingTable = mappingTable;
    }*/

    public void play() {
        consoleDataPrinter.printInstructionMessage();

        final GameTable gameTable = new GameTable();
        consoleDataPrinter.printGameTable(mappingTable);
        if (canSecondPlayerMakeFirstMove && new Random().nextBoolean()) {
            player2.makeMove(gameTable);
            consoleDataPrinter.printGameTable(gameTable);
        }

        final Player[] players = {player1, player2};
        while (true) {

            for (Player player : players) {
                player.makeMove(gameTable);
                consoleDataPrinter.printGameTable(gameTable);
                if (winnerVerifier.isWin(gameTable, player)) {
                    consoleDataPrinter.printWinner(player.getName());
                    consoleDataPrinter.printGameOver();
                    return;
                }
                if (cellVerifier.allCellsFilled(gameTable)) {
                    consoleDataPrinter.printDraw();
                    break;
                }
            }
        }


    }
}
