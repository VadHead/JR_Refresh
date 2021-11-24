package level09;

public class task1901 {
	public static void main(String[] args) {
		//это пример вывода
		ATable aTable = new ATable() {
			@Override
			public String getCurrentUserName() {
				return "Amigo";
			}
			
			@Override
			public String getTableName() {
				return "DashboardTable";
			}
		};
		
		BTable table = new TableAdapter(aTable);
		System.out.println(table.getHeaderText());
	}
	
	public static class TableAdapter implements BTable{
		
		private ATable aTable;
		
		public TableAdapter(ATable table) {
			this.aTable = table;
		}
		
		@Override
		public String getHeaderText() {
			return String.format("[%s] : %s", aTable.getCurrentUserName(), aTable.getTableName());
		}
		
	}
	
	public interface ATable {
		String getCurrentUserName();
		
		String getTableName();
	}
	
	public interface BTable {
		String getHeaderText();
	}
}
