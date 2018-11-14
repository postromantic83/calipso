package ru.gazpromneft_at.kspd;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.gazpromneft_at.kspd.model.Messaga;

@RestController
@RequestMapping("/health")
public class HealthController {

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String hello(){
        return new String("Hello world! Welcome to ESB-DMZ!");
    }

    @RequestMapping(value = "/getTestMessage")
    @ResponseBody
    public Messaga getTestMessage(){
        return new Messaga(1l, "TestMessage", "CORR_ID1");
    }
}
