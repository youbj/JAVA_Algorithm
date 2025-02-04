import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] rates = {105, 120, 135};
        int seedMoney = Integer.parseInt(st.nextToken());
        int year = Integer.parseInt(st.nextToken());




        if(year==0) {
            System.out.println(seedMoney);
        }
        else if(year<3){
            int answer = seedMoney;

            for(int i=0;i<year;i++){
                answer = (answer*rates[0])/100;
            }
            System.out.println(answer);
        }
        else{
            int [] investment = new int [year+1];

            investment[0] = seedMoney;
            investment[1] = (seedMoney * rates[0])/100;
            investment[2] = (investment[1] * rates[0])/100;

            for(int i=3;i<=year;i++){
                int oneYear = (investment[i-1] * rates[0]) / 100;
                int threeYear = (investment[i-3] * rates[1]) / 100;

                int oneOrThree = Math.max(oneYear,threeYear);

                if(i<5){
                    investment[i] = oneOrThree;
                }
                else{
                    int fiveYear = (investment[i-5] * rates[2]) / 100;
                    investment[i] = Math.max(oneOrThree,fiveYear);
                }
            }
            System.out.println(investment[year]);
        }
        return;
    }
}