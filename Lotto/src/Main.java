import java.util.List;
import java.lang.*;

public class Main {

    public static void main(String[] args) {
        Service service = new Service();

        List result = service.fiveSets();

        System.out.println(result.toString());
    }

}

