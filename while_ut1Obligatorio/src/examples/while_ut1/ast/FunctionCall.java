package examples.while_ut1.ast;

import java.util.*;

/** Representación de multiplicaciones.
 */
public class FunctionCall extends Exp {
	public final String id;
	public final List <Exp> parameters;

	public FunctionCall(String id, List<Exp> p) {
		this.id=id;
		this.parameters = p;
	}


	@Override public String toString() {
		String devolver=id+" (";
		int i=0;
		for (Exp parameter:parameters){
			devolver+=parameter.toString();
			i++;
			if (i!=parameters.size()){
				devolver+=",";
			}
		}
		devolver+=");";
		return devolver;
	}

	@Override public int hashCode() {
		return (Integer) null;	
	}

	@Override public boolean equals(Object obj) {
		return (Boolean) null;
	}

	public static FunctionCall generate(Random random, int min, int max) {
		return null;
	}

	@Override
	public Object evaluate(State state) {
		return null;
	}

	@Override
	public String check(CheckState s){
		return null;
	}


	@Override
	public String unparse() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public CheckStateLinter checkLinter(CheckStateLinter s) {
		// TODO Auto-generated method stub
		
	}
}
