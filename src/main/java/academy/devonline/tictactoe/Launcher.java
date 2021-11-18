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

package academy.devonline.tictactoe;

import academy.devonline.tictactoe.component.CellVerifier;
import academy.devonline.tictactoe.component.DataPrinter;
import academy.devonline.tictactoe.component.Game;
import academy.devonline.tictactoe.component.WinnerVerifier;
import academy.devonline.tictactoe.component.convertor.DefaultDigitConvertor;
import academy.devonline.tictactoe.component.convertor.DigitConvertor;
import academy.devonline.tictactoe.component.move.computer.ComputerMove;
import academy.devonline.tictactoe.component.move.user.mapping.DesktopMappingTable;
import academy.devonline.tictactoe.component.move.user.mapping.MappingTable;
import academy.devonline.tictactoe.model.Player;

import static academy.devonline.tictactoe.model.Sign.O;
import static academy.devonline.tictactoe.model.Sign.X;

/**
 * @author devonline
 * @link http://devonline.devonline.academy/java
 * tic-tac-toe
 */
public final class Launcher {
    public static void main(final String[] args) {
        final MappingTable mappingTable = new DesktopMappingTable();
        final DataPrinter dataPrinter = new DataPrinter();
        final DigitConvertor digitConvertor = new DefaultDigitConvertor();
        Game game = new Game(
                dataPrinter,
                //  new Player(O, new UserMove(mappingTable, dataPrinter, digitConvertor),  "I"),
                //  new Player(X, new UserMove(mappingTable, dataPrinter, digitConvertor),  "I2"),
                new Player(X, new ComputerMove(), "COMP"),
                new Player(O, new ComputerMove(), "COMP2"),
                new WinnerVerifier(),
                new CellVerifier(),
                mappingTable,
                true);
        game.play();
    }

}
