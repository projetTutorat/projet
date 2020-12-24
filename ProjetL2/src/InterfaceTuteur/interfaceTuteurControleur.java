package InterfaceTuteur;

import java.io.IOException;
import java.sql.SQLException;

import DAO.PersonneDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class interfaceTuteurControleur {
	
	@FXML private Button SeDeconnecter;
	
	
	public void Deconnect(ActionEvent actionEvent) throws ClassNotFoundException, SQLException, IOException {

		PersonneDAO p = new PersonneDAO();
		p.deconnect(SeDeconnecter);
    }



}
