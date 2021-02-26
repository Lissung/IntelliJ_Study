import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Service {

    Random randomCycle = new Random();
    List lottoSet = new ArrayList();


    public List fiveSets(){
        int numOfSet = 5;
        while(numOfSet >0) {
            int[] aSet = this.goLotto();
            lottoSet.add(aSet);
            for (Object checkLottoSet : lottoSet) {
                if (checkLottoSet==lottoSet){
                    lottoSet.remove(numOfSet);
                }
            }
            numOfSet--;
        }
        return lottoSet;
    }

    public int[] goLotto() {
        int size = 6;
        int[] aSet = new int[size];
        int numberOfLotto = 0;

        while (numberOfLotto < size) {

            int isRandomCycle = randomCycle.nextInt();
            if(isRandomCycle < 0 ) {
                isRandomCycle *= -1;
            } else if(isRandomCycle == 0) {
                continue;
            }

            Boolean isDuplicated = false;
            int ballNumber = this.no(isRandomCycle);
            for (int checkBallNumber : aSet) {
                if(checkBallNumber==ballNumber){
                    //numberOfLotto--;
                    isDuplicated = true;
                    break;
                }
            }

            if(Boolean.TRUE.equals(isDuplicated)) {
                continue;
            }

            aSet[numberOfLotto] = ballNumber;
            Arrays.sort(aSet);


            numberOfLotto++;
        }
        return aSet;
    }

    public int no(int isRandomCycle) {
        int no1 = 0;
        int cycle = 0;

        while (cycle <= isRandomCycle) {
            no1 = randomCycle.nextInt(44) + 1;
            cycle++;
        }

        return no1;
    }

}
