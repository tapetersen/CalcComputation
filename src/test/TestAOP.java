package test;
import java.io.File;
import java.io.FileReader;
import org.junit.Test;
import parser.Parser;
import parser.Start;

public class TestAOP extends TestCaseOutput {
    private final static String DATA = "data/";
    private final static String RESULT = "result/";
    private final static String FILE_EXTENSION = ".calc";
    private final static String RESULT_EXTENSION = ".res";

    private void assertCorrectOutput(String testName) {
        String fullName = testName + FILE_EXTENSION;
        interactive(DATA + fullName);
        assertOutput(new File(RESULT + fullName + RESULT_EXTENSION));
    }

    @Test
    public void aopYes() {
        assertCorrectOutput("aopYes");
    }

    @Test
    public void aopNo() {
        assertCorrectOutput("aopNo");
    }

    private static void interactive(String arg) {
        try {
            Parser parser = new Parser(new FileReader(arg));
            Start start = parser.start();
            boolean interactive = start.interactive();
            System.out.println("TestAOP: " + (interactive ? "yes" : "no"));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        interactive(args[0]);
    }
}
