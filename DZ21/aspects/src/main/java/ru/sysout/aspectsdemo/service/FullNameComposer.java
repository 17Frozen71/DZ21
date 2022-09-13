package ru.sysout.aspectsdemo.service;

import org.springframework.stereotype.Component;
import ru.sysout.aspectsdemo.LogMethod;

import java.util.Locale;
import java.util.ResourceBundle;


@Component
public class FullNameComposer {

    ResourceBundle resource_RU = ResourceBundle.getBundle("text");
    ResourceBundle resource_US = ResourceBundle.getBundle("text", Locale.US);

    @LogMethod
    public String composeFullName(String massege) {
        return resource_US.getString(massege) + resource_RU.getString(massege);
    }
}
