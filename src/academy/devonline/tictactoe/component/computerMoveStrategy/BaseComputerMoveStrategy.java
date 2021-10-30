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

package academy.devonline.tictactoe.component.computerMoveStrategy;

import academy.devonline.tictactoe.model.Cell;
import academy.devonline.tictactoe.model.GameTable;

/**
 * @author Maksym Horodniuk
 * @link http://devonline.academy/java
 * tic-tac-toe
 */
public class BaseComputerMoveStrategy {


    protected boolean tryToMakeMove(final char searchSymbol,
                                    final char skipSymbol,
                                    final GameTable gameTable,
                                    final int expectedSearchSymbolCount,
                                    final int expectedEmptyCount
    ) {
        if (tryToMakeMoveByHorizontal(searchSymbol, skipSymbol, gameTable, expectedSearchSymbolCount, expectedEmptyCount)) {
            return true;
        }
        if (tryToMakeMoveByVertical(searchSymbol, skipSymbol, gameTable, expectedSearchSymbolCount, expectedEmptyCount)) {
            return true;
        }
        if (tryToMakeMoveByDiagonal1(searchSymbol, skipSymbol, gameTable, expectedSearchSymbolCount, expectedEmptyCount)) {
            return true;
        }
        return tryToMakeMoveByDiagonal2(searchSymbol, skipSymbol, gameTable, expectedSearchSymbolCount, expectedEmptyCount);
    }


    private boolean tryToMakeMoveByHorizontal(final char searchSymbol,
                                              final char skipSymbol,
                                              final GameTable gameTable,
                                              final int expectedSearchSymbolCount,
                                              final int expectedEmptyCount) {
        for (int i = 0; i < 3; i++) {
            int mooveIndex = 0;
            int empty = 0;
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (gameTable.getSign(new Cell(i, j)) == skipSymbol) {
                    break;
                }
                if (gameTable.getSign(new Cell(i, j)) == ' ') {
                    mooveIndex = j;
                    empty++;
                }
                if (gameTable.getSign(new Cell(i, j)) == searchSymbol) {
                    count++;
                }
            }
            if (count == expectedSearchSymbolCount && empty == expectedEmptyCount) {
                gameTable.setSign(new Cell(i, mooveIndex), '0');
                return true;
            }
        }
        return false;

    }

    private boolean tryToMakeMoveByVertical(final char searchSymbol,
                                            final char skipSymbol,
                                            final GameTable gameTable,
                                            final int expectedSearchSymbolCount,
                                            final int expectedEmptyCount) {
        for (int i = 0; i < 3; i++) {
            int mooveIndex = 0;
            int empty = 0;
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (gameTable.getSign(new Cell(j, i)) == skipSymbol) {
                    break;
                }
                if (gameTable.getSign(new Cell(j, i)) == ' ') {
                    mooveIndex = j;
                    empty++;
                }
                if (gameTable.getSign(new Cell(j, i)) == searchSymbol) {
                    count++;
                }
            }
            if (count == expectedSearchSymbolCount && empty == expectedEmptyCount) {
                gameTable.setSign(new Cell(mooveIndex, i), '0');
                return true;
            }

        }
        return false;
    }

    private boolean tryToMakeMoveByDiagonal1(final char searchSymbol,
                                             final char skipSymbol,
                                             final GameTable gameTable,
                                             final int expectedSearchSymbolCount,
                                             final int expectedEmptyCount) {
        for (int i = 0; i < 1; i++) {
            int mooveIndex = 0;
            int empty = 0;
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (gameTable.getSign(new Cell(j, j)) == skipSymbol) {
                    break;
                }
                if (gameTable.getSign(new Cell(j, j)) == ' ') {
                    mooveIndex = j;
                    empty++;
                }
                if (gameTable.getSign(new Cell(j, j)) == searchSymbol) {
                    count++;
                }
            }
            if (count == expectedSearchSymbolCount && empty == expectedEmptyCount) {
                gameTable.setSign(new Cell(mooveIndex, mooveIndex), '0');
                return true;
            }
        }
        return false;
    }

    private boolean tryToMakeMoveByDiagonal2(final char searchSymbol,
                                             final char skipSymbol,
                                             final GameTable gameTable,
                                             final int expectedSearchSymbolCount,
                                             final int expectedEmptyCount) {
        for (int i = 0; i < 1; i++) {
            int backUpwards = 2;
            int mooveIndex = 0;
            int mooveIndexSecond = 0;
            int empty = 0;
            int count = 0;

            for (int j = 0; j < 3; j++) {
                if (gameTable.getSign(new Cell(j, backUpwards)) == skipSymbol) {
                    break;
                }
                if (gameTable.getSign(new Cell(j, backUpwards)) == ' ') {
                    mooveIndex = backUpwards;
                    mooveIndexSecond = j;
                    empty++;
                }
                if (gameTable.getSign(new Cell(j, backUpwards)) == searchSymbol) {
                    count++;
                }
                if (j < 2) {
                    backUpwards--;
                }
            }
            if (count == expectedSearchSymbolCount && empty == expectedEmptyCount) {
                gameTable.setSign(new Cell(mooveIndexSecond, mooveIndex), '0');
                return true;
            }
        }
        return false;
    }

}
