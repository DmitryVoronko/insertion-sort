import com.dmitryvoronko.App;
import org.junit.Test;

/**
 * Created by Dmitry on 08/09/2016.
 */
public class AppTest {

    private static final String
            BUBBLE = "-bubble",
            INSERT = "-insert",
            SELECT = "-select",
            SHELL = "-shell",
            MERGE = "-merge",
            QUICK = "-quick",
            STRING = "-s", INTEGER = "-i", FLOAT = "-f",
            ASCENDING = "-a", DESCENDING = "-d",
            OUT_TXT = "out.txt",
            STRING_IN_TXT = "C:\\Users\\Dmitry\\Documents\\NetBeansProjects\\insertion-sort\\inS.txt",
            INTEGER_IN_TXT = "C:\\Users\\Dmitry\\Documents\\NetBeansProjects\\insertion-sort\\inI.txt";

    public void testApp(String inputFilePath,
                        String outputFilePath,
                        String dataType,
                        String ascending,
                        String soertMethodType) {
        App app = new App();
        String[] args = {
                inputFilePath,
                outputFilePath,
                dataType,
                ascending,
                soertMethodType
        };
        app.main(args);
    }

    @Test
    public void stringQuick() {
        testApp(STRING_IN_TXT,
                OUT_TXT,
                STRING,
                ASCENDING,
                QUICK);
    }

    @Test
    public void stringBubble() {
        testApp(STRING_IN_TXT,
                OUT_TXT,
                STRING,
                ASCENDING,
                BUBBLE);
    }

    @Test
    public void stringInsert() {
        testApp(STRING_IN_TXT,
                OUT_TXT,
                STRING,
                ASCENDING,
                INSERT);
    }

    @Test
    public void stringSelect() {
        testApp(STRING_IN_TXT,
                OUT_TXT,
                STRING,
                ASCENDING,
                SELECT);
    }

    @Test
    public void stringShell() {
        testApp(STRING_IN_TXT,
                OUT_TXT,
                STRING,
                ASCENDING,
                SHELL);
    }

    @Test
    public void stringMerge() {
        testApp(STRING_IN_TXT,
                OUT_TXT,
                STRING,
                ASCENDING,
                MERGE);
    }

}
