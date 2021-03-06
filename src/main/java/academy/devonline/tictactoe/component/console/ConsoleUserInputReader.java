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

package academy.devonline.tictactoe.component.console;

import academy.devonline.tictactoe.component.DataPrinter;
import academy.devonline.tictactoe.component.UserInputReader;
import academy.devonline.tictactoe.component.console.convertor.DigitConvertor;
import academy.devonline.tictactoe.model.game.Cell;

import java.util.Scanner;

/**
 * @author Maksym Horodniuk
 * @link http://devonline.academy/java
 * tic-tac-toe
 */
public class ConsoleUserInputReader implements UserInputReader {


    private final DataPrinter dataPrinter;

    private final DigitConvertor digitConvertor;

    public ConsoleUserInputReader(final DataPrinter dataPrinter,
                                  final DigitConvertor digitConvertor) {
        this.dataPrinter = dataPrinter;
        this.digitConvertor = digitConvertor;
    }

    @Override
    public Cell tryFreeCell() {
        while (true) {
            dataPrinter.printInstructionInput();
            final String userInput = new Scanner(System.in).nextLine();
            if (userInput.length() == 1) {
                final char digit = userInput.charAt(0);
                if (digit >= '1' && digit <= '9') {
                    return digitConvertor.convertDigitToCell(digit);
                }
            }
        }
    }
}
