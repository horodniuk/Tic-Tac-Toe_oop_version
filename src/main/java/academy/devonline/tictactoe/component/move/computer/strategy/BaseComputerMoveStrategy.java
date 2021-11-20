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

package academy.devonline.tictactoe.component.move.computer.strategy;

import academy.devonline.tictactoe.component.move.computer.strategy.bydirection.*;
import academy.devonline.tictactoe.model.game.GameTable;
import academy.devonline.tictactoe.model.game.Sign;

/**
 * @author Maksym Horodniuk
 * @link http://devonline.devonline.academy/java
 * tic-tac-toe
 */
public class BaseComputerMoveStrategy {

    private final MakeMoveStrategyByDirection[] strategyByDirections = {
            new MakeMoveStrategyByDirectionHorizontal(),
            new MakeMoveStrategyByDirectionVertical(),
            new MakeMoveStrategyByDirectionDiagonal1(),
            new MakeMoveStrategyByDirectionDiagonal2(),
    };

    protected boolean tryToMakeMove(
            final Sign playerSign,
            final Sign searchSymbol,
            final Sign skipSymbol,
            final GameTable gameTable,
            final int expectedSearchSymbolCount,
            final int expectedEmptyCount) {

        for (final MakeMoveStrategyByDirection makeMoveStrategyByDirection : strategyByDirections) {
            if (makeMoveStrategyByDirection.tryToMakeMoveByDirection(
                    playerSign,
                    searchSymbol,
                    skipSymbol,
                    gameTable,
                    expectedSearchSymbolCount,
                    expectedEmptyCount
            )) {
                return true;
            }
        }
        return false;
    }


}
