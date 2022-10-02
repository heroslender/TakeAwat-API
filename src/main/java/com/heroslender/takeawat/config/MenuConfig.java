package com.heroslender.takeawat.config;

import com.heroslender.takeawat.entity.Menu;
import com.heroslender.takeawat.repository.MenuRepository;
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
                    new Menu(1L, "Menu 1", "2022-10-01", 10.0, 5.0, "Menu 1 Description"),
                    new Menu(2L, "Menu 2", "2022-10-01", 20.0, 10.0, "Menu 2 Description"),
                    new Menu(3L, "Menu 3", "2022-10-01", 30.0, 15.0, "Menu 3 Description"),
                    new Menu(4L, "Menu 4", "2022-10-02", 10.0, 5.0, "Menu 4 Description"),
                    new Menu(5L, "Menu 5", "2022-10-02", 20.0, 10.0, "Menu 5 Description"),
                    new Menu(6L, "Menu 6", "2022-10-02", 30.0, 15.0, "Menu 6 Description"),
                    new Menu(7L, "Menu 7", "2022-10-03", 10.0, 5.0, "Menu 7 Description"),
                    new Menu(8L, "Menu 8", "2022-10-03", 20.0, 10.0, "Menu 8 Description"),
                    new Menu(9L, "Menu 9", "2022-10-03", 30.0, 15.0, "Menu 9 Description"),
                    new Menu(10L, "Menu 10", "2022-10-04", 10.0, 5.0, "Menu 10 Description"),
                    new Menu(11L, "Menu 11", "2022-10-04", 20.0, 10.0, "Menu 11 Description"),
                    new Menu(12L, "Menu 12", "2022-10-04", 30.0, 15.0, "Menu 12 Description")
            );

            menuRepository.saveAllAndFlush(menus);
        };
    }
}
