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

import academy.devonline.tictactoe.component.move.Move;
import academy.devonline.tictactoe.component.move.computer.ComputerMove;
import academy.devonline.tictactoe.component.move.user.UserMove;
import academy.devonline.tictactoe.component.move.user.mapping.MappingTable;
import academy.devonline.tictactoe.model.GameTable;

import java.util.Random;

/**
 * @author devonline
 * @link http://devonline.devonline.academy/java
 * tic-tac-toe
 */
public class Game {
    private final DataPrinter dataPrinter;

    private final ComputerMove computerMove;

    private final UserMove userMove;

    private final WinnerVerifier winnerVerifier;

    private final CellVerifier cellVerifier;

    private final MappingTable mappingTable;

    public Game(final DataPrinter dataPrinter,
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
    }

    public void play() {
        dataPrinter.printInstructionMessage();

        final GameTable gameTable = new GameTable();
        dataPrinter.printGameTable(mappingTable);
        if (new Random().nextBoolean()) {
            computerMove.make(gameTable);
            dataPrinter.printGameTable(gameTable);
        }

        final Move[] moves = {userMove, computerMove};
        while (true) {

            for (final Move move : moves) {
                move.make(gameTable);
                dataPrinter.printGameTable(gameTable);
                if (move instanceof UserMove) {
                    if (winnerVerifier.isUserWin(gameTable)) {
                        dataPrinter.printUserWin();
                        dataPrinter.printGameOver();
                        return;
                    }
                } else {
                    if (winnerVerifier.isComputerWin(gameTable)) {
                        dataPrinter.printComputerWin();
                        dataPrinter.printGameOver();
                        return;
                    }
                }
            }
            if (cellVerifier.allCellsFilled(gameTable)) {
                dataPrinter.printDraw();
                break;
            }
        }

    }
}
