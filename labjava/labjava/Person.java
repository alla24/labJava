package labjava;

import java.io.*;

public class Person implements Serializable {

    private String idnumber;
	private String name;
	private String surname;

    public Person(int numb,String n,String s) {
        idnumber = String.valueOf(numb);
		name=n;
		surname=s;
    }
    
    public Person(String numb,String n,String s) {
        idnumber = numb;
		name=n;
		surname=s;
    }

    public Person() {
        idnumber = null;
		name="";
		surname="";
    }

	public String getID() {return this.idnumber;}
	public String getName() {return this.name;}	
	public String getSurname() {return this.surname;}
	
    public String toString() {
        return " "+": "+idnumber+" "+name+" "+surname;
    }
}