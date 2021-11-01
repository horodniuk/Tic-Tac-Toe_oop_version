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

package academy.devonline.tictactoe.component.move.computer.strategy.bydirection;

import academy.devonline.tictactoe.model.Cell;
import academy.devonline.tictactoe.model.GameTable;

/**
 * @author Maksym Horodniuk
 * @link http://devonline.academy/java
 * tic-tac-toe
 */
public class MakeMoveStrategyByDirectionDiagonal1 implements MakeMoveStrategyByDirection {
    @Override
    public boolean tryToMakeMoveByDirection(final char searchSymbol, final char skipSymbol, final GameTable gameTable, final int expectedSearchSymbolCount, final int expectedEmptyCount) {
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
}
