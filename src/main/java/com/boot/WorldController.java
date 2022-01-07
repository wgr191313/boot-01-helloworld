package com.boot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangguanru
 * @date 2022-01-07
 */
@RestController
public class WorldController {

    @RequestMapping("/w")
    public String world66(){
        return "world";
    }
}
