package gdecid.data.column;

public class ColumnFactory {
	
	public static final Column getColumn(Class type, int nrows, Object defaultValue) {
		return getColumn(type, nrows, nrows, defaultValue);
	}
	
	public static final Column getColumn(Class type, int nrows, int nnz, Object defaultValue) {
		if (type == byte.class) {
			byte def = ((Number)defaultValue).byteValue();
			return new ByteColumn(nrows, nrows, def);
		}
		if (type == int.class) {
			int def = ((Number)defaultValue).intValue();
			return new IntColumn(nrows, nrows, def);
		}
	}
}
