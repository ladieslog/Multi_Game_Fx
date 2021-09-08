package NBaseballGame;

import java.util.Random;
import java.util.Scanner;


public class GameStart {
	public void nBaseBallGame() {
		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
        
        int[] ans = {0, 0, 0};
        for (int i = 0; i < 3; i++){
            boolean overlap = true;
            while (overlap) {
                boolean fail = false;
                int num = rand.nextInt(9)+1;
                for (int j = 0; j < i; j++){
                    if (num == ans[j]){
                        fail = true;
                        break;
                    }
                }
                if (!fail) {
                    ans[i] = num;
                    overlap = false;
                }
            }
        }
       
        int ans_num = ans[0] * 100 + ans[1] * 10 + ans[2];
        System.out.println("정답 : " + ans[0] + ans[1] + ans[2]);

        boolean correct = false;
        int cnt = 0;

        System.out.println("<<< 숫자야구게임 START!! >>>\n");
        while(!correct) {
            cnt++;
            System.out.println("========================");
            System.out.println(cnt + "번째 기회");
           
            boolean overlap = true;
            int strike = 0, ball =0, try_ans=0;
            int[] try_arr = new int[3];
            
            while (overlap) {
            	System.out.print("숫자 입력 : ");
                try_ans = sc.nextInt();
                try_arr[0] = try_ans / 100;
                try_arr[1] = (try_ans % 100) / 10;
                try_arr[2] = try_ans % 10;

                if (try_arr[0] == 0 || try_arr[1] == 0 || try_arr[2] == 0) 
                    System.out.println("0이 포함된 수 입니다.\n다시 입력해주세요.");
                 
                else if (!(try_arr[0] == try_arr[1] || try_arr[0] == try_arr[2] || try_arr[1] == try_arr[2])) 
                    overlap = false;
                else 
                    System.out.println("중복된 숫자가 존재합니다.\n다시 입력해주세요.");
            }

            if (try_ans == ans_num) 
            	correct = true;
            else {
                for (int i = 0; i < 3; i++){
                    for (int j = 0; j < 3; j++){
                        if (try_arr[i] == ans[j]){
                            if (i == j) 
                            	strike++;
                            else 
                            	ball++;
                        }
                    }
                }
                System.out.println("결과 : " + strike + "S " + ball + "B");  
            }
        }
        System.out.println("정답은 " + ans_num + " 이었습니다!");
        System.out.println(cnt + "번 만에 정답을 맞추셨습니다!");
	}
}

