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
import academy.devonline.tictactoe.component.console.ConsolePrintGameOver;
import academy.devonline.tictactoe.component.console.ConsoleUserInputReader;
import academy.devonline.tictactoe.component.convertor.DefaultDigitConvertor;
import academy.devonline.tictactoe.component.convertor.DigitConvertor;
import academy.devonline.tictactoe.component.move.computer.ComputerMove;
import academy.devonline.tictactoe.component.move.user.UserMove;
import academy.devonline.tictactoe.component.move.user.mapping.DesktopMappingTable;
import academy.devonline.tictactoe.component.move.user.mapping.MappingTable;
import academy.devonline.tictactoe.component.swing.GameWindow;

import static academy.devonline.tictactoe.model.PlayerType.USER;
import static academy.devonline.tictactoe.model.Sign.O;
import static academy.devonline.tictactoe.model.Sign.X;
import static academy.devonline.tictactoe.model.UserInterface.GUI;

/**
 * @author Maksym Horodniuk
 * @link http://devonline.academy/java
 * tic-tac-toe
 */
public class GameFactory {
    private final PlayerType player1Type;

    private final PlayerType player2Type;
    private final UserInterface userInterface;
    private GameOverHandling gameOverHandling;

    public GameFactory(final String[] args) {
        final CommandLineArgumentParser.ComandLineArguments comandLineArguments =
                new CommandLineArgumentParser(args).parse();
        player1Type = comandLineArguments.getPlayer1Type();
        player2Type = comandLineArguments.getPlayer2Type();
        userInterface = comandLineArguments.getUserInterface();
    }


    public Game create() {

        final DataPrinter dataPrinter;
        final UserInputReader userInputReader;

        if (userInterface == GUI) {
            final GameWindow gameWindow = new GameWindow();
            dataPrinter = gameWindow;
            userInputReader = gameWindow;
            gameOverHandling = gameWindow;
        } else {
            final MappingTable mappingTable = new DesktopMappingTable();
            final DigitConvertor digitConvertor = new DefaultDigitConvertor();
            dataPrinter = new ConsoleDataPrinter();
            userInputReader = new ConsoleUserInputReader(mappingTable, dataPrinter, digitConvertor);
            gameOverHandling = new ConsolePrintGameOver(dataPrinter);
        }


        final Player player1;
        if (player1Type == USER) {
            player1 = new Player(X, new UserMove(dataPrinter, userInputReader), "USER");
        } else {
            player1 = new Player(X, new ComputerMove(), "COMPUTER");
        }
        final Player player2;
        if (player2Type == USER) {
            player2 = new Player(O, new UserMove(dataPrinter, userInputReader), "USER");
        } else {
            player2 = new Player(O, new ComputerMove(), "COMPUTER");
        }
        final boolean canSecondPlayerMakeFirstMove = player1Type != player2Type;
        return new Game(
                dataPrinter,
                player1,
                player2,
                new WinnerVerifier(),
                new CellVerifier(),
                gameOverHandling,
                canSecondPlayerMakeFirstMove);
    }


}
