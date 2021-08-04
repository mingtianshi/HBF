package main;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * 设置制作连点器
 * @auother PaiGu
 */
public class test01 {
    Robot robot;
    test01 test01 = new test01();

    //设置时间ms 3倍
    private final static int ms = 500;

    //设置循环次数
    private final static int lime = 3;

    //键盘
    //key 1-26 a-z 27-36 1-0 37 鼠标
    private final static int KEYBOARD_KEY=1;

    //按键次数
    private final static int KEYBOARD_NUM=4;
    //设置鼠标位置
    private final static int MOUSE_POSITION_X = 598;
    private final static int MOUSE_POSITION_Y = 199;


    public test01() {

    }

    public static int getMousePositionY() {
        return MOUSE_POSITION_Y;
    }

    public int MouseSizeX() {
        return 0;
    }


    static {

    }

    /***
     * 主要实现类
     */
    public void robot() {
        //点击事件
        //设置需要按键
        //key 1-26 a-z 27-36 1-0
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(1,KeyEvent.VK_A);
        hashMap.put(2,KeyEvent.VK_B);
        hashMap.put(3,KeyEvent.VK_C);
        hashMap.put(4,KeyEvent.VK_D);
        hashMap.put(5,KeyEvent.VK_E);
        hashMap.put(6,KeyEvent.VK_F);
        hashMap.put(7,KeyEvent.VK_G);
        hashMap.put(8,KeyEvent.VK_H);
        hashMap.put(9,KeyEvent.VK_I);
        hashMap.put(10,KeyEvent.VK_J);
        hashMap.put(11,KeyEvent.VK_K);
        hashMap.put(12,KeyEvent.VK_L);
        hashMap.put(13,KeyEvent.VK_M);
        hashMap.put(14,KeyEvent.VK_N);
        hashMap.put(15,KeyEvent.VK_O);
        hashMap.put(16,KeyEvent.VK_P);
        hashMap.put(17,KeyEvent.VK_Q);
        hashMap.put(18,KeyEvent.VK_R);
        hashMap.put(19,KeyEvent.VK_S);
        hashMap.put(20,KeyEvent.VK_T);
        hashMap.put(21,KeyEvent.VK_U);
        hashMap.put(22,KeyEvent.VK_V);
        hashMap.put(23,KeyEvent.VK_W);
        hashMap.put(24,KeyEvent.VK_S);
        hashMap.put(25,KeyEvent.VK_Y);
        hashMap.put(26,KeyEvent.VK_Z);
        hashMap.put(27,KeyEvent.VK_1);
        hashMap.put(28,KeyEvent.VK_2);
        hashMap.put(29,KeyEvent.VK_3);
        hashMap.put(30,KeyEvent.VK_4);
        hashMap.put(31,KeyEvent.VK_5);
        hashMap.put(32,KeyEvent.VK_6);
        hashMap.put(33,KeyEvent.VK_7);
        hashMap.put(34,KeyEvent.VK_8);
        hashMap.put(35,KeyEvent.VK_9);
        hashMap.put(36,KeyEvent.VK_0);
        hashMap.put(37,KeyEvent.BUTTON1_DOWN_MASK);

        robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        assert robot != null;

        //默认执行速度 500ms
        robot.delay(ms);
        //设置鼠标位置 x y
        robot.mouseMove(MOUSE_POSITION_X, MOUSE_POSITION_Y);

        //鼠标的收放
        robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);

        robot.delay(ms);

        //bug: 需要设计一个可以点击多个按键的 按键系统
        test01.button();
        int i = 1;
        //方案一:给出一个button 按钮如果要加按钮的话就在按钮上加上一个
        if(i < KEYBOARD_NUM) {
            robot.keyPress(hashMap.get(KEYBOARD_KEY));
        }else {
            //出几个键
            //robot.keyPress();

        }
        robot.delay(ms);
        //确定信息
        robot.keyPress(KeyEvent.VK_ENTER);

    }

    public Button button(){

        robot.keyPress(KeyEvent.VK_E);
        return null;
    }

    public int MouseSizeX(int x){
        return x;
    }
    public int MouseSizeY(int y){
        return y;
    }

    public static void main(String[] args) {
        test01 test01 = new test01();
        test01.robot();
    }
}