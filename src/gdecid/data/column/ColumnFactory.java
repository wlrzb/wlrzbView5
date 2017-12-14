package gdecid.data.column;

public class ColumnFactory {
	
	// �����µ�������
	public static final Column getColumn(Class type, int nrows, Object defaultValue) {
		return getColumn(type, nrows, nrows, defaultValue);
	}
	
	// �����µ�������
	public static final Column getColumn(Class type, int nrows, int nnz, Object defaultValue) {
		return new ObjectColumn(type, nrows, nrows, defaultValue);
	}
}
