package examples.while_ut1.ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CheckStateLinter {
	public static ArrayList<String> errores = new ArrayList<String>();
	public Map <String,ObjectState> mapa = new HashMap<String,ObjectState>();
	
	public static void addError(String code, String msg, int line, int column) {
		errores.add("Error " + code + ": " + msg + "." + " Line: " + line + ", Column: " + column);
	}
}
