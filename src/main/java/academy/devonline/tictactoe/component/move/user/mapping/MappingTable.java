package academy.devonline.tictactoe.component.move.user.mapping;

import academy.devonline.tictactoe.model.game.Cell;

import java.util.Arrays;

/**
 * @author devonline
 * @link http://devonline.devonline.academy/java
 */
public class MappingTable {
    private final char[][] table;

    protected MappingTable(final char[][] table) {
        this.table = table;
    }

    public char getSign(final Cell cell) {
        return table[cell.getRow()][cell.getCol()];
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MappingTable{");
        sb.append("table=");
        for (int i = 0; i < table.length; i++) {
            sb.append(Arrays.toString(table[i]));
            if (i < table.length - 1) {
                sb.append(';');
            }
        }
        sb.append('}');
        return sb.toString();
    }
}
