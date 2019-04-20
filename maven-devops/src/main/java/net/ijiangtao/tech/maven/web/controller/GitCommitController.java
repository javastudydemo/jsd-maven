/*
 * Copyright (C) 2008 feilong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ijiangtao.tech.maven.web.controller;

import com.alibaba.fastjson.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

/**
 *
 *
 *
 * @author ijiangtao
 */
@Controller
public class GitCommitController {


    /**
     *
     * @return
     */
    @RequestMapping("/git/commit/info")
    @ResponseBody
    public String showGitCommitInfo(){
        //git.properties
        ResourceBundle resourceBundle = ResourceBundle.getBundle("git", defaultIfNull(null, Locale.getDefault()));

        Map<String, String> map = new TreeMap<>();

        Enumeration<String> keysEnumeration = resourceBundle.getKeys();

        while (keysEnumeration.hasMoreElements()){
            String key = keysEnumeration.nextElement();
            map.put(key, resourceBundle.getString(key));
        }

        JSONObject jsonObject=new JSONObject();
        jsonObject.putAll(map);

        return jsonObject.toJSONString();
    }

    /**
     *
     * @return
     */
    @RequestMapping("/git/commit/id")
    @ResponseBody
    public String showGitCommitId(){
        //git.properties
        ResourceBundle resourceBundle = ResourceBundle.getBundle( "git", defaultIfNull(null, Locale.getDefault()));
        return resourceBundle.getString("git.commit.id");
    }


}