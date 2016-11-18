
import java.util.*;

public class CountD {
	int countD(String str){

		HashSet<Character> charCount = new HashSet<Character>();

		for(int i = 0; i < str.length(); i++) {

			switch(str.charAt(i)) {

			case 'a':
			case 'b':
			case 'c':
			case 'd':
			case 'e':
			case 'f':
			case 'g':
			case 'h':
			case 'i':
			case 'j':
			case 'k':
			case 'l':
			case 'm':
			case 'n':
			case 'o':
			case 'p':
			case 'q':
			case 'r':
			case 's':
			case 't':
			case 'u':
			case 'v':
			case 'w':
			case 'x':
			case 'y':
			case 'z':
				charCount.add(str.charAt(i));
				break;
			default:
				break;

			}

		}

		return charCount.size();

	}

	public static void main(String[] args) {

		CountD test = new CountD();
		System.out.println(test.countD("abc"));
		System.out.println(test.countD("Abc"));
		System.out.println(test.countD("12345tgfd"));

	}
}
