package test;

import java_cup.runtime.DefaultSymbolFactory;
import java_cup.runtime.Symbol;

import java.io.CharArrayReader;
import java.io.Reader;

import examples.while_ut1.Parser;
import examples.while_ut1.ast.Stmt;

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