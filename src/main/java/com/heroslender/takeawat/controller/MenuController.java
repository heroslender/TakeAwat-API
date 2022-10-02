package com.heroslender.takeawat.controller;

import com.heroslender.takeawat.entity.Menu;
import com.heroslender.takeawat.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/takeawat/v1/menu")
public class MenuController {
    @Autowired MenuService menuService;

    @GetMapping
    public ResponseEntity<Map<String, List<Menu>>> getMenu() {
        return ResponseEntity.ok(menuService.getMenus());
    }

    @GetMapping("/{date}")
    public ResponseEntity<List<Menu>> getMenu(@PathVariable String date) {
        return ResponseEntity.ok(menuService.getMenus(date));
    }
}
