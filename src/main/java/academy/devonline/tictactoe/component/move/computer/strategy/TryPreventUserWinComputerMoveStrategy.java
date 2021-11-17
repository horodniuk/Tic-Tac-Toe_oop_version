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

import academy.devonline.tictactoe.model.GameTable;
import academy.devonline.tictactoe.model.Sign;

import static academy.devonline.tictactoe.model.Sign.O;
import static academy.devonline.tictactoe.model.Sign.X;

/**
 * @author Maksym Horodniuk
 * @link http://devonline.devonline.academy/java
 * tic-tac-toe
 */
public class TryPreventUserWinComputerMoveStrategy extends BaseComputerMoveStrategy implements ComputerMoveStrategy {

    @Override
    public boolean tryToMakeMove(final GameTable gameTable, Sign sign) {
        Sign opposerSign = null;
        if (sign == X) {
            opposerSign = O;
        }
        if (sign == O) {
            opposerSign = X;
        }

        return tryToMakeMove(sign, opposerSign, sign, gameTable, 2, 1);
    }
}
