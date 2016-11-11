package ucu;

import junit.framework.TestCase;
import ucu.ast.CheckStateLinter;
import ucu.ast.Stmt;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Regla número2
 * Que haya solo un statement por línea
 */
public class TestRule2 extends TestCase {

	Map<Integer, String> datosPruebas = new HashMap<Integer, String>();
	Logger logger = Logger.getAnonymousLogger();
    String expected = "No debe haber mas de un statement en la misma linea.";
    CheckStateLinter checkStateLinter = new CheckStateLinter();

	protected void setUp() throws Exception {
		loadData();
		super.setUp();
	}

	protected void loadData() {
        datosPruebas.put(1, "int y=3;");
        datosPruebas.put(2, "{int y=3;}");   // aca este tirando un error pero no se si esta bien
        datosPruebas.put(3, "{int y=2;\n\n\ny=3;}");
        datosPruebas.put(4, "{int y=2;\n\ny=3;}");
        datosPruebas.put(5, "{print(2);}");
	}

	public void testData1() {
		try {
			Integer numTest =1;   // Setear este valor

            CheckStateLinter.errores.clear();
			Object obj = Parse.parse(datosPruebas.get(numTest));
			logger.log(Level.INFO, obj.toString());

			CheckStateLinter check = ((Stmt) obj).checkLinter(checkStateLinter);

			String actual = check.toString();

			logger.log(Level.INFO, actual);

            assertTrue("No se esperaba recibir:[" + expected + "] pero el resultado fue " + actual + " evaluando:" + datosPruebas.get(numTest)
                    , !actual.contains(expected));

		} catch (Exception e) {
			logger.log(Level.SEVERE, e.toString(), e.getCause());
		}
	}

    public void testData2() {
        try {
            Integer numTest =2;   // "{int y=3;}"
            CheckStateLinter.errores.clear();
            Object obj = Parse.parse(datosPruebas.get(numTest));
            logger.log(Level.INFO, obj.toString());

            CheckStateLinter check = ((Stmt) obj).checkLinter(checkStateLinter);

            String actual = check.toString();

            logger.log(Level.INFO, actual);

            assertTrue("No se esperaba recibir:[" + expected + "] pero el resultado fue " + actual + " evaluando:" + datosPruebas.get(numTest)
                    , !actual.contains(expected));

        } catch (Exception e) {
            logger.log(Level.SEVERE, e.toString(), e.getCause());
        }
    }

    public void testData3() {
        try {
            Integer numTest =3;   // Setear este valor
            CheckStateLinter.errores.clear();
            Object obj = Parse.parse(datosPruebas.get(numTest));
            logger.log(Level.INFO, obj.toString());


            String actual = ((Stmt) obj).checkLinter(checkStateLinter).toString();

            logger.log(Level.INFO, actual);

            assertTrue("No Se esperaba recibir:[ " + expected + "] pero el resultado fue " + actual + " evaluando:\n" + datosPruebas.get(numTest)
                    , !actual.contains(expected));

        } catch (Exception e) {
            e.printStackTrace();
            logger.log(Level.SEVERE, e.toString(), e.getCause());
        }
    }

    public void testData4() {
        try {
            Integer numTest =4;   // Setear este valor
            CheckStateLinter.errores.clear();
            Object obj = Parse.parse(datosPruebas.get(numTest));
            logger.log(Level.INFO, obj.toString());

            CheckStateLinter check = ((Stmt) obj).checkLinter(checkStateLinter);

            String actual = check.toString();

            logger.log(Level.INFO, actual);

            assertFalse("Se esperaba " + expected + "pero el resultado fue " + actual + " evaluando: " + datosPruebas.get(numTest)
                    , actual.contains(expected));

        } catch (Exception e) {
            logger.log(Level.SEVERE, e.toString(), e.getCause());
        }
    }

    public void testData5() {
        try {
            Integer numTest =5;   // Setear este valor
            CheckStateLinter.errores.clear();
            Object obj = Parse.parse(datosPruebas.get(numTest));
            logger.log(Level.INFO, obj.toString());


            CheckStateLinter check = ((Stmt) obj).checkLinter(checkStateLinter);

            String actual = check.toString();

            logger.log(Level.INFO, actual);

            assertTrue("No Se esperaba recibir:[ " + expected + "] pero el resultado fue " + actual + " evaluando:\n" + datosPruebas.get(numTest)
                    , !actual.contains(expected));

        } catch (Exception e) {
            logger.log(Level.SEVERE, e.toString(), e.getCause());
        }
    }
}