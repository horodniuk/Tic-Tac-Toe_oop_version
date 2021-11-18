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

package academy.devonline.tictactoe.model;

import academy.devonline.tictactoe.component.*;
import academy.devonline.tictactoe.component.console.ConsoleDataPrinter;
import academy.devonline.tictactoe.component.console.ConsoleUserInputReader;
import academy.devonline.tictactoe.component.convertor.DefaultDigitConvertor;
import academy.devonline.tictactoe.component.convertor.DigitConvertor;
import academy.devonline.tictactoe.component.move.computer.ComputerMove;
import academy.devonline.tictactoe.component.move.user.UserMove;
import academy.devonline.tictactoe.component.move.user.mapping.DesktopMappingTable;
import academy.devonline.tictactoe.component.move.user.mapping.MappingTable;

import static academy.devonline.tictactoe.model.PlayerType.USER;
import static academy.devonline.tictactoe.model.Sign.O;
import static academy.devonline.tictactoe.model.Sign.X;

/**
 * @author Maksym Horodniuk
 * @link http://devonline.academy/java
 * tic-tac-toe
 */
public class GameFactory {
    private final PlayerType player1Type;

    private final PlayerType player2Type;

    public GameFactory(final String[] args) {
        final CommandLineArgumentParser.PlayerTypes playerTypes =
                new CommandLineArgumentParser(args).parse();
        this.player1Type = playerTypes.getPlayer1Type();
        this.player2Type = playerTypes.getPlayer2Type();
    }


    public Game create() {
        final MappingTable mappingTable = new DesktopMappingTable();
        final ConsoleDataPrinter consoleDataPrinter = new ConsoleDataPrinter();
        final DigitConvertor digitConvertor = new DefaultDigitConvertor();
        final UserInputReader userInputReader = new ConsoleUserInputReader(mappingTable, consoleDataPrinter, digitConvertor);
        final Player player1;


        if (player1Type == USER) {
            player1 = new Player(X, new UserMove(consoleDataPrinter, userInputReader), "USER1");
        } else {
            player1 = new Player(X, new ComputerMove(), "COMP1");
        }
        final Player player2;
        if (player2Type == USER) {
            player2 = new Player(O, new UserMove(consoleDataPrinter, userInputReader), "USER2");
        } else {
            player2 = new Player(O, new ComputerMove(), "COMP2");
        }
        final boolean canSecondPlayerMakeFirstMove = player1Type != player2Type;
        return new Game(
                consoleDataPrinter,
                //  new Player(O, new UserMove(mappingTable, dataPrinter, digitConvertor),  "I"),
                //  new Player(X, new UserMove(mappingTable, dataPrinter, digitConvertor),  "I2"),
                // new Player(X, new ComputerMove(), "COMP1"),
                // new Player(O, new ComputerMove(), "COMP2"),
                player1,
                player2,
                new WinnerVerifier(),
                new CellVerifier(),
                mappingTable,
                true);
    }


}
