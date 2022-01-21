import static java.lang.System.out;

public class Program {

    public static void main(String[] args) {
        new Program().program();
    }

    void program() {
        Vehicle v = new Saab95();
	    out.format("My vehicle is %s\n", v.getModelName());
    }
}
