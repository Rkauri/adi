import java.util.Timer;
import java.util.TimerTask;

public class Testing  {
	
		
	public static void main(String[] args) {
Timer t1= new Timer();
	t1.schedule(new TimerTask() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("hello");
		}
	}, 0, 1000);
	
	}
	
}
