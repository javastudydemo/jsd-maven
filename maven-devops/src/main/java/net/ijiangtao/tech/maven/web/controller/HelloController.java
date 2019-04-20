package net.ijiangtao.tech.maven.web.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * CI
 *
 * @author ijiangtao
 * @create 2019-04-19 15:43
 **/
@Controller
@Api(value = "",description = "Hello Maven")
public class HelloController {


    @RequestMapping(value = "/hello")
    @ResponseBody
    @ApiOperation(value = "/hello",httpMethod = "GET")
    public String hello(){
        return "maven";
    }

}
