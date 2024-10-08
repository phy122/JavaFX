package application;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class MainController {

	@FXML
	private Button button;

	@FXML
	private ImageView img;

	@FXML
	private Label menu;

	// 메뉴 리스트
	private static final List<String> MENU_LIST = Arrays.asList("국밥", "김밥", "돈까스", "떡볶이", "삼겹살", "초밥", "치킨", "햄버거");

	private static final Random RANDOM = new Random();
	
	private Timeline timeline = null;
	
	private Timeline stop = null;

	/***
	 * FXML 이 로딩될 때 초기화하는 메소드
	 * * 데이터 초기화
	 * * 이벤트 등록
	 */
	@FXML
	public void initialize() {
		setTimer();
	}
	// 추천 버튼 클릭 이벤트 처리
	void setTimer() {
		// 애니메이션 적용
		// * 0.05 초 마다 메뉴 바꾸다가 3초가 되면 멈춰서도록 애니메이션 적용

		// Timeline 주기적으로 처리할 수 있도록 하는 애니메이션 클래스
		 timeline = new Timeline(
				// KeyFrame 객체 지정한 시간마다 익명함수 호출
				// * Duration.millis(밀리초) - 여기서는 0.05 초
				new KeyFrame(Duration.millis(50), e -> {
					updateMenu(); // 랜덤 메뉴 갱신
				}));
		// 애니메이션 반복 횟수 설정 - Timeline.INDEFINITE (무한 반복)
		timeline.setCycleCount(Timeline.INDEFINITE);

		// 3초 후에 정지
		 stop = new Timeline(
				// 3초마다 동작하는 애니메이션 지정
				// - 3초 후 timeline 애니메이션 정지
				new KeyFrame(Duration.millis(3000), e -> timeline.stop()));
		// 애니메이션 반복 횟수 - 1번 반복
		stop.setCycleCount(1);
	}
	
	// 추천 버튼 이벤트 처리
	@FXML
	void buttonClick(ActionEvent event) {
		// 애니메이션 적용
		// * 0.05 초 마다 메뉴 바꾸다가 3초가 되면 딱 멈춰서도록 애니메이션 적용
		timeline.stop();
		stop.stop();
		
		// 애니메이션 시작
		timeline.play();
		stop.play();
	}

	// 랜덤 메뉴 갱신하기
	public void updateMenu() {
		try {
			// 랜덤 메뉴 가져오기
			String menuName = getRandomMenu();
			// 이미지 변경
			URL imgUrl = getClass().getResource("/img/" + menuName + ".jpg");
			if (imgUrl == null) {
				throw new Exception("이미지 파일이 존재하지 않습니다.");
			}
			String filePath = imgUrl.toExternalForm();
			img.setImage(new Image(filePath));
			// 라벨 변경
			menu.setText(menuName);
		} catch (Exception e) {
			menu.setText("다시 눌러주세요!");
			String filePath = getClass().getResource("/img/icon.jpg").toExternalForm();
			img.setImage(new Image(filePath));
		}
	}

	// 랜덤 메뉴 이름 가져오기
	private String getRandomMenu() {
		String randomMenu = MENU_LIST.get(RANDOM.nextInt(MENU_LIST.size()));
		return randomMenu;
	}

}
