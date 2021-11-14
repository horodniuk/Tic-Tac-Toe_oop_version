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

package main.java.academy.devonline.tictactoe.component.convertor;

import main.java.academy.devonline.tictactoe.component.move.user.mapping.MappingTable;
import main.java.academy.devonline.tictactoe.model.Cell;


/**
 * @author Maksym Horodniuk
 * @link http://devonline.main.java.devonline.academy/java
 * tic-tac-toe
 */
public class DefaultDigitConvertor implements DigitConvertor {
    @Override
    public Cell convertDigitToCell(final MappingTable mappingTable, final char digit) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (mappingTable.getSign(new Cell(i, j)) == digit) {
                    return new Cell(i, j);
                }
            }
        }
        return null;
    }
}