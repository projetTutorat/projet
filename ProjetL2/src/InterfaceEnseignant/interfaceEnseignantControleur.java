package InterfaceEnseignant;

import java.io.IOException;
import java.sql.SQLException;

import DAO.PersonneDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class interfaceEnseignantControleur {
	
	@FXML private Button SeDeconnecter;
	
	
	public void Deconnect(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {

		PersonneDAO p = new PersonneDAO();
		p.deconnect(SeDeconnecter);
    }
	
    public void Cr�erUneS�ance(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {
    	
    	
    	
    }
    
    public void getListMesS�ances(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {
    	
 
    	
    }
    
    
}
