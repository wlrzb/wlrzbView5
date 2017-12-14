package gdecid.data.column;

public class ColumnFactory {
	
	// 创建新的数据列
	public static final Column getColumn(Class type, int nrows, Object defaultValue) {
		return getColumn(type, nrows, nrows, defaultValue);
	}
	
	// 创建新的数据列
	public static final Column getColumn(Class type, int nrows, int nnz, Object defaultValue) {
		return new ObjectColumn(type, nrows, nrows, defaultValue);
	}
}
