package application;
	
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	// 화면 A,B 객체 선언
	private Scene sceneA, sceneB;
		@Override
		public void start(Stage primaryStage) {
			
			// 화면 A 생성
			Button swichButton = new Button("B 화면으로 이동");
			// 버튼 클릭 시, 화면 B로 이동
			swichButton.setOnAction(e -> primaryStage.setScene(sceneB));
			StackPane layoutA = new StackPane(swichButton);		// 버튼을 포함하는 컨테이너 생성
			sceneA = new Scene(layoutA, 300, 200);		// sceneA 생성
			
			// 화면 B 생성
			Button backButton = new Button("A 화면으로 이동");
			// 버튼 클릭 시, 화면 A로 이동
			backButton.setOnAction(e -> primaryStage.setScene(sceneA));
			StackPane layoutB = new StackPane(backButton);		// 버튼을 포함하는 컨테이너 생성
			sceneB = new Scene(layoutB, 300, 200);		// sceneA 생성
			
			// 프로그램 아이콘 지정
			Image icon = new Image("icon.png");
			primaryStage.getIcons().add(icon);
			
			// 시작 화면 Scene 설정
			primaryStage.setScene(sceneA);						// 화면 A 로 시작
			primaryStage.setTitle("Java FX - Scene 화면이동");		// 윈도우 타이틀 설정
			primaryStage.show();								// 윈도우 출력
		}
	
	public static void main(String[] args) {
		launch(args);
	}
}
