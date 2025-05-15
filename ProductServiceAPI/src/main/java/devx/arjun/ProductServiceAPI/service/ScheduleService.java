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
}
