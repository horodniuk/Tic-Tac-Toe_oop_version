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

package main.java.academy.devonline.tictactoe.component.move.user;

import main.java.academy.devonline.tictactoe.component.DataPrinter;
import main.java.academy.devonline.tictactoe.component.convertor.DigitConvertor;
import main.java.academy.devonline.tictactoe.component.move.user.mapping.MappingTable;
import main.java.academy.devonline.tictactoe.model.Cell;
import main.java.academy.devonline.tictactoe.model.GameTable;

import java.util.Scanner;

/**
 * @author devonline
 * @link http://devonline.main.java.devonline.academy/java
 * tic-tac-toe
 */
public class UserMove {

    private final MappingTable mappingTable;

    private final DataPrinter dataPrinter;

    private final DigitConvertor digitConvertor;

    public UserMove(final MappingTable mappingTable,
                    final DataPrinter dataPrinter,
                    final DigitConvertor digitConvertor) {
        this.mappingTable = mappingTable;
        this.dataPrinter = dataPrinter;
        this.digitConvertor = digitConvertor;
    }

    public void make(final GameTable gameTable) {
        while (true) {
            final Cell cell = tryGetUserCell();
            if (gameTable.isEmpty(cell)) {
                gameTable.setSign(cell, 'x');
                return;
            } else {
                dataPrinter.printNotEmptyCell();
            }
        }
    }

    private Cell tryGetUserCell() {
        while (true) {
            dataPrinter.printInputInstruction();
            final String userInput = new Scanner(System.in).nextLine();
            if (userInput.length() == 1) {
                final char digit = userInput.charAt(0);
                if (digit >= '1' && digit <= '9') {
                    return digitConvertor.convertDigitToCell(mappingTable, digit);
                }
            }
        }
    }


}
