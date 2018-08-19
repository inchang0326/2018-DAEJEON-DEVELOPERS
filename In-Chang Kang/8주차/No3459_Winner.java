import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class No3459_Winner {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			
			BigInteger N = new BigInteger(br.readLine());
			String winner = "";

			if(N.compareTo(BigInteger.valueOf(2)) > 0) {
				BigInteger pivot = new BigInteger("2");	
				byte cnt = 0;
				
				// 1. ±íÀÌ°¡ È¦¼öÀÎÁö Â¦¼öÀÎÁö ÆÇº°
				while(N.compareTo(pivot) > 0) {
					if(cnt == 2)
						cnt = 0;
					cnt++;
					pivot = pivot.multiply(BigInteger.valueOf(2));
				}
				
				Player player1;
				Player player2;
				
				// 2-1) ±íÀÌ°¡ È¦¼ö¶ó¸é, °ø°Ý : Bob / ¹æ¾î : Alice
				if(cnt % 2 != 0) {
//					System.out.println("È¦¼ö Ãþ");
					player1 = new Defender("Alice");
					player2 = new Attacker("Bob");
				// 2-2) ±íÀÌ°¡ Â¦¼ö¶ó¸é, °ø°Ý : Alice / ¹æ¾î : Bob
				} else {
//					System.out.println("Â¦¼ö Ãþ");
					player1 = new Attacker("Alice");
					player2 = new Defender("Bob");
				}
				
				// 3. °ÔÀÓ ½ÃÀÛ
//				System.out.println(N + "±îÁö!!");
				BigInteger numFromAlice = player1.select(BigInteger.ONE);
//				System.out.println("Alice : " + numFromAlice);
				winner = "Bob";
				while(numFromAlice.compareTo(N) <= 0) {
					BigInteger numFromBob = player2.select(numFromAlice);
//					System.out.println("Bob : " + numFromBob);
					if(numFromBob.compareTo(N) > 0) {
						winner = "Alice";
						break;
					}
					numFromAlice = player1.select(numFromBob);
//					System.out.println("Alice : " + numFromAlice);
				}	
			} else {
				if(N.compareTo(BigInteger.ONE) == 0) {
					winner = "Bob";
				} else {
					winner = "Alice";
				}
			}
			
							
			
			System.out.println("#" + t + " " + winner);
//			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		}
	}	
}

interface Player {
	public BigInteger select(BigInteger num);
	public String getName();
}

class Attacker implements Player {
	private String name;
	public Attacker(String name) {
		this.name = name;
	}
	@Override
	public BigInteger select(BigInteger num) {
		return num.multiply(BigInteger.valueOf(2)).add(BigInteger.ONE);
	}
	@Override
	public String getName() {
		return name;
	}
}

class Defender implements Player {
	private String name;
	public Defender(String name) {
		this.name = name;
	}
	@Override
	public BigInteger select(BigInteger num) {
		return num.multiply(BigInteger.valueOf(2));
	}
	@Override
	public String getName() {
		return name;
	}
}