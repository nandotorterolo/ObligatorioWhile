package ucu;

import junit.framework.TestCase;
import ucu.ast.CheckStateLinter;
import ucu.ast.Stmt;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Regla número 8
 * Uso de variables no definidas
 */
public class TestRule8 extends TestCase {

	Logger logger = Logger.getAnonymousLogger();

	public void testData1() {
		try {
			String strParse = "{int a=1; int b=2; int c=3; a=1; b=d;}";   // Setear este valor
            CheckStateLinter.errores.clear();

            Object obj = Parse.parse(strParse );
			logger.log(Level.INFO, obj.toString());

            CheckStateLinter check = ((Stmt) obj).checkLinter(new CheckStateLinter());

			String actual = check.toString();
			String expected = "variable d no declarada";

			logger.log(Level.INFO, actual);

			assertTrue("Se esperaba: [" + expected + "] pero el resultado fue [" + actual + "] evaluando: [" + strParse + "]",
                    actual.contains(expected));

		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.toString(), e.getCause());
		}
	}

	public void NOANDAtestData2() { // TODO
		try {
			String strParse = "{int a=1; int b=2; bool d=True; function bool fun1(int a, int b) {return d;}}";   // Setear este valor


// function bool negacion(bool a, bool b) {bool c=a&&b; return c;}
			CheckStateLinter.errores.clear();

			Object obj = Parse.parse(strParse );
			logger.log(Level.INFO, obj.toString());

			CheckStateLinter check = ((Stmt) obj).checkLinter(new CheckStateLinter());

			String actual = check.toString();
			String expected = "variable d no declarada";

			logger.log(Level.INFO, actual);

			assertTrue("Se esperaba: [" + expected + "] pero el resultado fue [" + actual + "] evaluando: [" + strParse + "]",
					actual.contains(expected));

		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.toString(), e.getCause());
		}
	}



}