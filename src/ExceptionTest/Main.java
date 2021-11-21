package ExceptionTest;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			System.out.println("test");
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			System.out.println("done");
		}
	}

}
