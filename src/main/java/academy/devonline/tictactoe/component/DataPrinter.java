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

import academy.devonline.tictactoe.component.move.user.mapping.MappingTable;
import academy.devonline.tictactoe.model.Cell;
import academy.devonline.tictactoe.model.GameTable;

/**
 * @author devonline
 * @link http://devonline.devonline.academy/java
 * tic-tac-toe
 */
public class DataPrinter {
    public void printGameTable(GameTable gameTable) {
        for (int i = 0; i < 3; i++) {
            System.out.println("----------");
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + gameTable.getSign(new Cell(i, j)) + " ");
            }
            System.out.println("|");
        }
        System.out.println("----------");
    }

    public void printGameTable(MappingTable mappingTable) {
        for (int i = 0; i < 3; i++) {
            System.out.println("----------");
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + mappingTable.getSign(new Cell(i, j)) + " ");
            }
            System.out.println("|");
        }
        System.out.println("----------");
    }


    public void printInstructionMessage() {
        System.out.println("Use the following mapping table to specify a cell using numbers from 1 to 9:");
    }

    public void printInputInstruction() {
        System.out.println("Please type number between 1 and 9:");
    }

    public void printNotEmptyCell() {
        System.out.println("Can't make a move, because the cell is not free! Try again!");
    }

    public void printUserWin() {
        System.out.println("YOU WIN!");
    }

    public void printComputerWin() {
        System.out.println("COMPUTER WIN!");
    }

    public void printDraw() {
        System.out.println("Sorry, DRAW!");
    }

    public void printGameOver() {
        System.out.println("GAME OVER!");
    }
}
