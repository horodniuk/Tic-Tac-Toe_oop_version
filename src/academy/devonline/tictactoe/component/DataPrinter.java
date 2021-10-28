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

/**
 * @author devonline
 * @link http://devonline.academy/java
 * tic-tac-toe
 */
public class DataPrinter {
    public void printMappingTable() {
        MappingTable mappingTable = new MappingTable();
        printGameTable(new MappingTable());
    }

    public void printGameTable( GameTable gameTable) {

        for (int i = 0; i < 3; i++) {
            System.out.println("----------");
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + gameTable.getSign(new Cell(i, j))+ " ");
            }
            System.out.println("|");
        }
        System.out.println("----------");
    }


    public void printGameTableMessageUserMoveInstructionMapping() {
        System.out.println("Use the following mapping table to specify a cell using numbers from 1 to 9:");
    }

    public void printGameTableMessageUserMoveInstruction() {
        System.out.println("Please type number between 1 and 9:");
    }

    public void updateMoveCellIsNotFree() {
        System.out.println("Can't make a move, because the cell is not free! Try again!");
    }

    public void printGameTableMessageUserWin() {
        System.out.println("YOU WIN!");
    }

    public void printGameTableMessageComputerWin() {
        System.out.println("COMPUTER WIN!");
    }

    public void printGameTableMessageGameDraw() {
        System.out.println("Sorry, DRAW!");
    }

    public void printGameTableMessageGameOver() {
        System.out.println("GAME OVER!");
    }


}
