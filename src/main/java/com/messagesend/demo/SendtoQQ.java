package com.messagesend.demo;

import cn.hutool.core.swing.clipboard.ImageSelection;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年07月09日 22:02
 */


@Component
public class SendtoQQ implements MessageSend{
    @Override
//    @Scheduled(cron = "*/5 * * * * ?")
    @Scheduled(cron = "0 0 */1 * * ?")
    public void Send() throws AWTException {
        Robot robot = new Robot();  // 创建Robot对象
        String[] IdKeys = new String[4];   //这里设置你要发送的QQ号，需要已经添加好友
            String url = "http://wpa.qq.com/msgrd?v=3&uin=" + "3288581491" + "&site=qq&menu=yes"; ;     //设置调用聊天框url
            String url2 = "tencent://message/?uin=3288581491";
            String text3 = "发送时间为" + new Date().toString();
            String cmd = "explorer \"" + url + "\"";    //通过cmd命令使用默认浏览器访问url
            try {
                Process proc = Runtime.getRuntime().exec(cmd);  //调用cmd
                proc.waitFor();
            } catch (Exception e) {
                e.printStackTrace();
            }
            robot.delay(5000);      //停顿，为了预留出打开窗口的时间，看电脑性能
            //复制图像到剪贴板
            Image image = null;
            File file = new File("C:\\Users\\wildartist\\Desktop\\forsell.jpg");
            BufferedImage bi;
            try {
                InputStream is=new FileInputStream(file);
                bi = ImageIO.read(is);
                image=(Image)bi;
            } catch (IOException e) {
                e.printStackTrace();
            }
            Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();      //获取系统的剪切板
            Transferable selection1 = new ImageSelection(image);     //构建String的数据类型
            Transferable selection2 = new StringSelection("发送时间为" + new Date().toString());
            clip.setContents(selection1, null);      //添加文本到系统剪切板
            //粘贴功能
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(100);
            robot.keyPress(KeyEvent.VK_ENTER);// 回车发送

            clip.setContents(selection2, null);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(100);
            robot.keyPress(KeyEvent.VK_ENTER);// 回车发送




        try {
            Runtime.getRuntime().exec("taskkill /F /IM chrome.exe"); //杀死浏览器的进程，我这里的浏览器叫“运行此文件”
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}

