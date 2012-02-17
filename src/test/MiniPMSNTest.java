package test;

import java.io.File;
import java.io.FileReader;

import org.junit.Test;

import parser.Parser;
import parser.Start;

public class MiniPMSNTest extends TestCaseOutput {
	private final static String DATA = "data/";
	private final static String RESULT = "result/";
	private final static String RESULT_EXTENSION = ".res";

	private void assertCorrectOutput(String testName) {
		String fullName = testName;
		interactive(DATA + fullName);
		assertOutput(new File(RESULT + fullName + RESULT_EXTENSION));
	}

	@Test
	public void forforforlamb() {
		assertCorrectOutput("forforforlamb");
	}

	@Test
	public void example() {
		assertCorrectOutput("example");
	}

	private static void interactive(String arg) {
		try {
			Parser parser = new Parser(new FileReader(arg));
			Start start = parser.start();
			MiniPMSNVisitor v = new MiniPMSNVisitor();
			int nestingDepth = (Integer) v.visit(start, null);
			System.out.println("NestingDepth is: " + nestingDepth);

		} catch (Exception e) {
			System.out.println("wtf!");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		interactive(args[0]);
	}
}
