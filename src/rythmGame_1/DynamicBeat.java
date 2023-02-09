package rythmGame_1;

import javax.swing.*;
import java.awt.*;

public class DynamicBeat extends JFrame {  //JFrame : GUI기반의 프로그램을 만들기 위해
    private Image screenImage;
    private Graphics screenGraphics;

    private Image introBackground;

    public DynamicBeat(){
        setTitle("Dynamic Beat");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
        setResizable(false); //사용자가 임의로 창 사이즈 변경 불가
        setLocationRelativeTo(null); // 게임 창이 중앙에 뜨도록
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 게임 창을 끄면 프로그램 전체가 종료됨
        setVisible(true); //창이 보여지도록 만듬

        introBackground = new ImageIcon("src/images/introBackground.jpg").getImage();

    }

    @Override
    public void paint(Graphics g){
        //화면을 생성
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 1280x720 크기의 이미지를 만든 뒤,스크린 이미지에 넣음
        screenGraphics = screenImage.getGraphics(); //스크린 이미지를 이용하여 그래픽 객체를 얻어옴
        //생성한 화면에 이미지를 그려 넣어줌
        screenDraw(screenGraphics);
        g.drawImage(screenImage, 0, 0, null); //게임 창에 스크린 이미지가 그려짐
    }
    
    public void screenDraw(Graphics g){
        g.drawImage(introBackground, 0, 0, null);
        this.repaint(); //paint함수를 다시 호출하여 다시 그리도록
    }
}
