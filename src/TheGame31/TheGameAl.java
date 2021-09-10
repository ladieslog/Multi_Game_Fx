package TheGame31;

import java.util.Scanner;

public class TheGameAl {
	public void TheGamesPr() {
		Scanner pulls =new Scanner(System.in);
		int a,i=0,k=3,j;
		
		System.out.println("여긴 31게임입니다. 룰은 31를 먼저 외친쪽이 지는겁니다.");
		System.out.println("그리고 한사람에 1~3번까지 외칠수 있습니다.");
		System.out.println("게임을 시작하겠습니다.\n");
		System.out.println("제가선공으로 하겠습니다. 1 2 를 외쳤습니다. 3부터 가능합니다.");
		while(true) {					
			while(true){
				System.out.println("다음숫자를 외쳐주세요 (만약 거절 하고 싶으시면 0을 눌러주세요)");				
				a=pulls.nextInt();
				if(i>2) {
					System.out.println("더이상 숫자를 집어 넣을 수없습니다. 턴이 넘어갑니다.");
					break;
				}else if(a==k) {
					System.out.println(a+"를 눌렀습니다.\n");
					i++; k++;
				}else if(a!=k&&i==0) {
					System.out.println("선택할수 없는 수입니다.(다시입력)");
					System.out.println("어떤수도 입력하지 않았습니다. 1나라도 입력해야만합니다. ");
				}else if(a==0){
					System.out.println("플레이어님의 턴이 넘어갑니다.");
					break;				
				}else {
					
				}
				
				
			}
			for(j=4;j>i;j--) {		
				System.out.println(k+"를 했습니다.");
				k++;
			}
			if(k==31) {
				System.out.println("당신의 패배입니다. ");
				System.out.println("게임을 그만둡니다.");
				break;
			}
			i=0;
			
		}
	}
}
