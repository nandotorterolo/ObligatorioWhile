package ucu.ast;

import java.util.*;

/** RepresentaciÃ³n de las asignaciones de valores a variables.
 */
public class FunctionDeclaration extends Stmt {
	public final String id;
	public final String type;
	public final LinkedHashMap<String, String> parameters;
	public final Stmt body;

	//hay que clonar el estado para guardar las variables locales de la funicón

	public FunctionDeclaration(String id, String type,
			LinkedHashMap<String, String> parameters,Stmt body,
			int line, int column) {
		this.id = id;
		this.type = type;
		this.parameters=parameters;
		this.body=body;
		this.line = line;
		this.column = column;
	}

	@Override public String toString() {
		String devolver = "function " + type + " " + id + " (";
		for (String parameter:parameters.values()){
			devolver += parameter + " " +  parameters.get(parameter) +", ";
		}
		// en caso de haber parametros, le quito los 2 ultimos caracteres ", "
		if(!parameters.isEmpty()) devolver = devolver.substring(0,devolver.length() -2);
		return devolver + ");";
	}

	@Override public int hashCode() {
		return (Integer) null;
	}

	@Override public boolean equals(Object obj) {
		return (Boolean) null;
	}

	public static FunctionDeclaration generate(Random random, int min, int max) {
		return null;
	}

	@Override
	public State evaluate(State state) {
		return null;

	}

	@Override
	public CheckState check(CheckState s) {
		return null;
	}


	@Override
	public String unparse() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public CheckStateLinter checkLinter(CheckStateLinter s) {
		if (Character.isUpperCase(id.charAt(0))) CheckStateLinter.addError7(line, column);
		if (body.countNestingLevels() > 5) CheckStateLinter.addError21(body.countNestingLevels(), line, column);
		if (s.mapa.containsKey(id) && s.mapa.get(id).isFunction()) CheckStateLinter.addError13(id, line, column);
		s.mapa.keySet().forEach((key) -> {
			if (key.toLowerCase().equals(id.toLowerCase()) && !key.equals(id) && s.mapa.get(key).isFunction())
				CheckStateLinter.addError18A(id, key, line, column);
		});
		
		s.mapa.put(id, new ObjectState(type, false, 1, this));
		
		Map<String,ObjectState> clonedMap = CheckState.clonarMapa(s.mapa);
		CheckStateLinter cslForOutsideVariables = new CheckStateLinter();
		cslForOutsideVariables.mapa = clonedMap;
		body.checkLinter(cslForOutsideVariables);
		
		Map<String,ObjectState> parametersMap = new HashMap<String,ObjectState>();
		for (Map.Entry<String, String> parameter : parameters.entrySet()) {
			parametersMap.put(parameter.getKey(), new ObjectState(parameter.getValue(), false, 2, this));
		}
		CheckStateLinter cslForParams = new CheckStateLinter();
		cslForParams.mapa = parametersMap;
		body.idFunction=id;
		cslForParams = body.checkLinter(cslForParams);
		CheckStateLinter.generateErrors(cslForParams);
		
		return s;
	}

	@Override
	public int getLine() {
		return line;
	}

	@Override
	public int getColumn() {
		return column;
	}
	
	@Override
	public int countNestingLevels() {
		return body.countNestingLevels();
	}
}
