package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DetailController {

    @FXML
    private Label myLabel;
    
    @FXML
    private ImageView image;

	public void passData(String currentFood) {
		System.out.println("전달받은 데이터 : " + currentFood);
		myLabel.setText(currentFood);
		
		String filepath = getClass().getResource("/img/" + currentFood + ".jpg").toExternalForm();
		image.setImage(new Image(filepath));
		
	}

}
