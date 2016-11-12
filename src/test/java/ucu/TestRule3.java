package ucu;

import junit.framework.TestCase;
import ucu.ast.CheckStateLinter;
import ucu.ast.Stmt;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Regla número 3
 * Detectar funciones declaradas sin llamar
 */
public class TestRule3 extends TestCase {

	Logger logger = Logger.getAnonymousLogger();

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void NOANDAtestData1() { // TODO
		try {
            String strParse = "function bool negacion(bool a, bool b) {bool c=a&&b; return c;}"; // Setear este valor
            CheckStateLinter.errores.clear();

            Object obj = Parse.parse(strParse);
			logger.log(Level.INFO, obj.toString());

            CheckStateLinter check = ((Stmt) obj).checkLinter(new CheckStateLinter());

			String actual = check.toString();
			String expected = "";

			logger.log(Level.INFO, actual);

//			assertTrue("Se esperaba " + expected + "pero el resultado fue " + actual + " evaluando:" + datosPruebas.get(numTest),
//                    actual.contains(expected));

		} catch (Exception e) {
			e.printStackTrace();
			logger.log(Level.SEVERE, e.toString(), e.getCause());
		}
	}

    public void NOANDAtestData2() { // TODO
        try {
            String strParse = "{function bool negacion() {return !a;}}"; // Setear este valor
            CheckStateLinter.errores.clear();

            Object obj = Parse.parse(strParse);
            logger.log(Level.INFO, obj.toString());

            CheckStateLinter check = ((Stmt) obj).checkLinter(new CheckStateLinter());

            String actual = check.toString();
            String expected = "";

            logger.log(Level.INFO, actual);

//			assertTrue("Se esperaba " + expected + "pero el resultado fue " + actual + " evaluando:" + datosPruebas.get(numTest),
//                    actual.contains(expected));

        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, e.toString(), e.getCause());
        }
    }


    public void NOANDAtestData3() { // TODO
        try {
            String strParse = "function int entero(int a) return a;"; // Setear este valor
            CheckStateLinter.errores.clear();

            Object obj = Parse.parse(strParse);
            logger.log(Level.INFO, obj.toString());

            CheckStateLinter check = ((Stmt) obj).checkLinter(new CheckStateLinter());

            String actual = check.toString();
            String expected = "";

            logger.log(Level.INFO, actual);

//			assertTrue("Se esperaba " + expected + "pero el resultado fue " + actual + " evaluando:" + datosPruebas.get(numTest),
//                    actual.contains(expected));

        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, e.toString(), e.getCause());
        }
    }


    public void testData4() { // TODO, se dejo porque al menos un test andando tiene que haber.
        try {
            String strParse = "{function int entero(int a) a=b;}"; // Setear este valor
            CheckStateLinter.errores.clear();

            Object obj = Parse.parse(strParse);
            logger.log(Level.INFO, obj.toString());

            CheckStateLinter check = ((Stmt) obj).checkLinter(new CheckStateLinter());

            String actual = check.toString();
            String expected = "";

            logger.log(Level.INFO, actual);

//			assertTrue("Se esperaba " + expected + "pero el resultado fue " + actual + " evaluando:" + datosPruebas.get(numTest),
//                    actual.contains(expected));

        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, e.toString(), e.getCause());
        }
    }

}