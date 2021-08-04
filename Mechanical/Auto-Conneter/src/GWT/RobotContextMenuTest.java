package GWT;

import main.test01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author mac
 */
public abstract class RobotContextMenuTest extends JFrame implements ActionListener {

    Robot R;
    JPanel JP;
    JButton JBmenu, JBdown;
    JFrame JF;
    RobotContextMenuTest robotContextMenuTest;
    JTextField jtf1, jtf2, jtf3, jtf4,jtf5,jtf6,jtf7;


    public RobotContextMenuTest() {
        try {
            R = new Robot();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JP = new JPanel();
        //按键准备
        getContentPane().add(JP);
        JBmenu = new JButton("Keyboard");
        JBmenu.addActionListener(this);
        JP.add(JBmenu);
        JBdown = new JButton("Mouse");
        JBdown.addActionListener(this);
        JP.add(JBdown);

        //TestBox
        jtf1 = new JTextField("Mouse");
        jtf2 = new JTextField("x");
        jtf2 = new JTextField(MouseSizeX());
        jtf5 = new JTextField();
        jtf3 = new JTextField("y");
        jtf3 = new JTextField();
        jtf6 = new JTextField();
        jtf4 = new JTextField("指定内容+指定长度(只读状态)", 30);

        jtf3.setEnabled(false);
        jtf4.setFont(new Font("谐体", Font.BOLD | Font.ITALIC, 16));
        //设置文本的水平对齐方式
        jtf4.setHorizontalAlignment(JTextField.CENTER);
        JP.add(jtf1);
        JP.add(jtf2);
        JP.add(jtf3);
        JP.add(jtf4);

        JPanel contentPane = new JPanel();

        pack();
        setSize(800, 500);
        setLocationRelativeTo(contentPane);
        //窗口居中显示；
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    static {

    }

    /**
     * 文本框
     * @return
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //点击时间的入口
        if (e.getActionCommand().equals("Menu")) {
            // 获取下一个一样的 new RobotContextMenuTest();
            //鼠标点击收放
            test01 test01 = new test01();
            test01.robot();

            R.keyPress(KeyEvent.VK_CONTEXT_MENU);
            R.keyRelease(KeyEvent.VK_CONTEXT_MENU);
        } else if (e.getActionCommand().equals("Down")) {

            R.keyPress(KeyEvent.VK_DOWN);
            R.keyRelease(KeyEvent.VK_DOWN);
        }
    }

    public abstract int MouseSizeX();

    public static void main(String[] args) {
        RobotContextMenuTest NE = new RobotContextMenuTest() {
            @Override
            public int MouseSizeX() {
                return 0;
            }
        };
    }
//添加想要按键
}
//Add the want button