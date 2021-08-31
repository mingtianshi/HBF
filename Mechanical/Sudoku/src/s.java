import com.sun.awt.AWTUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

class DoShudu {

    public DoShudu(){

    }

    /*public static void main(String[] args) {
        DoShudu doShudu = new DoShudu();
        int[][] cells = doShudu.newshudu();

        //cells=changeShu(cells,9);
        for(int k=0;k<9;k++){
            for(int i=0;i<9;i++){
                System.out.print(cells[k][i]);
            }
            System.out.println();
        }
    }*/

    public int[][] newshudu(){

        int[][] cells=new int[][]{
                {1,2,3,4,5,6,7,8,9},
                {4,5,6,7,8,9,1,2,3},
                {7,8,9,1,2,3,4,5,6},
                {2,3,1,5,6,4,8,9,7},
                {5,6,4,8,9,7,2,3,1},
                {8,9,7,2,3,1,5,6,4},
                {3,1,2,6,4,5,9,7,8},
                {6,4,5,9,7,8,3,1,2},
                {9,7,8,3,1,2,6,4,5}
        };

        int countH=new Random().nextInt(10);
        for(int k=0;k<countH;k++){
            cells=lineTolie(cells);

        }

        int count=0;
        for(int k=0;k<12;k++){
            count=new Random().nextInt(9);
            cells=changeLine(cells,count);
        }

        int countH2=new Random().nextInt(10);
        for(int k=0;k<countH2;k++){
            cells=lineTolie(cells);
        }
        return cells;
    }

    public static int [][] changeLine(int[][] cells,int m) {//行与行交换
        int n = m;
        int[] temp = new int[9];
        n = ((m + 3) >= 9) ? (m + 3 - 9) : m + 3;
        for (int j = 0; j < 9; j++) {
            temp[j] = cells[m][j];
            cells[m][j] = cells[n][j];
            cells[n][j] = temp[j];
        }
        return cells;
    }

    public static int[][] lineTolie(int[][] cells){//行与列互换

        int temp=0;
        for(int j=0;j<9;j++){
            for(int k=j+1;k<9;k++){
                temp=cells[k][j];
                cells[k][j]=cells[j][k];
                cells[j][k]=temp;
            }
        }
        return cells;
    }
}

class Sudoku extends JFrame {

    private TextField[][] txtGame;

    static int num=20;//空白格数量
    static int guan=5;//关卡数量
    static int add=5;//没关过后增加的空白格数量

    public static void main(String[] args) {
        Sudoku shudu = new Sudoku();
    }

    public Sudoku() {// 对JFrame进行布局初始以及监听设置
        txtGame = new TextField[9][9];// 建立81个TextField对象
        DoShudu shudu = new DoShudu();
        shudu.newshudu();

        int[][] cells = shudu.newshudu();// 获取数独数组
        final JPanel jpl = new JPanel();// 建立JPanel对象
        final int spaceNum = num;// spaceNum表示需要设置空白TextField的数量
        jpl.setLayout(new GridLayout(9, 9));// JPanel布局
        final int[][] cellAn = new int[9][9];// 数独数组的答案
        System.arraycopy(cells, 0, cellAn, 0, cells.length);// 答案从建立的数独数组中Copy
        for (int i = 0; i < 9; i++) {// 把答案从Console打印出来

            for (int j = 0; j < 9; j++) {
                System.out.print(cellAn[i][j]);
            }
            System.out.println();
        } // 打印结束
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(600, 600);
        //窗口居中显示；
        this.setResizable(false);
        this.setTitle("黑马-李德国-数独游戏 9关");

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                txtGame[i][j] = new TextField();
                // 设置TextField背景颜色
                if ((i < 3 && j < 3) || (i < 6 && i >= 3 && j >= 3 && j < 6)
                        || (i < 9 && i >= 6 && j >= 6 && j < 9)) {
                    txtGame[i][j].setBackground(Color.ORANGE);

                }
                if ((i < 6 && i >= 3 && j < 3) || (i < 3 && j >= 6 && j < 9)
                        || (i < 9 && i >= 6 && j >= 3 && j < 6)) {
                    txtGame[i][j].setBackground(Color.GREEN);
                }

                if ((i < 9 && i >= 6 && j < 3) || (i < 3 && j >= 3 && j < 6)
                        || (i < 6 && i >= 3 && j < 9 && j >= 6)) {
                    txtGame[i][j].setBackground(Color.PINK);
                }

                txtGame[i][j].setFont(new Font("Dialog", Font.CENTER_BASELINE,
                        60));// 设置字体大小
                txtGame[i][j].setText(Integer.toString(cells[i][j]));
                txtGame[i][j].setEnabled(false);
                txtGame[i][j].setVisible(true);
                jpl.add(txtGame[i][j]);
                jpl.setVisible(true);
            }

        }

        final int[][] tempArray = new int[spaceNum][2];

        final JFrame jfm = new JFrame("选择数字");
        // 取消JFrame title
        jfm.setUndecorated(true);

        // 增加JFrame拖拽功能
        final Point origin = new Point();
        jfm.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                origin.x = e.getX();
                origin.y = e.getY();
            }
        });
        jfm.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                Point p = jfm.getLocation();
                jfm.setLocation(p.x + e.getX() - origin.x, p.y + e.getY()
                        - origin.y);
            }
        });

        // 设置JFrame为半透明
        AWTUtilities.setWindowOpacity(jfm, 0.7f);

        final JPanel jpnl = new JPanel(new GridLayout(3, 3));

        jfm.setLayout(null);
        jfm.setSize(800,500);
        jfm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jfm.setResizable(false);
        jpnl.setBounds(0, 0, 190, 120);

        jfm.setResizable(false);

        for (int i = 0; i < spaceNum; i++) {// 依据需要空白的TextField数量，随机对TextField设置为空

            final int ranD1 = new Random().nextInt(9);
            final int ranD2 = new Random().nextInt(9);
            tempArray[i][0] = ranD1;
            tempArray[i][1] = ranD2;
            txtGame[ranD1][ranD2].setText("");

            if ((ranD1 < 3 && ranD2 < 3)
                    || (ranD1 < 6 && ranD1 >= 3 && ranD2 >= 3 && ranD2 < 6)
                    || (ranD1 < 9 && i >= 6 && ranD2 >= 6 && ranD2 < 9)) {
                txtGame[ranD1][ranD2].setBackground(Color.ORANGE);

            }
            if ((ranD1 < 6 && ranD1 >= 3 && ranD2 < 3)
                    || (ranD1 < 3 && ranD2 >= 6 && ranD2 < 9)
                    || (ranD1 < 9 && ranD1 >= 6 && ranD2 >= 3 && ranD2 < 6)) {
                txtGame[ranD1][ranD2].setBackground(Color.GREEN);
            }

            if ((ranD1 < 9 && ranD1 >= 6 && ranD2 < 3)
                    || (ranD1 < 3 && ranD2 >= 3 && ranD2 < 6)
                    || (ranD1 < 6 && ranD1 >= 3 && ranD2 < 9 && ranD2 >= 6)) {
                txtGame[ranD1][ranD2].setBackground(Color.PINK);
            }

            txtGame[ranD1][ranD2].addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent mouseevent) {

                    jfm.getContentPane().removeAll();// 移出了所有的组件
                    jpnl.removeAll();

                    for (int f = 0; f < 9; f++) {

                        final Button btn = new Button((f + 1) + "");
                        btn.setForeground(Color.RED);
                        btn.setBackground(Color.WHITE);
                        btn
                                .setFont(new Font("Dialog",
                                        Font.CENTER_BASELINE, 30));
                        btn.addMouseListener(new MouseAdapter() {

                            @Override
                            public void mouseClicked(MouseEvent e) {
                                // TODO Auto-generated method stub
                                txtGame[ranD1][ranD2].setText(btn.getLabel()
                                        + txtGame[ranD1][ranD2].getText());

                            }
                        });

                        jpnl.add(btn);
                    }
                    Button btnDel = new Button(" 清 空 ");
                    btnDel.setForeground(Color.WHITE);
                    btnDel.setBackground(Color.RED);
                    btnDel
                            .setFont(new Font("Dialog", Font.CENTER_BASELINE,
                                    30));
                    btnDel.setBounds(0, 120, 190, 50);
                    btnDel.addMouseListener(new MouseAdapter() {

                        @Override
                        public void mouseClicked(MouseEvent e) {
                            // TODO Auto-generated method stub
                            txtGame[ranD1][ranD2].setText("");

                        }
                    });

                    jfm.add(jpnl);
                    jfm.add(btnDel);
                    jfm.setVisible(true);
                }
            });

            txtGame[ranD1][ranD2].addTextListener(new TextListener() {// 对空白的TextField添加监听，数值发生变化后进行答案对比，如果全部答对在Console打印“good”
                @Override
                public void textValueChanged(TextEvent e) {
                    TextField tmp = (TextField) e.getSource();
                    int count = 0;
                    for (int u = 0; u < spaceNum; u++) {
                        if ((txtGame[tempArray[u][0]][tempArray[u][1]]
                                .getText())
                                .equals(Integer
                                        .toString(cellAn[tempArray[u][0]][tempArray[u][1]]))) {
                            count++;
                        }
                    }
                    if (count == spaceNum) {

                        jpl.removeAll();
                        FlowLayout blt = new FlowLayout();
                        jpl.setLayout(blt);

                        if(num<=3){

                            jpl.add(new JLabel("恭喜你过关"));
                            Button btn = new Button("进入下一关");

                            btn.addMouseListener(new MouseAdapter() {

                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    // TODO Auto-generated method stub
                                    Sudoku.this.dispose();
                                    jfm.dispose();
                                    num=num+add;
                                    new Sudoku();
                                }
                            });

                            jpl.add(btn);
                        }
                        else{
                            jpl.add(new JLabel("恭喜 你已经完成所有关卡！"));
                        }
                        jpl.updateUI();
                        System.out.println("good");
                    }
                }
            });
            txtGame[ranD1][ranD2].setEnabled(true);
        }
        this.add(jpl);
        setVisible(true);
    }
}
