package main;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @version 1.0
 */
public class Pro {

    public Pro(){
        int i = 1;

        for (int j = 0; j < 100; j++) {

            Robot robot = null;
            try {
                robot = new Robot();
            } catch (AWTException e) {
                e.printStackTrace();
            }
            assert robot != null;

            //默认执行速度 500ms
            robot.delay(500);
            //设置鼠标位置 x y
            robot.mouseMove(650, 230);
            robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

            robot.delay(500);
            robot.keyPress(KeyEvent.VK_Y);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyPress(KeyEvent.VK_Y);
            robot.keyPress(KeyEvent.VK_U);
            robot.keyPress(KeyEvent.VK_N);
            robot.keyPress(KeyEvent.VK_1);

            robot.delay(500);
            //确定信息
            robot.keyPress(KeyEvent.VK_ENTER);
        }
    }
//




























    public boolean isThree(int n) {
        int d = 0;
        // 0 10 1 - 9
        for(int i = 1;i <= n;i++){
            //ji shu
            if(n % i == 0){
                d++;
            }
            //d == 3
        }
        return d == 3;
    }

    public static void main(String[] args) {
        //Pro a = new Pro();
        int n = 2;
        //2 != 3 3 == 3
        boolean ans = n == 3;
        System.out.println(ans);
    }

}