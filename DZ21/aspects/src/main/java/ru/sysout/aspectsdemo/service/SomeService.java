package ru.sysout.aspectsdemo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import ru.sysout.aspectsdemo.WorkTime;
import ru.sysout.aspectsdemo.LoggingAspect;

import java.util.Locale;
import java.util.ResourceBundle;

@Service
@Slf4j
public class SomeService {

    ResourceBundle resource_RU = ResourceBundle.getBundle("text");
    ResourceBundle resource_US = ResourceBundle.getBundle("text", Locale.US);
    private final LoggingAspect loggingAspect;

    public SomeService( LoggingAspect loggingAspect) {
        this.loggingAspect = loggingAspect;
    }

    @WorkTime
    public void someMethod(String massege) throws InterruptedException {
        loggingAspect.log(resource_US.getString(massege),resource_RU.getString(massege));
    }
}
