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

import academy.devonline.tictactoe.component.CellVerifier;
import academy.devonline.tictactoe.component.DataPrinter;
import academy.devonline.tictactoe.component.Game;
import academy.devonline.tictactoe.component.WinnerVerifier;
import academy.devonline.tictactoe.component.convertor.DefaultDigitConvertor;
import academy.devonline.tictactoe.component.convertor.DigitConvertor;
import academy.devonline.tictactoe.component.move.computer.ComputerMove;
import academy.devonline.tictactoe.component.move.user.UserMove;
import academy.devonline.tictactoe.component.move.user.mapping.DesktopMappingTable;
import academy.devonline.tictactoe.component.move.user.mapping.MappingTable;

import static academy.devonline.tictactoe.model.PlayerType.COMPUTER;
import static academy.devonline.tictactoe.model.PlayerType.USER;
import static academy.devonline.tictactoe.model.Sign.O;
import static academy.devonline.tictactoe.model.Sign.X;

/**
 * @author Maksym Horodniuk
 * @link http://devonline.academy/java
 * tic-tac-toe
 */
public class GameFactory {
    PlayerType player1Type;

    PlayerType player2Type;

    public GameFactory(final String[] args) {
        PlayerType player1Type = null;
        PlayerType player2Type = null;
        for (final String arg : args) {
            if (USER.name().equalsIgnoreCase(arg) || COMPUTER.name().equalsIgnoreCase(arg)) {
                if (player1Type == null) {
                    player1Type = PlayerType.valueOf(arg.toUpperCase());
                } else if (player2Type == null) {
                    player2Type = PlayerType.valueOf(arg.toUpperCase());
                } else {
                    System.err.println("Unsupported command line argument: '" + arg + "'");
                }
            } else {
                System.err.println("Unsupported command line argument: '" + arg + "'");
            }
        }
        if (player1Type == null) {
            this.player1Type = USER;
            this.player2Type = COMPUTER;
        } else if (player2Type == null) {
            this.player1Type = USER;
            this.player2Type = player1Type;
        } else {
            this.player1Type = player1Type;
            this.player2Type = player2Type;
        }
    }


    public Game create() {
        final MappingTable mappingTable = new DesktopMappingTable();
        final DataPrinter dataPrinter = new DataPrinter();
        final DigitConvertor digitConvertor = new DefaultDigitConvertor();

        final Player player1;
        if (player1Type == USER) {
            player1 = new Player(X, new UserMove(mappingTable, dataPrinter, digitConvertor), "USER1");
        } else {
            player1 = new Player(X, new ComputerMove(), "COMP1");
        }
        final Player player2;
        if (player2Type == USER) {
            player2 = new Player(O, new UserMove(mappingTable, dataPrinter, digitConvertor), "USER2");
        } else {
            player2 = new Player(O, new ComputerMove(), "COMP2");
        }
        final boolean canSecondPlayerMakeFirstMove = player1Type != player2Type;
        return new Game(
                dataPrinter,
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
