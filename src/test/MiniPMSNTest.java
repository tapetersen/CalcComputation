package test;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

import parser.Node;
import parser.Parser;
import parser.Start;
import parser.Stmt;

public class MiniPMSNTest extends TestCaseOutput {
	private final static String DATA = "data/";
	private final static String RESULT = "result/";
	private final static String RESULT_EXTENSION = ".msn";
	private static int msn;

	public static void main(String args[]) {
		int msn = 0;
		calcMSN("addmulexample");
	}

	public static void calcMSN(String arg) {
		try {
			Parser parser = new Parser(new FileReader(DATA + arg));
			FileWriter file = new FileWriter(RESULT + arg + RESULT_EXTENSION);
			BufferedWriter out = new BufferedWriter(file);
			MiniPMSNVisitor visitor = new MiniPMSNVisitor();
			Start start = parser.start();
			calcMsn(start, 0);
			out.write(msn);

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	private static void calcMsn(Node node, int tmpMSN) {
		for (int i = 0; i < node.jjtGetNumChildren(); i++) {
			if (node.jjtGetChild(i) instanceof Stmt) {
				tmpMSN++;
				msn = Math.max(tmpMSN, msn);
				calcMsn(node.jjtGetChild(i), tmpMSN);
				tmpMSN--;
			}
		}
	}
}