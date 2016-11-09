package ucu.ast;

import java.util.*;

/** Representación de las secuencias de sentencias.
*/
public class Sequence extends Stmt {
	public final Stmt[] statements;

	public Sequence(Stmt[] statements, int line, int column) {
		this.statements = statements;
		this.line = line;
		this.column = column;
	}

	@Override public String unparse() {
		String result = "{ ";
					for (Stmt statement : statements) {
						result += statement.unparse() +" ";
					}
					return result +"}";
	}

	@Override public String toString() {
		return "Sequence("+ Arrays.toString(statements) +")";
	}

	@Override public int hashCode() {
		int result = 1;
		result = result * 31 + Arrays.hashCode(this.statements);
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Sequence other = (Sequence)obj;
		return Arrays.equals(this.statements, other.statements);
	}

	@Override
	public State evaluate(State state) {
		for (int i=0; i<statements.length; i++){
			statements[i].evaluate(state);
		}
		return state;
	}

	@Override
	public CheckState check(CheckState s) {
		for (int i=0; i<statements.length; i++){
			s=statements[i].check(s);
		}
		return s;
	}

	@Override
	public CheckStateLinter checkLinter(CheckStateLinter s) {
		if (statements.length <= 1) CheckStateLinter.addError17(line, column);
		for (Stmt stmt : statements) {
			if (stmt instanceof Sequence) {
				CheckStateLinter.addError17(line, column);
			}
			s = stmt.checkLinter(s);
		}
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
}
