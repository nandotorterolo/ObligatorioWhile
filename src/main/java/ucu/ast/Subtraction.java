package ucu.ast;

import java.util.*;

/** Representación de restas.
 */
public class Subtraction extends AExp {
	public final Exp left;
	public final Exp right;

	public Subtraction(Exp left, Exp right) {
		this.left = left;
		this.right = right;
	}

	@Override public String unparse() {
		return "("+ left.unparse() +" - "+ right.unparse() +")";
	}

	@Override public String toString() {
		return "Subtraction("+ left +", "+ right +")";
	}

	@Override public int hashCode() {
		int result = 1;
		result = result * 31 + (this.left == null ? 0 : this.left.hashCode());
		result = result * 31 + (this.right == null ? 0 : this.right.hashCode());
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Subtraction other = (Subtraction)obj;
		return (this.left == null ? other.left == null : this.left.equals(other.left))
				&& (this.right == null ? other.right == null : this.right.equals(other.right));
	}

	public static Subtraction generate(Random random, int min, int max) {
		AExp left; AExp right;
		left = AExp.generate(random, min-1, max-1);
		right = AExp.generate(random, min-1, max-1);
		return new Subtraction(left, right);
	}

	@Override
	public Object evaluate(State state) {
		Object left; Object right;
		left =this.left.evaluate(state);
		right =this.right.evaluate(state);
		if (left instanceof Integer && right instanceof Integer){
			return (Integer) left - (Integer) right;
		}else if ((left instanceof Integer && right instanceof Double)||
				(left instanceof Double && right instanceof Integer)||
				(left instanceof Double && right instanceof Double)){
			return toDouble(left,unparse()) - toDouble(right,unparse());
		}
		else {
			throw new IllegalStateException(this.unparse());
		}
	}

	@Override
	public String check(CheckState s){
		String left; String right;
		left =this.left.check(s);
		right =this.right.check(s);
		if ((left.equals(right)) && left.equals("Integer")){
			return left;
		}else if (((left.equals("Double")) && left.equals("Integer"))||
				(left.equals("Integer")) && left.equals("Double") ||
				(left.equals("Double")) && left.equals("Double")
				){
			return "Double";
		}else{
			s.errores.add("Tipos no numericos:"+this.unparse());
			return left;
		}
	}

	@Override
	public String checkLinter(CheckStateLinter s) {
		String left=this.left.checkLinter(s);
		String right=this.right.checkLinter(s);
		if ((left.equals(right)) && left.equals("Integer")){
			return left;
		}else if (((left.equals("Double")) && left.equals("Integer"))||
				(left.equals("Integer")) && left.equals("Double") ||
				(left.equals("Double")) && left.equals("Double")
				){
			return "Double";
		}else{
			ArrayList <String> tiposAceptados=new ArrayList<String>();
			tiposAceptados.add("Integer");
			tiposAceptados.add("Double");
			CheckStateLinter.evaluarRegla9(this.left, s, tiposAceptados);
			CheckStateLinter.evaluarRegla9(this.right, s, tiposAceptados);


			return left;
		}
	}

	@Override
	public Exp optimize() { 
		Exp leftOptimized =left.optimize();
		Exp rightOptimized =right.optimize();
		if (leftOptimized instanceof Numeral && rightOptimized instanceof Numeral){
			Double leftNumberValue=0.0;
			Double rightNumberValue=0.0;
			if (((Numeral)leftOptimized).number instanceof Integer){
				leftNumberValue =((Integer)((Numeral)leftOptimized).number).doubleValue();
			}else{
				leftNumberValue =((Double)((Numeral)leftOptimized).number);
			}
			if (((Numeral)rightOptimized).number instanceof Integer){
				rightNumberValue =((Integer)((Numeral)rightOptimized).number).doubleValue();
			}else{
				rightNumberValue =((Double)((Numeral)rightOptimized).number);
			}
			return new Numeral(leftNumberValue-rightNumberValue, left.line, left.column);
		}	
		return this;
	}

	@Override
	public int getLine() {
		return 0;
	}

	@Override
	public int getColumn() {
		return 0;
	}

	@Override
	public int countOperators() {
		return 1 + left.countOperators() + right.countOperators();
	}
}
