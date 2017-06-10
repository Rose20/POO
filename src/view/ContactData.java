package view;

import java.io.Serializable;

public class ContactData implements Serializable {
	private String nom;
	private String prenom;
	private String PhoneNo1;
	private String PhoneNo2;
	private String email;

	public void setDetails(String nom, String prenom,
			String phoneNo1, String phoneNo2, String email) {

		this.nom = nom;
		this.prenom = prenom;
		PhoneNo1 = phoneNo1;
		PhoneNo2 = phoneNo2;
		this.email = email;
		}
	/**
	* Getters and setters
	* Methodes qui recupère le nom dans le programme
	* @return la valeur du nom
	*/
	public String getnom() {
		return nom;
	}

	public String getprenom() {
		return prenom;
	}

	public String getemail() {
		return email;
	}

	public String getPhoneNo1() {
		return PhoneNo1;
	}

	public String getPhoneNo2() {
		return PhoneNo2;
	}


	
	
}