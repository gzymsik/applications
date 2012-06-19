
public class Excel {

	private int calculateExcelColumnNumber(String columnName) {
		int result = 0;
		
		columnName.length();
		int power = 1; 
		for(int i = columnName.length() - 1; i >= 0; i--) {
			result += (columnName.charAt(i) - 'A' + 1) * power;
			power *= 26;
		}
		
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Excel excel = new Excel();
		System.out.println(excel.calculateExcelColumnNumber("AZ"));
	}

}
