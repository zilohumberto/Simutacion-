package redondeo;

public class menu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double i=3.649;
		int vcs=1;
		String h="%."+vcs+"f";
		String a = String.format(h, i);
		System.out.println(a);
	}

}
