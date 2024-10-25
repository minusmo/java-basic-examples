package chapter07.array;

import java.util.*;

public class Array_Example04 {
    public static void main(String[] args) {
        /*
            로또 생성
            보너스 번호를 제외한 6개의 난수를 생성하는 코드 작성하기
            1. 입력받은 개수만큼의 게임 생성
            2. 1게임마다 생성되는 6개의 숫자는 1 ~ 45 범위의 랜덤한 정수
            3. 중복되는 숫자 X
            4. 작은 수부터 출력되도록 정렬

            출력 결과
            받을 로또 게임의 개수의 입력해주세요: 5
            ==============================
            *[1]번 : 5 14 25 27 42 44
            *[2]번 : 9 15 16 17 24 27
            *[3]번 : 5 17 29 32 40 41
            *[4]번 : 1 7 9 20 34 44
            *[5]번 : 1 7 22 26 35 38
         */

        Scanner sc = new Scanner(System.in);
        System.out.print("받을 로또 게임의 개수의 입력해주세요: ");
        int games = sc.nextInt();
        int[][] lottoGames = new int[games][6];
        Random r = new Random();

        boolean[] existingNums = new boolean[46];

        for (int i = 0; i < games; i++) {
            for (int j = 0; j < 46; j++) {
                existingNums[j] = false;
            }
            for (int j = 0; j < 6; j++) {
                int randomNum;
                while (true) {
                    randomNum = r.nextInt(46);
                    if (existingNums[randomNum]) continue;
                    existingNums[randomNum] = true;
                    break;
                }
                lottoGames[i][j] = randomNum;
            }
        }

        for (int i = 0; i < games; i++) {
            System.out.printf("*[%d]번 : ",i+1);
            Arrays.sort(lottoGames[i]);
            for (Integer integer : lottoGames[i]) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
