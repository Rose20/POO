package view;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;

public  class ConctactController implements Serializable,Runnable {

	private static final long serialVersionUID = 1L;

	String dataFile = "./listeContact.txt";
	
	FileOutputStream fos;
	BufferedOutputStream bos;
	ObjectOutputStream oos;
	
	FileInputStream fis;
	ObjectInputStream ois;
	BufferedInputStream bis;
	protected Vector v = new Vector(5, 3);
	protected int i = 0, k = 0;
	
	public ConctactController()   {
		try {
			fis = new FileInputStream(dataFile);
			bis= new BufferedInputStream(fis);
			ois = new ObjectInputStream(bis);
			v = (Vector) ois.readObject();
			ois.close();
			
			
		} catch (IOException | ClassNotFoundException e) {
		
			e.printStackTrace();
		}
       

			
	}
	  
	
@Override
	public void run() {
		try {
			 fos = new FileOutputStream(dataFile);
			 bos = new BufferedOutputStream(fos);
			 oos = new ObjectOutputStream(bos);
			 oos.writeObject(v);
			 oos.flush();
			 oos.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	
}

public void SauveVector() {
	Thread t;
	t = new Thread(this, "Sauver");
	t.start();

}
	

}
