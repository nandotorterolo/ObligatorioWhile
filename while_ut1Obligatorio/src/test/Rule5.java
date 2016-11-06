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
 * Regla número 5
 * Detectar código que no se va a ejecutar. ej: '' if (15>10) { -- } else { // esto no se ejecuta nunca  }
 */
public class Rule5 extends TestCase {

	Map<Integer, String> datosPruebas = new HashMap<Integer, String>();
	Logger logger = Logger.getAnonymousLogger();
	CheckStateLinter state;

	protected void setUp() throws Exception {
		state = new CheckStateLinter();
		loadData5();
		super.setUp();
	}

	protected void loadData5() {
		datosPruebas.put(1, "{if (15>10){ y=2; } else { x=3; }}"); // 
		datosPruebas.put(2, "{if (15<10){ y=2; } else { x=3; }}");  // 
		datosPruebas.put(3, "{while(15<10){ y=2;\n x=3; }}"); // 
		datosPruebas.put(4, "{while(true){ y=2;\n x=3; }}"); // 
		datosPruebas.put(5, "{while(15<10){ y=2;\nx=3; }}"); //
		datosPruebas.put(6, "{y=2; x=3; }"); //
	}

	public void testData1() {
		try {
			Integer numTest =2;
//			
			Object obj = Parse.parse(datosPruebas.get(numTest));
			logger.log(Level.INFO, obj.toString());
			if (obj instanceof Stmt) {
				CheckStateLinter check = ((Stmt) obj).checkLinter(state); 
				logger.log(Level.INFO, check.toString());
			} else {
				logger.log(Level.WARNING,"No es instacia de Stmt");
			}
			
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e.getCause());
		}
	}

}

