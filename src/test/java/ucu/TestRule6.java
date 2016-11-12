package ucu;

import junit.framework.TestCase;
import ucu.ast.CheckStateLinter;
import ucu.ast.Stmt;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Regla número 6
 * Los nombres de la variables deben comenzar con minúsculas y sin guiones bajos
 */
public class TestRule6 extends TestCase {

	Logger logger = Logger.getAnonymousLogger();

	public void testData1() {
		try {
			String strParse = "{int a=1; int Ba=2; }";   // Setear este valor
            CheckStateLinter.errores.clear();

            Object obj = Parse.parse(strParse );
			logger.log(Level.INFO, obj.toString());

            CheckStateLinter check = ((Stmt) obj).checkLinter(new CheckStateLinter());

			String actual = check.toString();
			String expected = "las variables deben comenzar con minuscula y sin guiones bajos.";

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
			String strParse = "{int a=1; int _ad=2; }";   // Setear este valor
			CheckStateLinter.errores.clear();

			Object obj = Parse.parse(strParse );
			logger.log(Level.INFO, obj.toString());

			CheckStateLinter check = ((Stmt) obj).checkLinter(new CheckStateLinter());

			String actual = check.toString();
			String expected = "las variables deben comenzar con minuscula y sin guiones bajos.";

			logger.log(Level.INFO, actual);

			assertTrue("Se esperaba: [" + expected + "] pero el resultado fue [" + actual + "] evaluando: [" + strParse + "]",
					actual.contains(expected));

		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.toString(), e.getCause());
		}
	}


	public void NOANDAtestData3() { // TODO
		try {
			String strParse = "function int myfuncion(int _a, int A){skip;}";   // Setear este valor
			CheckStateLinter.errores.clear();

			Object obj = Parse.parse(strParse );
			logger.log(Level.INFO, obj.toString());

			CheckStateLinter check = ((Stmt) obj).checkLinter(new CheckStateLinter());

			String actual = check.toString();
			String expected = "las variables deben comenzar con minuscula y sin guiones bajos.";

			logger.log(Level.INFO, actual);

			assertTrue("Se esperaba: [" + expected + "] pero el resultado fue [" + actual + "] evaluando: [" + strParse + "]",
					actual.contains(expected));

		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.toString(), e.getCause());
		}
	}

}