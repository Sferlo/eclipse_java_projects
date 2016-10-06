
public class Operation {
	public static void main(String[] args){
		System.out.println(Recursivo2(15,2));
	}
	
	public static int Division(int a, int b){
		if (b > a)
			return 0;
		else return Division(a-b, b) + 1;
	}
	
	public static int Recursivo(int n){
		if(n==0) return n;
		else return Recursivo(n/10) + (n%10);
	}
	
	public static int Recursivo2(int a, int b){
		if(b==0) return a;
		else return Recursivo2(b, a%b);
	}
}
