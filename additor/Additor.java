package increment;
import java.rmi.*;
public interface Additor extends Remote 
{
	public double incr(double dIn) throws RemoteException;
}
