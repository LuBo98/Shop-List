package com.born.list_share.rest;

import com.born.list_share.persistence.DatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequiredArgsConstructor
public class ThymeController {
    private final DatabaseService databaseService;
    @GetMapping("/")
    String getList(Model model) {
        try {
            model.addAttribute("something", "this is comiing from the controller");
            model.addAttribute("items", databaseService.getItemsToGet());

            return "list";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }
}
