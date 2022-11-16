package com.heroslender.takeawat.config;

import com.heroslender.takeawat.entity.Menu;
import com.heroslender.takeawat.repository.MenuRepository;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Configuration
public class MenuConfig {
    private static final MenuData[] meat = {
            new MenuData("Bife do Lombo à Jockey", 21.95, "Descrição para Bife do Lombo à Jockey"),
            new MenuData("Bife da Vazia à Portuguesa", 18.40, "Descrição para Bife da Vazia à Portuguesa"),
            new MenuData("Bife da Vazia à Bulhão Pato", 18.40, "Descrição para Bife da Vazia à Bulhão Pato"),
            new MenuData("Bife do Lombo à Café", 21.95, "Descrição para Bife do Lombo à Café"),
            new MenuData("Bife do Lombo à Rota das Índias", 21.95, "Descrição para Bife do Lombo à Rota das Índias"),
            new MenuData("Bife do Lombo Raspado à Alemã", 21.95, "Descrição para Bife do Lombo Raspado à Alemã"),
            new MenuData("Bife do Lombo com Molho Diablo", 21.95, "Descrição para Bife do Lombo com Molho Diablo"),
            new MenuData("Alheira de Caça Tradicional", 16.80, "Descrição para Alheira de Caça Tradicional"),
            new MenuData("Magret de Pato Malvasia", 19.10, "Descrição para Magret de Pato Malvasia"),
            new MenuData("Posta de Vitela", 22.95, "Descrição para Posta de Vitela"),
            new MenuData("Tornedó em Boa Companhia", 22.95, "Descrição para Tornedó em Boa Companhia"),
            new MenuData("Tornedó Com Passas de Uvas", 22.55, "Descrição para Tornedó Com Passas de Uvas"),
            new MenuData("Naco do Lombo na Tábua com Molho Béarnaise", 22.95, "Descrição para Naco do Lombo na Tábua com Molho Béarnaise"),
            new MenuData("Naco do Lombo Especial à Terra e Mar", 26.60, "Descrição para Naco do Lombo Especial à Terra e Mar"),
            new MenuData("Naco do Lombo com Molho Chimichurri", 22.95, "Descrição para Naco do Lombo com Molho Chimichurri"),
            new MenuData("Carne de Porco Ibérico na Cataplana com Amêijoas", 18.80, "Descrição para Carne de Porco Ibérico na Cataplana com Amêijoas"),
            new MenuData("Secretos de Porco Ibérico", 19.10, "Descrição para Secretos de Porco Ibérico"),
            new MenuData("Chateaubriand com Molho Béarnaise (2 Pax)", 48.00, "Descrição para Chateaubriand com Molho Béarnaise (2 Pax)")
    };
    private static final MenuData[] fish = {
            new MenuData("Arroz/Massada de Garoupa com Gambas (2 Pax)", 45.00, "Descrição para Arroz/Massada de Garoupa com Gambas (2 Pax)"),
            new MenuData("Arroz de Marisco Rico (2 Pax)", 48.00, "Descrição para Arroz de Marisco Rico (2 Pax)"),
            new MenuData("Arroz de Tamboril com Gambas (2 Pax)", 41.00, "Descrição para Arroz de Tamboril com Gambas (2 Pax)"),
            new MenuData("Broa de Bacalhau à Jockey", 19.90, "Descrição para Broa de Bacalhau à Jockey"),
            new MenuData("Lombo de Bacalhau na Brasa", 19.10, "Descrição para Lombo de Bacalhau na Brasa"),
            new MenuData("Bacalhau à Narcisa", 19.10, "Descrição para Bacalhau à Narcisa"),
            new MenuData("Lombo de Bacalhau Recheado à Vila Real", 19.95, "Descrição para Lombo de Bacalhau Recheado à Vila Real"),
            new MenuData("Polvo à Lagareiro", 19.10, "Descrição para Polvo à Lagareiro"),
            new MenuData("Cataplana de Bacalhau com Mariscos (2 Pax) ", 44.20, "Descrição para Cataplana de Bacalhau com Mariscos (2 Pax) "),
            new MenuData("Cataplana de Frutos do Mar (2 Pax)", 44.20, "Descrição para Cataplana de Frutos do Mar (2 Pax)"),
            new MenuData("Dourada à Bulhão Pato (Kg)", 44.50, "Descrição para Dourada à Bulhão Pato (Kg)"),
            new MenuData("Robalo no Forno à Portuguesa (Kg)", 45.10, "Descrição para Robalo no Forno à Portuguesa (Kg)"),
            new MenuData("Robalo ao Sal (Kg)", 45.10, "Descrição para Robalo ao Sal (Kg)"),
            new MenuData("Camarão Tigre Grelhado (Kg)", 85.00, "Descrição para Camarão Tigre Grelhado (Kg)")
    };
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Bean
    CommandLineRunner menuConfigRunner(MenuRepository menuRepository) {
        return args -> {
            List<Menu> menus = new ArrayList<>();
            Date date = new Date();
            for (int i = 0; i < 7; i++) {
                appendRandom(meat, menus, date, 2, 5);
                appendRandom(fish, menus, date, 1, 2);

                date.setTime(date.getTime() + TimeUnit.DAYS.toMillis(1));
            }

            menuRepository.saveAllAndFlush(menus);
        };
    }

    private void appendRandom(MenuData[] list, List<Menu> collector, Date date, int minAmount, int maxAmount) {
        SplittableRandom random = new SplittableRandom();
        List<Integer> chosen = new ArrayList<>();
        for (int count = 0; count < random.nextInt(minAmount, maxAmount + 1); count++) {
            MenuData menuData = getRandom(list, chosen, random);
            if (menuData == null) {
                break;
            }

            Menu menu = new Menu(
                    menuData.getName(),
                    dateFormat.format(date),
                    menuData.getPrice(),
                    menuData.getHalfPrice(),
                    menuData.getDescription()
            );
            collector.add(menu);
        }
    }

    private MenuData getRandom(MenuData[] list, List<Integer> ignore, SplittableRandom random) {
        int selected = random.nextInt(list.length);
        if (ignore.contains(selected)) {
            if (ignore.size() >= list.length) {
                return null;
            }

            return getRandom(list, ignore, random);
        }

        return list[selected];
    }

    @Data
    private static final class MenuData {
        private final String name;
        private final double price;
        private final double halfPrice;
        private final String description;

        public MenuData(String name, double price, String description) {
            this.name = name;
            this.price = price;
            this.halfPrice = price * 0.6;
            this.description = description;
        }
    }
}
