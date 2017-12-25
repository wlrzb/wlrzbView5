package gdecid.data.tuple;

import gdecid.data.Graph;
import gdecid.data.Table;
import gdecid.data.Tuple;

public class TableTuple implements Tuple{

    protected Table m_table;
    protected int m_row;
	
    protected void init(Table table, Graph m_graph, int row) {
	m_table = table;
	m_row = row;
    }
}
