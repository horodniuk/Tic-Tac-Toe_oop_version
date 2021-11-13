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

package main.java.tictactoe.component.move.computer.strategy;

import main.java.tictactoe.model.Cell;
import main.java.tictactoe.model.GameTable;

/**
 * @author Maksym Horodniuk
 * @link http://devonline.academy/java
 * tic-tac-toe
 */
public class TryToMakeMoveToCenterComputerMoveStrategy implements ComputerMoveStrategy {
    @Override
    public boolean tryToMakeMove(final GameTable gameTable) {
        Cell centerCell = new Cell(1, 1);
        if (gameTable.isEmpty(centerCell)) {
            gameTable.setSign(centerCell, '0');
            return true;
        }
        return false;
    }
}
