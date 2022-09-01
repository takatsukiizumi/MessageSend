package com.messagesend.demo;



import org.springframework.scheduling.annotation.Scheduled;

import java.awt.*;

public interface MessageSend {
    void Send()  throws AWTException;
}
