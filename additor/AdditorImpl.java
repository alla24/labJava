package increment;

import java.rmi.*;
import java.util.*;
import java.rmi.server.*;

public class AdditorImpl extends UnicastRemoteObject
implements Additor 
{
	AdditorImpl() throws RemoteException
	{
		super();
	}
	
	public double incr(double dIn) throws RemoteException
	{
		return (++dIn);	
	}
	
public static void main(String args[]) throws Exception
	{
		Additor aObj = new AdditorImpl();
		String serviceName = "rmi://localhost/Additor";
		Naming.rebind(serviceName, aObj);
	}
}
