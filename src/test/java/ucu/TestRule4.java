package ucu;

import junit.framework.TestCase;
import ucu.ast.CheckStateLinter;
import ucu.ast.Stmt;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Regla número 4
 * Detectar variables declaradas sin usar
 */
public class TestRule4 extends TestCase {

	Logger logger = Logger.getAnonymousLogger();

	public void testData1() {
		try {
			String strParse = "{int a=1; int b=2; int c=3; a=1; b=a;}";   // Setear este valor
            CheckStateLinter.errores.clear();

            Object obj = Parse.parse(strParse );
			logger.log(Level.INFO, obj.toString());

            CheckStateLinter check = ((Stmt) obj).checkLinter(new CheckStateLinter());

			String actual = check.toString();
			String expected = "";

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
			String strParse = "{int a=1;}";   // Setear este valor
			CheckStateLinter.errores.clear();

			Object obj = Parse.parse(strParse);
			logger.log(Level.INFO, obj.toString());

			CheckStateLinter check = ((Stmt) obj).checkLinter(new CheckStateLinter());

			String actual = check.toString();
			String expected = "";

			logger.log(Level.INFO, actual);

			assertTrue("Se esperaba: [" + expected + "] pero el resultado fue [" + actual + "] evaluando: [" + strParse + "]",
					actual.contains(expected));

		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.toString(), e.getCause());
		}
	}



}