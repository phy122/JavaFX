package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;

public class Maincontroller {

    @FXML
    private Circle circle;
    
    private double x;
    private double y;
    
    // 키보드 이벤트 등록
    @FXML
    public void initialize() {
    	
    }

    @FXML
    void up(ActionEvent event) {
    	System.out.println("UP");
    	circle.setCenterY(y -= 10);
    }
    
    @FXML
    void down(ActionEvent event) {
    	System.out.println("DOWN");
    	circle.setCenterY(y += 10);
    }

    @FXML
    void left(ActionEvent event) {
    	System.out.println("LEFT");
    	circle.setCenterX(x -= 10);
    }

    @FXML
    void right(ActionEvent event) {
    	System.out.println("RIGHT");
    	circle.setCenterX(x += 10);
    }


}
