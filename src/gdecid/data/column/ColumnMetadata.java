package gdecid.data.column;

import prefuse.data.Table;
import prefuse.util.collections.DefaultLiteralComparator;

public class ColumnMetadata {

    public ColumnMetadata(Table table, String column) {
        this(table, column, DefaultLiteralComparator.getInstance(), true);
    }
}
