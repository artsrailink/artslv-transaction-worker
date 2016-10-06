package co.kereta.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gemuruhgeo on 20/09/16.
 */
@RestController
public class TransactionWokerController {
    @RequestMapping(value = "/ping")
    public String ping(){
        return "ALIVE";
    }
}
