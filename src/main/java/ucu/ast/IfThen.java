package ucu.ast;

import java.util.Map;
import java.util.Random;

/** Representación de las sentencias condicionales.
 */
public class IfThen extends Stmt {
	public final Exp condition;
	public final Stmt thenBody;

	public IfThen(Exp condition, Stmt thenBody) {
		this.condition = condition;
		this.thenBody = thenBody;
	}

	@Override public String unparse() {
		return "if "+ condition.unparse() +" then { "+ thenBody.unparse() +" }";
	}

	@Override public String toString() {
		return "IfThen("+ condition +", "+ thenBody +")";
	}

	@Override public int hashCode() {
		int result = 1;
		result = result * 31 + (this.condition == null ? 0 : this.condition.hashCode());
		result = result * 31 + (this.thenBody == null ? 0 : this.thenBody.hashCode());
		return result;
	}

	@Override public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		IfThen other = (IfThen)obj;
		return (this.condition == null ? other.condition == null : this.condition.equals(other.condition))
				&& (this.thenBody == null ? other.thenBody == null : this.thenBody.equals(other.thenBody));
	}

	public static IfThen generate(Random random, int min, int max) {
		BExp condition; Stmt thenBody;
		condition = BExp.generate(random, min-1, max-1);
		thenBody = Stmt.generate(random, min-1, max-1);
		return new IfThen(condition, thenBody);
	}

	@Override
	public State evaluate(State state) {
		if (condition.evaluate(state) instanceof Boolean){
			Boolean truthValue=(Boolean) condition.evaluate(state);
			State statein=state.clone();
			if (truthValue) {
				thenBody.evaluate(statein);
			}
			state.mapaValores=State.actualizarValoresMapViejo(state.mapaValores,statein.mapaValores);
			return state;
		}
		else {
			throw new IllegalStateException(this.unparse());
		}
	}


	@Override
	public CheckState check(CheckState s){
		Map mapaAntesIf= CheckState.clonarMapa(s.mapa);
		CheckState checkStateIfIn=new CheckState();
		checkStateIfIn.mapa=mapaAntesIf;
		if (condition.check(s).equals("Boolean")){
			checkStateIfIn=thenBody.check(checkStateIfIn);
			s.errores.addAll(checkStateIfIn.errores);
			return s;
		}else{
			s.errores.add("Error en el if debe poner condicion boolean:"+this.toString());
			return s;
		}
	}


	public void compareIf(CheckState checkState1, CheckState checkState2) {
		for (String id : checkState1.mapa.keySet()) {
			ObjectState firstEntry = checkState1.mapa.get(id);
			if (checkState2.mapa.containsKey(id) && !checkState2.mapa.get(id).tipo.equals(firstEntry.tipo)){
				checkState1.errores.add("Error la variable "+id+" se le cambio el tipo en el IF:"+this.toString());
			}
		}
	}

	@Override
	public CheckStateLinter checkLinter(CheckStateLinter s) {
		Exp optimizado=condition.optimize();
		if (optimizado instanceof TruthValue){
			if (((TruthValue) optimizado).value){
				CheckStateLinter.addError("5", "La condici�n no es necesaria", line, column);
			}else{
				CheckStateLinter.addError("5", "El codigo interno no se ejecutar� nunca", line, column);
			}
		}


		condition.checkLinter(s);
		thenBody.checkLinter(s);
		return null;
	}


}
