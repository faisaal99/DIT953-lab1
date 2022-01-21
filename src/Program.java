import static java.lang.System.out;
import java.util.Scanner;

public class Program {

    Scanner sc;

    public static void main(String[] args) {
        new Program().program();
    }

    void program() {
        Vehicle v = new Saab95();
	    out.format("My vehicle is %s", v.getModelName());
    }
}
