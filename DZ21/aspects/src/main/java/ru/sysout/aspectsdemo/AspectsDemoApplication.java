package ru.sysout.aspectsdemo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import ru.sysout.aspectsdemo.service.FullNameComposer;
import ru.sysout.aspectsdemo.service.SomeService;

import java.util.Scanner;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AspectsDemoApplication implements CommandLineRunner {
    @Autowired
    FullNameComposer composer;
    @Autowired
    SomeService service;
    public static void main(String[] args) {
        SpringApplication.run(AspectsDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        composer.composeFullName("start");
        service.someMethod("start");
        composer.composeFullName("attempt");
        service.someMethod("attempt");

        //Создаем рандомное число и инициализируем сканер для дальнейшей работы
        int rnd = (int) (Math.random() * 1000);
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(rnd);

        //Далее идет простой алгоритм, который работает пока не отгадаем число, он подсказывает нужно ли увеличить/уменьшить число
        while (a != rnd) {
            if (a < rnd) {
                composer.composeFullName("more");
                service.someMethod("more");
            }else {
                composer.composeFullName("less");
                service.someMethod("less");
            }
            a = sc.nextInt();
        }

        //Вывод сообщения о победе в игре
        composer.composeFullName("victory");
        service.someMethod("victory");
    }
}