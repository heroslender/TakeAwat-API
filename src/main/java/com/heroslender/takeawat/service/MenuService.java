package com.heroslender.takeawat.service;

import com.heroslender.takeawat.entity.Menu;
import com.heroslender.takeawat.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class MenuService {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

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
            return getMenus(dateFormat.parse(date));
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format: " + date + "; expected " + dateFormat.toPattern());
        }
    }

    public List<Menu> getMenus(Date date) {
        return repository.findByDate(dateFormat.format(date)).orElse(Collections.emptyList());
    }
}
