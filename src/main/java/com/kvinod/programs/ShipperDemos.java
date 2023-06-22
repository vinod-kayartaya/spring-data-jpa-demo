package com.kvinod.programs;

import com.kvinod.config.AppConfig;
import com.kvinod.service.ShipperService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ShipperDemos {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {
            ShipperService service = ctx.getBean(ShipperService.class);

            service.getAllShippers()
                    .forEach(System.out::println);
        }
    }
}
