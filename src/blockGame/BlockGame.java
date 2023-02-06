package blockGame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BlockGame {
    static class MyFrame extends JFrame{
        //constant 상수
        static int BALL_WIDTH = 20;
        static int BALL_HEIGHT = 20;
        static int BLOCK_ROWS = 5;
        static int BLOCK_COLS = 10;
        static int BLOCK_WIDTH = 40;
        static int BLOCK_HEIGHT = 20;
        static int BLOCK_GAP = 3;
        static int BAR_WIDTH = 80;
        static int BAR_HEIGHT = 20;
        static int CANVAS_WIDTH = 413 + (BLOCK_GAP * BLOCK_COLS) - 1;
        static int CANVAS_HEIGHT = 600;

        //variable 변수
        static MyPanel myPanel = null;
        static int score = 0;
        static Timer timer = null;
        static Block[][] blocks = new Block[BLOCK_ROWS][BLOCK_COLS];
        static Bar bar = new Bar();
        static Ball ball = new Ball();
        static int barXTarget = bar.x;  //Target Value - interpolation
        static int dir = 0; // 0 : up-right . 1 : down-right . 2: up--left . 3 : down-right
        static int ballSpeed = 5;
        static boolean isGameFinished = false;

        static class MyPanel extends JPanel{ //판넬 클래스, 캔버스를 그림
            public MyPanel(){
                this.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
                this.setBackground(Color.black);
            }
            @Override
            public void paint(Graphics g){
                super.paint(g);
                Graphics2D g2d = (Graphics2D)g;

                drawUI( g2d );
            }

            //메서드
            private void drawUI(Graphics2D g2d){
                //블록 그리기
                for(int i = 0; i < BLOCK_ROWS; i++){
                    for(int j = 0; j < BLOCK_COLS; j++){
                        if(blocks[i][j].isHidden){
                            continue;
                        }
                        if(blocks[i][j].color == 0){
                            g2d.setColor(Color.WHITE);
                        }
                        else if(blocks[i][j].color == 1){
                            g2d.setColor(Color.YELLOW);
                        }
                        else if(blocks[i][j].color == 2){
                            g2d.setColor(Color.BLUE);
                        }
                        else if(blocks[i][j].color == 3){
                            g2d.setColor(Color.MAGENTA);
                        }
                        else if(blocks[i][j].color == 4){
                            g2d.setColor(Color.RED);
                        }

                        g2d.fillRect(blocks[i][j].x, blocks[i][j].y,
                                blocks[i][j].width, blocks[i][j].height);
                    }

                    // draw score
                    g2d.setColor(Color.WHITE);
                    g2d.setFont(new Font("TimesRoman", Font.BOLD, 20));
                    g2d.drawString("Score : " + score, (CANVAS_WIDTH / 2) - 30, 30);

                    if(isGameFinished){
                        g2d.setColor(Color.RED);
                        g2d.drawString("Game Finished", (CANVAS_WIDTH / 2) - 35, 50);
                    }


                    // draw Ball
                    g2d.setColor(Color.WHITE);
                    g2d.fillOval(ball.x, ball.y, BALL_WIDTH, BALL_HEIGHT);

                    //draw Bar
                    g2d.setColor(Color.WHITE);
                    g2d.fillRect(bar.x, bar.y, bar.width, bar.height);
                }
            }
        }
        static class Block{ //블록 클래스
            int x = 0;
            int y = 0;
            int width = BLOCK_WIDTH;
            int height = BLOCK_HEIGHT;
            int color = 0; // 0 : white, 1 : yellow, 2 : blue, 3 : mazenta, 4: red
            boolean isHidden = false; // 충돌 후에 블록이 사라짐

        }
        static class Bar{
            int x = (CANVAS_WIDTH / 2) - (BAR_WIDTH / 2);
            int y = CANVAS_HEIGHT - 100;
            int width = BAR_WIDTH;
            int height = BAR_HEIGHT;
        }
        static class Ball{
            //x, y는 공의 위치
            int x = (CANVAS_WIDTH / 2) - (BALL_WIDTH / 2); //캔버스의 너비의 중간에 위치함
            int y = (CANVAS_HEIGHT / 2) - (BALL_HEIGHT / 2);
            int width = BALL_WIDTH;
            int height = BALL_HEIGHT;

            //공의 중심, 아래, 위, 왼쪽, 오른쪽의 지점을 반환
            Point getCenter(){
                return new Point(x + (BALL_WIDTH/2), y + (BALL_HEIGHT));
            }
            Point getBottomCenter(){
                return  new Point(x + (BALL_WIDTH/2), y + (BALL_HEIGHT));
            }
            Point getTopCenter(){
                return  new Point(x + (BALL_WIDTH/2), y );
            }
            Point getLeftCenter(){
                return  new Point(x , y + (BALL_HEIGHT/2));
            }
            Point getRightCenter(){
                return  new Point(x + (BALL_WIDTH), y + (BALL_HEIGHT/2));
            }
        }

        //생성자
        public  MyFrame(String title){
            super(title);
            this.setVisible(true);
            this.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
            this.setLocation(400, 300); //화면 새 창이 뜰 때, 위치 지정
            this.setLayout(new BorderLayout());
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //창이 닫히도록

            initData();

            myPanel = new MyPanel();
            this.add("Center", myPanel);

            setKeyListener();
            startTimer();
        }


        //메서드
        public void initData(){//블록값 초기화
            for(int i = 0; i < BLOCK_ROWS; i++){
                for(int j = 0; j < BLOCK_COLS; j++){
                    blocks[i][j] = new Block();
                    blocks[i][j].x = BLOCK_WIDTH * j + BLOCK_GAP * j;
                    blocks[i][j].y = 100 + i * BLOCK_HEIGHT + BLOCK_GAP * i;
                    blocks[i][j].width = BLOCK_WIDTH;
                    blocks[i][j].height = BLOCK_HEIGHT;
                    blocks[i][j].color = 4 - i; // 0 : white, 1 : yellow, 2 : blue, 3 : mazenta, 4: red
                    blocks[i][j].isHidden = false;
                 }
            }

        }

        public void setKeyListener(){
                this.addKeyListener(new KeyAdapter() {
                    @Override
                    public void keyPressed(KeyEvent e){
                        if(e.getKeyCode() == KeyEvent.VK_LEFT){
                            System.out.println("Pressed Left Key");
                            barXTarget -= 20;
                            if( bar.x < barXTarget){
                                //키 누르기 반복
                                barXTarget = bar.x;
                            }
                        }
                        else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
                            System.out.println("Pressed Right Key");
                            barXTarget += 20;
                            if( bar.x > barXTarget){
                                //키 누르기 반복
                                barXTarget = bar.x;
                            }
                        }
                    }
                });
        }

        public void startTimer(){
            timer = new Timer(20, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    movement();
                    checkCollision();
                    checkCollisionBlock();
                    myPanel.repaint(); //다시 그리기

                    //게임 클리어
                    isGameFinish();
                }
            });
            timer.start(); //타이머 시작시키기
        }
        public void isGameFinish(){
            int count = 0;
            for(int i = 0; i < BLOCK_ROWS; i++){
                for(int j = 0; j < BLOCK_COLS; j++){
                    Block block = blocks[i][j];
                    if(block.isHidden){
                        count++;
                    }
                }
            }
            if(count == BLOCK_COLS * BLOCK_ROWS){
                //게임 종료
                isGameFinished = true;
            }
        }

        public void movement(){
            if(bar.x < barXTarget){
                bar.x += 5;
            } else if(bar.x > barXTarget){
                bar.x -= 5;
            }

            if(dir == 0){
                //up-right
                ball.x += ballSpeed;
                ball.y -= ballSpeed;
            } else if(dir == 1){
                //down-right
                ball.x += ballSpeed;
                ball.y += ballSpeed;
            } else if(dir == 2){
                //down-left
                ball.x -= ballSpeed;
                ball.y -= ballSpeed;
            } else if(dir == 3){
                //up-left
                ball.x -= ballSpeed;
                ball.y += ballSpeed;
            }
        };
        public void checkCollision(){ //벽 또는 막대바와 충돌 체크
            if(dir == 0){ // up-right
                if(ball.y < 0){ //윗쪽 벽과 충돌
                    dir = 1;
                }
                if(ball.x > CANVAS_WIDTH - BALL_WIDTH){ //오른쪽 벽과 충돌
                    dir = 2;
                }
            } else if (dir == 1) { // down-right
                if(ball.y > CANVAS_HEIGHT - BALL_HEIGHT){ //아랫쪽 벽과 충돌
                    //게임 리셋
                    dir = 0;
                    ball.x = (CANVAS_WIDTH / 2) - (BALL_WIDTH / 2);
                    ball.y = (CANVAS_HEIGHT / 2) - (BALL_HEIGHT / 2);
                    score = 0;
                }
                if(ball.x > CANVAS_WIDTH - BALL_WIDTH){ //오른쪽 벽과 충돌
                    dir = 3;
                }

                //Bar와 충돌
                if(ball.getBottomCenter().y >= bar.y){ //공의 y좌표가 바의 y좌표보다 윗쪽
                    if(duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
                            new Rectangle(bar.x, bar.y, bar.width, bar.height))){ //바와 공이 충돌하는지
                        dir = 0;
                    }
                }

            } else if(dir == 2){ // up-left
                //벽과 충돌
                if(ball.y < 0){ //윗쪽 벽과 충돌
                    dir = 3;
                }
                if(ball.x < 0){ //왼쪽 벽과 충돌
                    dir = 0;
                }


            } else if(dir == 3){ // down-left
                //벽과 충돌
                if(ball.x < 0) {// 왼쪽 벽과 충돌
                    dir = 1;
                }
                if(ball.y > CANVAS_HEIGHT - BALL_HEIGHT){ //아랫쪽 벽에 충돌
                    //게임 리셋
                    dir = 0;
                    ball.x = (CANVAS_WIDTH / 2) - (BALL_WIDTH / 2);
                    ball.y = (CANVAS_HEIGHT / 2) - (BALL_HEIGHT / 2);
                    score = 0;
                }

                //Bar와 충돌
                if(ball.getBottomCenter().y >= bar.y){ //공의 y좌표가 바의 y좌표보다 윗쪽
                    if(duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
                            new Rectangle(bar.x, bar.y, bar.width, bar.height))){ //바와 공이 충돌하는지
                        dir = 2;
                    }
                }
            }
        };

        public boolean duplRect(Rectangle rect1,Rectangle rect2){
            //두 사각형의 충돌 여부 체크
            return rect1.intersects(rect2); //두 사각형의 영역이 중복되는지
        }
        public void checkCollisionBlock(){ //블록과 공의 충돌체크
            for(int i=0; i<BLOCK_ROWS; i++) {
                for(int j=0; j<BLOCK_COLS; j++) {
                    Block block = blocks[i][j];
                    if(block.isHidden == false) {
                        if(dir==0) { //0 : Up-Right
                            if( duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
                                    new Rectangle(block.x, block.y, block.width, block.height)) ) {
                                if( ball.x > block.x + 2 &&
                                        ball.getRightCenter().x <= block.x + block.width - 2) {
                                    //block bottom collision
                                    dir = 1;
                                }else {
                                    //block left collision
                                    dir = 2;
                                }
                                block.isHidden = true;
                                if(block.color==0) {
                                    score += 10;
                                }else if(block.color==1) {
                                    score += 20;
                                }else if(block.color==2) {
                                    score += 30;
                                }else if(block.color==3) {
                                    score += 40;
                                }else if(block.color==4) {
                                    score += 50;
                                }
                            }
                        }
                        else if(dir==1) { //1 : Down-Rigth
                            if( duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
                                    new Rectangle(block.x, block.y, block.width, block.height)) ) {
                                if( ball.x > block.x + 2 &&
                                        ball.getRightCenter().x <= block.x + block.width - 2) {
                                    //block top collision
                                    dir = 0;
                                }else {
                                    //block left collision
                                    dir = 3;
                                }
                                block.isHidden = true;
                                if(block.color==0) {
                                    score += 10;
                                }else if(block.color==1) {
                                    score += 20;
                                }else if(block.color==2) {
                                    score += 30;
                                }else if(block.color==3) {
                                    score += 40;
                                }else if(block.color==4) {
                                    score += 50;
                                }
                            }
                        }
                        else if(dir==2) { //2 : Up-Left
                            if( duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
                                    new Rectangle(block.x, block.y, block.width, block.height)) ) {
                                if( ball.x > block.x + 2 &&
                                        ball.getRightCenter().x <= block.x + block.width - 2) {
                                    //block bottom collision
                                    dir = 3;
                                }else {
                                    //block right collision
                                    dir = 0;
                                }
                                block.isHidden = true;
                                if(block.color==0) {
                                    score += 10;
                                }else if(block.color==1) {
                                    score += 20;
                                }else if(block.color==2) {
                                    score += 30;
                                }else if(block.color==3) {
                                    score += 40;
                                }else if(block.color==4) {
                                    score += 50;
                                }
                            }
                        }
                        else if(dir==3) { //3 : Down-Left
                            if( duplRect(new Rectangle(ball.x, ball.y, ball.width, ball.height),
                                    new Rectangle(block.x, block.y, block.width, block.height)) ) {
                                if( ball.x > block.x + 2 &&
                                        ball.getRightCenter().x <= block.x + block.width - 2) {
                                    //block top collision
                                    dir = 2;
                                }else {
                                    //block right collision
                                    dir = 1;
                                }
                                block.isHidden = true;
                                if(block.color==0) {
                                    score += 10;
                                }else if(block.color==1) {
                                    score += 20;
                                }else if(block.color==2) {
                                    score += 30;
                                }else if(block.color==3) {
                                    score += 40;
                                }else if(block.color==4) {
                                    score += 50;
                                }
                            }
                        }
                    }
                }
            }
        }

    }
    public static void main(String[] args) {
        new MyFrame("Block Game");
    }
}
