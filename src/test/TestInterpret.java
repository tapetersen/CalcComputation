package test;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

import org.junit.Test;
import parser.Parser;
import parser.Start;

public class TestInterpret extends TestCaseOutput {
    private final static String DATA = "data/";
    private final static String RESULT = "result/";
    private final static String RESULT_EXTENSION = ".res";

    private void assertCorrectOutput(String testName) {
        String fullName = testName;
        interpret(DATA + fullName);
        assertOutput(new File(RESULT + fullName + RESULT_EXTENSION));
    }

    @Test
    public void example() {
        assertCorrectOutput("example");
    }
    
    @Test
    public void example1() {
        assertCorrectOutput("example1");
    }
    
    @Test
    public void example2() {
        assertCorrectOutput("example2");
    }
    
    @Test
    public void example3() {
        assertCorrectOutput("example3");
    }
    
    @Test
    public void example3() {
        assertCorrectOutput("example3");
    }
    
    @Test
    public void forexample() {
        assertCorrectOutput("example3");
    }
    
    @Test
    public void addmulexample() {
        assertCorrectOutput("example3");
    }
    private static void interpret(String arg) {
        try {
            Parser parser = new Parser(new FileReader(arg));
            Start start = parser.start();
            start.interpret(new HashMap<String, Integer>());
            System.out.println("Program finished.");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        interpret(args[0]);
    }
}
