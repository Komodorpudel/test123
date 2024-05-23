package bp03;

public class      {

	public static void main(String[] args) {
		
		// TODO: Dieser Code ist nur ein Beispiel und muss geändert werden.
		String tableHeader = fillForTable("Name") + fillForTable("Typ 1")
				+ fillForTable("Typ 2");
		String headerLine = "--------------+---------------+---------------+ ";
		String examplePokemon = fillForTable("Bulbasaur") + fillForTable("Grass")
				+ fillForTable("Poison");
		
		System.out.println(tableHeader);
		System.out.println(headerLine);
		System.out.println(examplePokemon);
		
	}

	
	/**
	 * Kürzt einen {@link String} oder füllt ihn mit Leerzeichen auf, sodass er in einer
	 * Tabelle verwendet werden kann.
	 * 
	 * @param string der in der Tabelle verwendete String
	 * 
	 * @return
	 * 		ein {@link String}, der für eine Tabelle geeignet ist
	 */
	private static String fillForTable(String string) {
		
		final int columnWidth = 13;
		final String separator = " | ";
		String result = "";
		
		// Falls das Feld zu breit ist, wird es gekürzt.
		if(string.length() > columnWidth)
			result = string.substring(0, columnWidth - 3) + "...";
		
		// Falls das Feld nicht breit genug ist, werden Leerzeichen aufgefüllt.
		else {
			result = string;
			for(int i = 0; i < columnWidth - string.length(); i++)
				result += " ";
		}
		
		// Am Ende wird ein Trenner ergänzt.
		result += separator;
		return result;
		
	}

}
