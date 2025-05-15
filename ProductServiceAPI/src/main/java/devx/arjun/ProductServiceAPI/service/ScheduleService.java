package devx.arjun.ProductServiceAPI.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ScheduleService {
    //execute at every 10 seconds

    @Scheduled(fixedRate = 10000)
    public void displayHelloWorld() {
        System.out.println("Hello World :" + LocalDateTime.now());
    }

    @Scheduled (cron = "0 * * * * *") //display for every second, min, hour, day, week, month
    public void displayCRON() {
        System.out.println("Display CRON : " + LocalDateTime.now());
    }

    @Scheduled (cron = "0 51 11 * * *") // 9:51 PM every day
    public void displayCROS2() {
        System.out.println("Display CRON2 : " + LocalDateTime.now());
    }

}
