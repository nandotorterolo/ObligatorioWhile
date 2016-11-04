package examples.while_ut1.ast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CheckStateLinter {
	public static ArrayList<String> errores = new ArrayList<String>();
	public Map<String,ObjectState> mapa = new HashMap<String,ObjectState>();
	
	public static void addError(String code, String msg, int line, int column) {
		errores.add(createErrorMsg(code, msg, line, column));
	}
	
	public static String createErrorMsg(String code, String msg, int line, int column) {
		return "Error " + code + ": " + msg + "." + " Line: " + line + ", Column: " + column;
	}
	
	public static void generateErrors(CheckStateLinter cslint) {
		for (Map.Entry<String, ObjectState> element : cslint.mapa.entrySet()) {
			boolean isFunction = element.getValue().queEs == 1;
			if (isFunction && !element.getValue().used) {
				FunctionDeclaration functionDeclaration = (FunctionDeclaration) element.getValue().astNode;
				addError("3", "funcion declarada sin llamar", functionDeclaration.line, functionDeclaration.column);
			}
		}
	}
}
