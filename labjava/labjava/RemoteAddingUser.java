package labjava;

import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteAddingUser
{
	public static void main(String[] args) throws Exception
	{
		System.out.println("Trying to connect...");
		try{
			
			Registry myReg = LocateRegistry.getRegistry("127.0.0.1",1099);//Get reference to the remote object Registry on the specified host and port
			RemoteAdding aObj = (RemoteAdding) Naming.lookup("newAdd");//Get reference, a stub, for the remote object associated with the specified name.
			System.out.println("Object has been created");
			System.out.println("Result of adding new entry is:");
			System.out.println(aObj.add(args[0],args[1],args[2]));
		}
		catch(RemoteException re)
		{
			System.out.println("A problem happened during adding entry...");
		}
	}
}