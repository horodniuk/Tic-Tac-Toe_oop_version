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

package main.java.academy.devonline.tictactoe.component.move.computer;


import main.java.academy.devonline.tictactoe.component.move.computer.strategy.*;
import main.java.academy.devonline.tictactoe.model.GameTable;

/**
 * @author devonline
 * @link http://devonline.main.java.devonline.academy/java
 * tic-tac-toe
 */
public class ComputerMove {
    private final ComputerMoveStrategy[] strategies = {
            new TryToWinComputerMoveStrategy(),
            new TryPreventUserWinComputerMoveStrategy(),
            new TryToMakeMoveToCenterComputerMoveStrategy(),
            new TryToMakeNearestMoveComputerMoveStrategy(),
            new RandomComputerMoveStrategy(),
    };

    public void make(final GameTable gameTable) {
        for (final ComputerMoveStrategy strategy : strategies) {
            if (strategy.tryToMakeMove(gameTable)) {
                return;
            }
        }
        // TODO Throw Error
    }

}