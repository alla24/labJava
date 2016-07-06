package labjava;

import java.rmi.*;
import java.util.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.lang.Throwable;

public class RemoteAddingImpl extends UnicastRemoteObject implements RemoteAdding{
	RemoteAddingImpl() throws RemoteException{
		super();
	}
	
	public synchronized boolean add(String id,String name, String surname) throws RemoteException //Only one thread can execute inside a synchronized instance method
	{
		try{
			PersonTable table=new PersonTable();
			table.loadData();
			table.add(id, name, surname);
			table.saveData();
			return true;	
		}
		catch (Throwable t){return false;}
	}
	
public synchronized static void main(String args[]) throws Exception
	{
	try{
		Registry reg = LocateRegistry.createRegistry(1099);	//Creates Registry instance on the local host that accepts requests on the specified port. 
		RemoteAdding aObj = new RemoteAddingImpl();
		Naming.rebind("newAdd", aObj);//Rebind the specified name to a new remote object
		System.out.println("Server is ready...");
	}
	catch(Exception ex){
		ex.printStackTrace();
	}
	}
}

