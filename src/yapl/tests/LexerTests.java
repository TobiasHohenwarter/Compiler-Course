package yapl.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import yapl.ParseException;
import yapl.TokenMgrError;
import yapl.yapl;
import yapl.interfaces.CompilerError;
import junit.framework.TestCase;

public class LexerTests extends TestCase {
	public void testTest01() throws ParseException{
		try {
		createParser("test01");
		} catch (ParseException ex) {
			verifyException(ex, 3, 20, 9);
		}
	}
	
	public void testTest02() throws ParseException{
		try {
		createParser("test02"); 
		} catch (TokenMgrError ex) {
			verifyException(ex, 2, 21, 18);
		}
	}
	
	public void testTest03() throws ParseException{
		createParser("test03");
	}

	private void createParser(String fileName) throws ParseException {
		yapl parser;
		try {
			parser = new yapl(new FileInputStream("testfiles\\lexer\\" + fileName + ".yapl"));
			parser.Start();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void verifyException(CompilerError ex, int errorNumber, int line, int column)
	{
		assertEquals(errorNumber, ex.errorNumber());
		assertEquals(line, ex.line());
		assertEquals(column, ex.column());
	}
}