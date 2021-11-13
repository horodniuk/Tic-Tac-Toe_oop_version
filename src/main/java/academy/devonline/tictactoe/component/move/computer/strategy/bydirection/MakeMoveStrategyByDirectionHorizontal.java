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

package main.java.academy.devonline.tictactoe.component.move.computer.strategy.bydirection;

import main.java.academy.devonline.tictactoe.model.Cell;
import main.java.academy.devonline.tictactoe.model.GameTable;

/**
 * @author Maksym Horodniuk
 * @link http://devonline.main.java.devonline.academy/java
 * tic-tac-toe
 */
public class MakeMoveStrategyByDirectionHorizontal implements MakeMoveStrategyByDirection {

    @Override
    public boolean tryToMakeMoveByDirection(final char searchSymbol, final char skipSymbol, final GameTable gameTable, final int expectedSearchSymbolCount, final int expectedEmptyCount) {
        for (int i = 0; i < 3; i++) {
            int mooveIndex = 0;
            int empty = 0;
            int count = 0;
            for (int j = 0; j < 3; j++) {
                final Cell cell = new Cell(i, j);
                final char realSign = gameTable.getSign(cell);
                if (realSign == skipSymbol) {
                    break;
                }
                if (gameTable.isEmpty(cell)) {
                    mooveIndex = j;
                    empty++;
                }
                if (realSign == searchSymbol) {
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
}
