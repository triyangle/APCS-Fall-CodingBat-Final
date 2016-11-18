
public class Nand {

	public boolean nand(boolean a, boolean b){

		return (a && b) ? false : true;

	}

	public static void main(String[] args) {

		Nand test = new Nand();
		System.out.println(test.nand(true, true));

	}

}
