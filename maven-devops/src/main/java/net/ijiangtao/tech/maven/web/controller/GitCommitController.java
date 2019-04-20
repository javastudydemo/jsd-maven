package net.ijiangtao.tech.maven.web.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

/**
 * @author ijiangtao
 */
@Controller
@Api(value = "", description = "git info from git-commit-id-plugin")
public class GitCommitController {

    /**
     * @return
     */
    @RequestMapping("/git/commit/info")
    @ResponseBody
    @ApiOperation(value = "get commit info", httpMethod = "GET")
    public String showGitCommitInfo() {
        //git.properties
        ResourceBundle resourceBundle = ResourceBundle.getBundle("git", defaultIfNull(null, Locale.getDefault()));

        Map<String, String> map = new TreeMap<>();

        Enumeration<String> keysEnumeration = resourceBundle.getKeys();

        while (keysEnumeration.hasMoreElements()) {
            String key = keysEnumeration.nextElement();

            map.put(key, resourceBundle.getString(key));
        }

        return JSON.toJSONString(map, SerializerFeature.PrettyFormat);
    }

    /**
     * @return
     */
    @ApiOperation(value = "get commit id", httpMethod = "GET")
    @RequestMapping("/git/commit/id")
    @ResponseBody
    public String showGitCommitId() {
        //git.properties
        ResourceBundle resourceBundle = ResourceBundle.getBundle("git", defaultIfNull(null, Locale.getDefault()));
        return resourceBundle.getString("git.commit.id");
    }


}