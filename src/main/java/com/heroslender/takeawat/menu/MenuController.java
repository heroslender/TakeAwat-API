package com.heroslender.takeawat.menu;

import com.heroslender.takeawat.rest.RestResponse;
import com.heroslender.takeawat.rest.RestResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/takeawat/v1/menu")
public class MenuController {
    @Autowired MenuService menuService;

    @GetMapping
    public RestResponse getMenu(@RequestParam(name = "date", required = false) String date) {
        if (date == null) {
            return new RestResponse<>(RestResponseStatus.success(), menuService.getMenus());
        }

        try {
            return new RestResponse<>(RestResponseStatus.success(), menuService.getMenus(date));
        } catch (IllegalArgumentException e) {
            return new RestResponse<>(RestResponseStatus.error(0, e.getMessage()), null);
        }
    }
}
