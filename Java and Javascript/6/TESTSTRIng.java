public class TESTSTRIng {
	public static void main(String[] args) {
		Expression3 a = new Divide(new Divide(new Const(1), new Add(new Variable("x"), new Const(0))), new Const(1));
		Expression3 b = a.simplify();
		System.out.println(a.toString());
	    System.out.println(b.toString());
	    return;
	}
}
