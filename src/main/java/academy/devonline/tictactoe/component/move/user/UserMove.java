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

package academy.devonline.tictactoe.component.move.user;

import academy.devonline.tictactoe.component.DataPrinter;
import academy.devonline.tictactoe.component.UserInputReader;
import academy.devonline.tictactoe.component.move.Move;
import academy.devonline.tictactoe.model.game.Cell;
import academy.devonline.tictactoe.model.game.GameTable;
import academy.devonline.tictactoe.model.game.Sign;

/**
 * @author devonline
 * @link http://devonline.devonline.academy/java
 * tic-tac-toe
 */
public class UserMove implements Move {


    private final DataPrinter dataPrinter;

    private final UserInputReader userInputReader;

    public UserMove(final DataPrinter dataPrinter, final UserInputReader userInputReader) {
        this.dataPrinter = dataPrinter;
        this.userInputReader = userInputReader;
    }

    @Override
    public void make(final GameTable gameTable, Sign sign) {
        while (true) {
            final Cell cell = userInputReader.tryGetUserCell();
            if (gameTable.isEmpty(cell)) {
                gameTable.setSign(cell, sign);
                return;
            } else {
                dataPrinter.printNotEmptyCell();
            }
        }
    }


}
