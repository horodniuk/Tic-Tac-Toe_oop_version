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

import academy.devonline.tictactoe.model.Cell;
import academy.devonline.tictactoe.model.GameTable;

import java.util.Scanner;

/**
 * @author devonline
 * @link http://devonline.academy/java
 * tic-tac-toe
 */
public class UserMove {
    public void make(final GameTable gameTable) {
        while (true) {
            System.out.println("Please type number between 1 and 9:");
            String string = new Scanner(System.in).nextLine();
            if (string.length() == 1) {
                char digit = string.charAt(0);
                if (digit >= '0' && digit <= '9') {
                    if (makeUserMoveToCell(gameTable, digit)) {
                        return;
                    }
                }
            }
        }
    }

    private boolean makeUserMoveToCell(final GameTable gameTable, final char digit) {
        MappingTable mappingTable = new MappingTable();
        int mappingTableLength = mappingTable.getKeyboardLayoutMappingTable().length;

        for (int i = 0; i < mappingTableLength; i++) {
            for (int j = 0; j < 3; j++) {
                if (mappingTable.getKeyboardLayoutMappingTable()[i][j] == digit) {
                    Cell cell = new Cell(i, j);
                    if (gameTable.isEmpty(cell)) {
                        gameTable.setSign(cell, 'X');
                        return true;
                    } else {
                        System.out.println("Can't make a move, because the cell is not free! Try again!");
                        return false;
                    }
                }
            }
        }
        return false;
    }
}
