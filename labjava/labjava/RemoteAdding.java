package labjava;
import java.rmi.*;
public interface RemoteAdding extends Remote 
{
	public boolean add(String id,String name, String surname) throws RemoteException;
}