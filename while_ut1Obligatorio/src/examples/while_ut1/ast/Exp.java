package examples.while_ut1.ast;

public abstract class Exp {
	abstract public String unparse();
	abstract public Object evaluate(State state);
	abstract public boolean equals(Object obj);
	abstract public String check(CheckState s);
	
	public static double toDouble(Object obj,String unparse) {
		return Stmt.toDouble(obj, unparse);
	}
	
	
}
