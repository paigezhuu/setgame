import java.util.*;

public class setgame {
    public static void main(String[] args) {
        int[][] setArray = new int[81][4];

        for (int i = 0; i < 81; i ++) {
            setArray[i][0] = (int)(i/27);
            setArray[i][1] = (int)((i%27)/9);
            setArray[i][2] = (int)((i%9)/3);
            setArray[i][3] = (int)(i%3);
        }

        List<int[]> cardlist = Arrays.asList(setArray);

        int totalcount = 0;
        int truecount = 0;

        for (int x = 0; x < 1000000; x++) {
            Collections.shuffle(cardlist);

            totalcount += 1;
            truecount += checkSet(cardlist);
        }

        System.out.println(totalcount);
        System.out.println(truecount); 
    }

    public static int checkSet(List<int[]> cardlist) {
        for (int i = 0; i < 12; i++) {
            for (int j = i+1; j < 12; j++) {
                for (int k = j+1; k < 12; k++) {
                    int sum0 = cardlist.get(i)[0] + cardlist.get(j)[0] + cardlist.get(k)[0];
                    int sum1 = cardlist.get(i)[1] + cardlist.get(j)[1] + cardlist.get(k)[1];
                    int sum2 = cardlist.get(i)[2] + cardlist.get(j)[2] + cardlist.get(k)[2];
                    int sum3 = cardlist.get(i)[3] + cardlist.get(j)[3] + cardlist.get(k)[3];

                    if (sum0 % 3 == 0 && sum1 % 3 == 0 && sum2 % 3 == 0 && sum3 % 3 == 0) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }
}
