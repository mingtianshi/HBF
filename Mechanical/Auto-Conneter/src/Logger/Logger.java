package Logger;

import java.awt.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Logger {
    //当前的时间

    public static final LocalDateTime l = LocalDateTime.now();

    public Logger(){

    }
    static {
        System.out.println(l);
    }

    /**
     * 鼠标位置日志
     * 统计 x y
     */
    public void MouseLog(){
        Timer timer = new Timer();
        timer.schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        LocalDateTime localDateTime = LocalDateTime.now();
                        Point point = MouseInfo.getPointerInfo().getLocation();
                        Duration duration = java.time.Duration.between(l,localDateTime);
                        System.out.println("现在时间是"+LocalDateTime.now() +" "+ "x:"+point.x + "y:" + point.y);
                        System.out.println("耗时："+duration.toMillis() + "ms");
                    }
                },100,100
        );
    }

    /**
     * 鼠标活动任务
     * @return
     */
    public void KeyboardLog() {
        while(true) {
            LocalDateTime localDateTime = LocalDateTime.now();
            Duration duration = java.time.Duration.between(l,localDateTime);
            String a = "";
            Scanner s = new Scanner(System.in);
            a = s.nextLine();
            Long log = duration.toMillis();
            System.out.println("现在时间是" + localDateTime + " " + "以输入按键:" + a);
            try {
                Thread.sleep(3000);
                System.out.println("耗时:" + log + "ms");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //Expression expected
        }
    }

//    public static void main(String[] args) {
//        //bug: 只能够统计一次
//        Logger logger = new Logger();
//        //logger.KeyboardLog();
//    }
}
