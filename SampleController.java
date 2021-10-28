package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;

public class SampleController implements Initializable {
	
	@FXML Canvas canvas;
	@FXML Button button1;
	@FXML Button eraser;
	@FXML ColorPicker cp;
	@FXML Button pencil;

	double posX, posY;
	
	@Override
	public void initialize(URL location, 
			ResourceBundle resources) {
		// TODO 自動生成されたメソッド・スタブ
		GraphicsContext gc = canvas.getGraphicsContext2D();
		//筆のサイズ初期値
		int i = 3;
		
		//鉛筆機能
		pencil.setOnAction((ActionEvent event)->{
			gc.setStroke(cp.getValue());
		});
		
		
		//消しゴム機能
		eraser.setOnAction((ActionEvent event)->{
			gc.setStroke(Color.BEIGE);
			gc.setLineWidth(i);
		});
		
		//画用紙の色
		gc.setLineWidth(300);
		gc.setStroke(Color.BEIGE);
		gc.strokeRect(0, 0, 300, 300);
		
		//描く機能
		canvas.setOnMousePressed(e-> {
			posX = e.getX();
			posY = e.getY();
		});
		canvas.setOnMouseDragged(e->{
			gc.setLineWidth(i);
			gc.strokeLine(posX, posY, e.getX(), e.getY());
			posX = e.getX();
			posY = e.getY();
		});
		//削除ボタン機能
		button1.setOnAction((ActionEvent event)->{
			gc.setLineWidth(300);
			gc.setStroke(Color.BEIGE);
			gc.strokeRect(0, 0, 300, 300);
			gc.setStroke(cp.getValue());
		});
		//カラーピッカーで選んだ色を筆につける機能
		cp.setOnAction((ActionEvent event)->{
			gc.setStroke(cp.getValue());
		});
	}
}