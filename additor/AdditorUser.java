package increment;

import java.rmi.*;

public class AdditorUser
{
	public static void main(String[] args) throws Exception
	{
		System.out.println("Trying to connect...");

		String sObjLocation = "rmi://" + args[0] + "/Additor";

		Additor aObj = (Additor) Naming.lookup(sObjLocation);

		System.out.println("Object has been created");
		System.out.println("Result of 3.5 increment is:");

		try
		{
			System.out.println(aObj.incr(3.5));
		}
		catch(RemoteException re)
		{
			System.out.println("A problem happened during increment...");
		}
	}
}
