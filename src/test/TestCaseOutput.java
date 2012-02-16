package test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;

/**
 * @author Torbjorn Ekman (torbjorn.ekman@cs.lth.se)
 * 
 *         TestCaseOutput is an extended juint case that adds two new assert
 *         methods. These methods assert that text, supplied either as a String
 *         or in a File, has been output to standard output or standard err. The
 *         text is filtered to simplify comparison of texts using different
 *         formatting by replacing all blocks of whitespace with a single space
 *         character.
 */
public abstract class TestCaseOutput {
    private PrintStream out;
    private PrintStream err;
    private ByteArrayOutputStream baos;

    public void assertOutput(File file) {
        assertOutput("", file);
    }

    public void assertOutput(String result) {
        assertOutput("", result);
    }

    public void assertOutput(String msg, File file) {
        try {
            FileInputStream input = new FileInputStream(file);
            byte buffer[] = new byte[1024];
            StringBuffer s = new StringBuffer();
            try {
                while (input.available() != 0) {
                    int index = input.read(buffer);
                    s.append(new String(buffer, 0, index));
                }
            } catch (IOException e) {
                fail("Error reading " + file.getName());
            }
            assertOutput(msg, s.toString());
        } catch (FileNotFoundException e) {
            fail("File " + file.getName() + " not found");
        }
    }

    public void assertOutput(String msg, String result) {
        String s1 = result;//.replaceAll("\\s+", " ").trim();
        String s2 = baos.toString();//.replaceAll("\\s+", " ").trim();
        assertEquals(msg, s1, s2);
    }

    @Before
    public void setUp() throws Exception {
        out = System.out;
        err = System.err;
        baos = new ByteArrayOutputStream(1024);
        PrintStream ps = new PrintStream(baos);
        System.setOut(ps);
        System.setErr(ps);
    }

    @After
    public void tearDown() throws Exception {
        if (System.out != null && System.out != out) {
            System.setOut(out);
        }
        if (System.err != null && System.err != err) {
            System.setErr(err);
        }
    }
}
