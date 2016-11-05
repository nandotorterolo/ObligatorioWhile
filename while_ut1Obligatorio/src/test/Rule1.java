package test;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import examples.while_ut1.ast.CheckStateLinter;
//import examples.while_ut1.Parser;
import examples.while_ut1.ast.Stmt;
import junit.framework.TestCase;

/**
 * Regla numeo 1
 * Que no exista más de un salto de línea entre dos líneas de código consecutivas.
 */
public class Rule1 extends TestCase {

	Map<Integer, String> datosPruebas = new HashMap<Integer, String>();
	Logger logger = Logger.getAnonymousLogger();
	CheckStateLinter state;

	protected void setUp() throws Exception {
		state = new CheckStateLinter();
		loadData1();
		super.setUp();
	}

	protected void loadData1() {
		datosPruebas.put(1, "{y=2;\n\n y=3; \n\t\f\n x=6+y;}");
		datosPruebas.put(2, "{y=2;\n\ny=3;\n\nx=6+y;print(x);}"); // la funcion print, no tiene
	}

	public void testData1() {
		try {
			Integer numTest = 1;
			CheckStateLinter.addError("dsdf", "sdf", 1, 1);
			Object obj = Parse.parse(datosPruebas.get(numTest));
			logger.log(Level.INFO, obj.toString());
			if (obj instanceof Stmt) {
				CheckStateLinter check = ((Stmt) obj).checkLinter(state); 
				logger.log(Level.INFO, check.toString());
				logger.log(Level.WARNING,"llego al final");
			} else {
				logger.log(Level.WARNING,"No es instacia de Stmt");
			}
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e.getCause());
		}
	}

}
