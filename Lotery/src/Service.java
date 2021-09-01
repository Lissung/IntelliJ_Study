import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Service {

    Random randomCycle = new Random();
    List<int[]> lottoSet = new ArrayList();


    public List<int[]> fiveSets(){
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
        int size = 7;
        int[] aSet = new int[size];
        int numberOfLotto = 0;

        while (numberOfLotto < size) {

            int isRandomCycle = randomCycle.nextInt();
            if(isRandomCycle < 0 ) {
                isRandomCycle *= -1;
            } else if(isRandomCycle == 0) {
                continue;
            }

           if(numberOfLotto==0) {
               int ballNumber = this.noIndexZero(isRandomCycle);
               aSet[numberOfLotto] = ballNumber;
//            Arrays.sort(aSet);
            }
           else{
               int ballNumber = this.no(isRandomCycle);
               aSet[numberOfLotto] = ballNumber;
//            Arrays.sort(aSet);
           }

            numberOfLotto++;
        }
        return aSet;
    }

    public int no(int isRandomCycle) {
        int no1 = 0;
        int cycle = 0;

        while (cycle <= isRandomCycle) {
            no1 = randomCycle.nextInt(9) + 1  ;
            cycle++;
        }

        return no1;
    }

    public int noIndexZero(int isRandomCycle) {
        int no0 = 0;
        int cycle = 0;

        while (cycle <= isRandomCycle) {
            no0 = randomCycle.nextInt(5)  + 1 ;
            cycle++;
        }
        return no0;
    }
}
