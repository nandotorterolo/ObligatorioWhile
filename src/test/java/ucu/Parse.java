package ucu;


import ucu.Parser;
import ucu.ast.Stmt;

public class Parse {

    public static Object parse(String val) {

        try {
        	Stmt prog = (Stmt) (Parser.parse(val).value);
            return prog;
        } catch (Exception e) {
            e.printStackTrace();
            return new IllegalStateException("parsing" + val, e);
        }
    }
}