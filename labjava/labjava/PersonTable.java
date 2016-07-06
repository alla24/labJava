package labjava;
import java.util.*;
import java.io.*;


 
public class PersonTable {
	private ArrayList list;

    public PersonTable() {
        list = new ArrayList();
        }	
	 public PersonTable(ArrayList l) {
        list = l;
        }	
    
	public ArrayList get() {
		return list;
		}
		
    public void add(int a,String n,String m) {
        Person obj = new Person(a,n,m);
		list.add(obj);
    }
	
	public void add(String a,String n,String m) {
        Person obj = new Person(Integer.valueOf(a),n,m);
		list.add(obj);
    }
	
	 public String toString() {
        return list.toString();
    }
	 
	 public void print(String title) {
        System.out.println(title);
        Iterator iter = list.iterator();
        for ( int i = 0; iter.hasNext(); i++ ) {
            System.out.println("N "+i+"="+iter.next());
        }
    }
	
	public void saveData(){//save data to the file
        ObjectOutputStream out = null;
        try {
             out = new ObjectOutputStream(new BufferedOutputStream(
                                          new FileOutputStream("PersonTable.ser")));
             out.writeObject(list);
        } catch ( IOException ex ) {
             ex.printStackTrace();
        } finally {
             if ( out != null )
                 try {
                     out.close();
                 } catch ( IOException ex ) {
                     ex.printStackTrace();
                 }
			}
		}
	public void loadData(){//load data from file
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(
                                       new FileInputStream("PersonTable.ser")));
            list = (ArrayList)in.readObject();
        } catch ( IOException ex ) {
            ex.printStackTrace();
        } catch ( Exception ex ) {
            ex.printStackTrace();
        } finally {
             if ( in != null )
                 try {
                     in.close();
                 } catch ( IOException ex ) {
                     ex.printStackTrace();
                 }
			}
        }

    public static void main(String args[]) {//optional initialization of new table, will rewrite existing one!!!
		PersonTable table1=new PersonTable();
        table1.add(1111, "Anna", "Mars");
		table1.add(1114, "Bob", "Kohne");
		table1.add(1111, "Bill", "Rics");
		table1.saveData();
        table1.print("Initial List");
		table1.loadData();
        table1.print("Recreated List");
    }
}
