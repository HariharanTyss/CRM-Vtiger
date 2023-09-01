package Practice;

public class GenerateRandomTest {

	public static void main(String[] args) {
		int n=20;
		String alphanumericString="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		StringBuilder stringbuilder=new StringBuilder(n);
		for (int i = 0; i <n; i++) 
		{
			int index=(int)(alphanumericString.length()*Math.random());
			stringbuilder.append(alphanumericString.charAt(index));
		}
		System.out.println(stringbuilder);
	}

}
