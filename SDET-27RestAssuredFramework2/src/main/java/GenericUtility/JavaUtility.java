package GenericUtility;

import java.util.Random;

/**
 * 
 * @author SUHAS RAVINDRA
 *
 */

public class JavaUtility {
	
	public int RandomNumber()  {
		
		Random ran=new Random();
		int value = ran.nextInt();
		return value;	
	}
}
