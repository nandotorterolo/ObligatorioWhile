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

	Map<Integer, String> datosPruebas = new HashMap<Integer, String>();
	Logger logger = Logger.getAnonymousLogger();

	protected void setUp() throws Exception {
		loadData();
		super.setUp();
	}

	protected void loadData() {
        datosPruebas.put(1, "function bool negacion(bool a, bool b) {bool c=a&&b; return c;}");
        datosPruebas.put(2, "{function bool negacion() {return !a;}}");
        datosPruebas.put(3, "function int entero(int a) return a;");
    }
//	function bool negacion(bool a) {!a;};
	public void testData1() {
		try {
			Integer numTest =1;   // Setear este valor
            CheckStateLinter.errores.clear();

            Object obj = Parse.parse(datosPruebas.get(numTest));
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