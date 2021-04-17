package com.dv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author diosvo
 */
@Controller
public class StatsController {

    @GetMapping("stats")
    public String stats() {
        return "stats";
    }
}
