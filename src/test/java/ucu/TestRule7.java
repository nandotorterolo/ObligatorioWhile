package ucu;

import junit.framework.TestCase;
import ucu.ast.CheckStateLinter;
import ucu.ast.Stmt;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Regla número 7
 * Los nombres de los métodos deben comenzar con minúsculas
 */
public class TestRule7 extends TestCase {

	Logger logger = Logger.getAnonymousLogger();

	public void testData1() {
		try {
			String strParse = "function int MiFuncion(int _a, int A){skip;}";   // Setear este valor
            CheckStateLinter.errores.clear();

            Object obj = Parse.parse(strParse );
			logger.log(Level.INFO, obj.toString());

            CheckStateLinter check = ((Stmt) obj).checkLinter(new CheckStateLinter());

			String actual = check.toString();
			String expected = "los nombres de metodos deben comenzar con minuscula.";

			logger.log(Level.INFO, actual);

			assertTrue("Se esperaba: [" + expected + "] pero el resultado fue [" + actual + "] evaluando: [" + strParse + "]",
                    actual.contains(expected));

		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.toString(), e.getCause());
		}
	}

	public void testData2() {
		try {
			String strParse = "function int _mi_Funcion(int _a, int A){skip;}";   // Setear este valor
			CheckStateLinter.errores.clear();

			Object obj = Parse.parse(strParse );
			logger.log(Level.INFO, obj.toString());

			CheckStateLinter check = ((Stmt) obj).checkLinter(new CheckStateLinter());

			String actual = check.toString();
			String expected = "los nombres de metodos deben comenzar con minuscula.";

			logger.log(Level.INFO, actual);

			assertTrue("Se esperaba: [" + expected + "] pero el resultado fue [" + actual + "] evaluando: [" + strParse + "]",
					!actual.contains(expected));

		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.toString(), e.getCause());
		}
	}

}