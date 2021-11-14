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

package main.java.academy.devonline.tictactoe;

import main.java.academy.devonline.tictactoe.component.CellVerifier;
import main.java.academy.devonline.tictactoe.component.DataPrinter;
import main.java.academy.devonline.tictactoe.component.Game;
import main.java.academy.devonline.tictactoe.component.WinnerVerifier;
import main.java.academy.devonline.tictactoe.component.convertor.DefaultDigitConvertor;
import main.java.academy.devonline.tictactoe.component.convertor.DigitConvertor;
import main.java.academy.devonline.tictactoe.component.move.computer.ComputerMove;
import main.java.academy.devonline.tictactoe.component.move.user.UserMove;
import main.java.academy.devonline.tictactoe.component.move.user.mapping.DesktopMappingTable;
import main.java.academy.devonline.tictactoe.component.move.user.mapping.MappingTable;

/**
 * @author devonline
 * @link http://devonline.main.java.devonline.academy/java
 * tic-tac-toe
 */
public final class Launcher {
    public static void main(final String[] args) {
        final MappingTable mappingTable = new DesktopMappingTable();
        final DataPrinter dataPrinter = new DataPrinter();
        final DigitConvertor digitConvertor = new DefaultDigitConvertor();
        Game game = new Game(
                dataPrinter,
                new ComputerMove(),
                new UserMove(mappingTable, dataPrinter, digitConvertor),
                new WinnerVerifier(),
                new CellVerifier(),
                mappingTable
        );
        game.play();
    }

}