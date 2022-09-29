package com.heroslender.takeawat.menu;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class MenuConfig {

    @Bean
    CommandLineRunner menuConfigRunner(MenuRepository menuRepository) {
        return args -> {
            List<Menu> menus = Arrays.asList(
                    new Menu(1L, "2022-10-01", "Menu 1", 10.0, 5.0, "Menu 1 Description"),
                    new Menu(2L, "2022-10-01", "Menu 2", 20.0, 10.0, "Menu 2 Description"),
                    new Menu(3L, "2022-10-01", "Menu 3", 30.0, 15.0, "Menu 3 Description"),
                    new Menu(4L, "2022-10-02", "Menu 4", 10.0, 5.0, "Menu 4 Description"),
                    new Menu(5L, "2022-10-02", "Menu 5", 20.0, 10.0, "Menu 5 Description"),
                    new Menu(6L, "2022-10-02", "Menu 6", 30.0, 15.0, "Menu 6 Description"),
                    new Menu(7L, "2022-10-03", "Menu 7", 10.0, 5.0, "Menu 7 Description"),
                    new Menu(8L, "2022-10-03", "Menu 8", 20.0, 10.0, "Menu 8 Description"),
                    new Menu(9L, "2022-10-03", "Menu 9", 30.0, 15.0, "Menu 9 Description"),
                    new Menu(10L, "2022-10-04", "Menu 10", 10.0, 5.0, "Menu 10 Description"),
                    new Menu(11L, "2022-10-04", "Menu 11", 20.0, 10.0, "Menu 11 Description"),
                    new Menu(12L, "2022-10-04", "Menu 12", 30.0, 15.0, "Menu 12 Description")
            );

            menuRepository.saveAllAndFlush(menus);
        };
    }
}
