package examples.while_ut1.ast;

import java.util.*;

/** RepresentaciÃ³n de las asignaciones de valores a variables.
 */
public class FunctionDeclaration extends Stmt {
	public final String id;
	public final String type;// en el evaluate de esta clase al evaluar el body
	//vamos a tener que setear una variable en el estado que es el valor de 
	// retorno de la función
	
	
	//hay que clonar el estado para guardar las variables locales de la funicón
	
	
	
	LinkedHashMap<K, V>
	public final Map<String, String> parameters =new  HashMap<String, String>();
	public final Stmt body;


	public FunctionDeclaration(String id, String type, M) {
		this.id = id;
		this.expression = expression;
		this.
	}

	@Override public String unparse() {
		return id +" = "+ expression.unparse() +"; ";
	}

	@Override public String toString() {
		return "Assignment("+ id +", "+ expression +")";
	}

	@Override public int hashCode() {
		int result = 1;
		result = result * 31 + (this.id == null ? 0 : this.id.hashCode());
		result = result * 31 + (this.expression == null ? 0 : this.expression.hashCode());
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		FunctionDeclaration other = (FunctionDeclaration)obj;
		return (this.id == null ? other.id == null : this.id.equals(other.id))
				&& (this.expression == null ? other.expression == null : this.expression.equals(other.expression));
	}

	public static FunctionDeclaration generate(Random random, int min, int max) {
		String id; AExp expression; 
		id = ""+"abcdefghijklmnopqrstuvwxyz".charAt(random.nextInt(26));
		expression = AExp.generate(random, min-1, max-1);
		return new FunctionDeclaration(id, expression);
	}

	@Override
	public State evaluate(State state) {
		AssignmentExp.asignarValor(expression,state,id,this.unparse());
		return state;
				
	}

	@Override
	public CheckState check(CheckState s) {
		if (!s.mapa.containsKey(id)){
			s.errores.add("Variable "+id+" no definida: "+this.unparse());
		}else{
			if (s.mapa.get(id).tipo.equals(expression.check(s))){
				s.mapa.get(id).assigned=true;
			}else if(s.mapa.get(id).tipo.equals("Double") && expression.check(s).equals("Double")){
				s.mapa.get(id).assigned=true;
			}else{
				s.errores.add("El tipo de la expresion no coincide con la variable "+id+":"+this.unparse());
			}
		}
		return s;
	}

		
}
