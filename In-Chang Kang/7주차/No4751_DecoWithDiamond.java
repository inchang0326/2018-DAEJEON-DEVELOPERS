import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No4751_DecoWithDiamond {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			String input = br.readLine();
			print(input);
		}
	}

	public static void print(String st) {
		String fir = "..#..";
		String sec = ".#.#.";
		String thi = "#." + st.charAt(0) + ".#";
		String fou = ".#.#.";
		String fif = "..#..";
		for (int i = 1; i < st.length(); i++) {
			fir += ".#..";
			sec += "#.#.";
			thi += "." + st.charAt(i) + ".#";
			fou += "#.#.";
			fif += ".#..";
		}
		System.out.println(fir + "\n" + sec + "\n" + thi + "\n" + fou + "\n" + fif);
	}
}
