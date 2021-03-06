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
import academy.devonline.tictactoe.component.move.user.mapping.MappingTable;
import academy.devonline.tictactoe.model.game.Cell;
import academy.devonline.tictactoe.model.game.GameTable;

/**
 * @author devonline
 * @link http://devonline.devonline.academy/java
 * tic-tac-toe
 */
public class ConsoleDataPrinter implements DataPrinter {

    public void printGameTable(GameTable gameTable) {
        print((i, j) -> String.valueOf(gameTable.getSign(new Cell(i, j))));
    }

    private void print(PrintTable printTable) {
        for (int i = 0; i < 3; i++) {
            System.out.println("----------");
            for (int j = 0; j < 3; j++) {
                System.out.print("|" + printTable.getPrintTable(i, j) + " ");
            }
            System.out.println("|");
        }
        System.out.println("----------");
    }

    @FunctionalInterface
    private interface PrintTable {
        String getPrintTable(int i, int j);
    }


    public void printInstructionMessage(MappingTable mappingTable) {
        System.out.println("Use the following mapping table to specify a cell using numbers from 1 to 9:");
        print((i, j) -> String.valueOf(mappingTable.getSign(new Cell(i, j))));


    }

    public void printInstructionInput() {
        System.out.println("Please type number between 1 and 9:");
    }

    public void printNotEmptyCell() {
        System.out.println("Can't make a move, because the cell is not free! Try again!");
    }


    public void printWinner(String player) {
        System.out.println(player + " WIN!");
    }

    @Override
    public void printDraw() {
        System.out.println("Sorry, DRAW!");
    }

    @Override
    public void printInfoMessage(final String message) {
        System.out.println(message);
    }


}
