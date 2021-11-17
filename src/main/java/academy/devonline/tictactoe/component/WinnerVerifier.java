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

import academy.devonline.tictactoe.component.winner.strategy.*;
import academy.devonline.tictactoe.model.GameTable;
import academy.devonline.tictactoe.model.Sign;

import static academy.devonline.tictactoe.model.Sign.O;
import static academy.devonline.tictactoe.model.Sign.X;

/**
 * @author devonline
 * @link http://devonline.devonline.academy/java
 * tic-tac-toe
 */
public class WinnerVerifier {

    private final WinnerVerifierStrategy[] winnerVerifierStrategies = {
            new WinnerVerifierStrategyByCols(),
            new WinnerVerifierStrategyByRows(),
            new WinnerVerifierStrategyByDiagonal(),
            new WinnerVerifierStrategyByDiagonal2(),
    };

    public boolean isComputerWin(final GameTable gameTable) {
        return isWin(gameTable, O);
    }

    public boolean isUserWin(final GameTable gameTable) {
        return isWin(gameTable, X);
    }

    private boolean isWin(final GameTable gameTable, final Sign sing) {
        for (final WinnerVerifierStrategy winnerVerifierStrategy : winnerVerifierStrategies) {
            if (winnerVerifierStrategy.isWinner(gameTable, sing)) {
                return true;
            }
        }
        return false;
    }

}
