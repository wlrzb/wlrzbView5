package gdecid.data.column;

public abstract class AbstractColumn implements Column {
	
	protected Object       m_defaultValue;
	
    public void setDouble(double val, int row) {
            set(new Double(val), row);
    }
	
}
