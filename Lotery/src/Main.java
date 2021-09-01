import java.util.List;
import java.lang.*;

public class Main {

    public static void main(String[] args) {
        Service service = new Service();

        List<int[]> result = service.fiveSets();

        for (int[] ints : result) {
            for (int anInt : ints) {
                System.out.print("[ " + anInt + "] ");
            }
            System.out.println("\n");
        }

    }


}


