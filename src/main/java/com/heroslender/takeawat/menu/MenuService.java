package com.heroslender.takeawat.menu;

import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MenuService {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired MenuRepository repository;

    public Map<String, List<Menu>> getMenus() {
        Map<String, List<Menu>> menus = new HashMap<>();

        for (Menu menu : repository.findAll()) {
            menus.computeIfAbsent(menu.getDate(), k -> new ArrayList<>())
                    .add(menu);
        }

        return menus;
    }

    public List<Menu> getMenus(String date) {
        try {
            return getMenus(DATE_FORMAT.parse(date));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format: " + date + "; expected " + DATE_FORMAT.toPattern());
        }
    }

    public List<Menu> getMenus(Date date) {
        return repository.findByDate(DATE_FORMAT.format(date)).get();
    }
}
