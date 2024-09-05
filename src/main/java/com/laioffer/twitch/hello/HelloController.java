package com.laioffer.twitch.hello;

import net.datafaker.Faker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController //标记了才会去找
public class HelloController {
    // example: 后端反应前段请求
    @GetMapping("/hello")   // 网址后面跟的 XXX，就返回XXX 里的function
    public Person sayHello(@RequestParam(required=false)String locale) {
//        System.out.println("Hello World!!!");
//        return "Hello World!";

        if(locale == null){
                locale = "en_US";
        }
        Faker faker = new Faker(new Locale(locale));


//        Faker faker = new Faker();
        String name = faker.name().fullName();
        String company = faker.company().name();
        String street = faker.address().streetAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String bookTitle = faker.book().title();
        String bookAuthor = faker.book().author();




        String template = "This is %s. I work at %s. I live at %s in %s, %s. My favorite book is %s by %s";
//        return template.formatted(
//                name,
//                company,
//                street,
//                city,
//                state,
//                bookTitle,
//                bookAuthor
//        );

        // 返回一个 JSON 格式
        return new Person(name, company, new Address(street, city, state, null), new Book(bookTitle, bookAuthor));
    }

    @GetMapping("/bob")   // 网址后面跟的 XXX，就返回XXX 里的function
    public String sayHelloToBob() {
        return "Hello Bob!";
    }



}

