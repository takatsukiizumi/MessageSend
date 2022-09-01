package com.messagesend.demo;
import cn.hutool.core.swing.clipboard.ImageSelection;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description: TODO
 * @author: scott
 * @date: 2022年06月28日 17:37
 */

@Component
public class Send implements  MessageSend{
    @Override
//    @PostConstruct
//    @Scheduled(cron = "1 1 8,12,17 * * ?")
//    @Scheduled(cron = "0 */10 * * * ?")
    public void Send()  throws AWTException {
        String arg = "test";
//        File file = new File("D:\\123.jpg");
        Robot robot = new Robot();  // 创建Robot对象
        String[] IdKeys = new String[4];   //这里设置你要发送的QQ号，需要已经添加好友
        //路西德QQ群
        IdKeys[0] = "Zj5FmGtvMyxRDWRnMdFsW551M265QNFh&authKey=eWx1EzndNpkC7wV9%2F0iCo9zuFAE2OktWglmAl0x50d51EO%2Fqsov2EDankvAothCg&noverify=0&group_code=917925420";
        //家族QQ群
        IdKeys[1] = "pFT-7bsX3YzaCj_dVT_CtRfeMLYvDfN5&authKey=%2Bblo1IluuBRBxS%2B9HTfKLDdtHR6p5ZuQ7V3soayfSXcsCG2EpsPRKIhCXBJsAguH&noverify=0&group_code=718326159";
        //路西德交易平台
        IdKeys[2] = "9FqhpMmUa0cexJmk_912QiSg1G_i3CbR&authKey=jQIrsEt%2Fvm1Yu%2FjyqWxpZ881OYfprjBTRo4QWClKVa512pi%2BB0vtV%2F24VNX8Ryv9&noverify=0&group_code=945978606";
        //冒险岛战士职业群
        IdKeys[3] = "QySRkR-O0SBAh24UMBMVUOwwIUSi3ZKS&authKey=Av8CvItS3DJhCzGJh3gWzCpPU8jSH%2BoCijrsO7I79Dknvhn8bTeiLKEq2rxE9%2FiV&noverify=0&group_code=595682251";

        for (int i = 0; i < IdKeys.length; i++) {
        String url = "https://qm.qq.com/cgi-bin/qm/qr?k=" + IdKeys[i] ;     //设置调用聊天框url
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
        Transferable selection = new ImageSelection(image);     //构建String的数据类型
        clip.setContents(selection, null);      //添加文本到系统剪切板
        //粘贴功能
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(100);
        robot.keyPress(KeyEvent.VK_ENTER);// 回车发送
//        try {
//            Runtime.getRuntime().exec("taskkill /F /IM chrome.exe"); //杀死浏览器的进程，我这里的浏览器叫“运行此文件”
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        }
    }

}
