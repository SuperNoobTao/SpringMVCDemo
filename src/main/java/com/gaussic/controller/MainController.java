package com.gaussic.controller;

import com.gaussic.model.UserEntity;
import com.gaussic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by dzkan on 2016/3/8.
 */
@Controller
public class MainController {

    // 自动装配数据库接口，不需要再写原始的Connection来操作数据库
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/lushi", method = RequestMethod.GET)
    public String lushi() {
        return "/game/lushi";
    }

    @RequestMapping(value = "/wangzhe", method = RequestMethod.GET)
    public String wangzhe() {
        return "/game/wangzhe";
    }
    @RequestMapping(value = "/lol", method = RequestMethod.GET)
    public String lol() {
        return "/game/lol";
    }
    @RequestMapping(value = "/shouwang", method = RequestMethod.GET)
    public String shouwang() {
        return "/game/shouwang";
    }
    @RequestMapping(value = "/zhuji", method = RequestMethod.GET)
    public String zhuji() {
        return "/game/zhuji";
    }
    @RequestMapping(value = "/sanguosha", method = RequestMethod.GET)
    public String sanguosha() {
        return "/game/sanguosha";
    }
    @RequestMapping(value = "/jump", method = RequestMethod.GET)
    public String jump() {
        return "/game/jump";
    }
    @RequestMapping(value = "/wow", method = RequestMethod.GET)
    public String wow() {
        return "/game/wow";
    }
    @RequestMapping(value = "/wolfkill", method = RequestMethod.GET)
    public String wolfkill() {
        return "/game/wolfkill";
    }
    @RequestMapping(value = "/fifa", method = RequestMethod.GET)
    public String fifa() {
        return "/game/fifa";
    }
    @RequestMapping(value = "/cf", method = RequestMethod.GET)
    public String cf() {
        return "/game/cf";
    }
    @RequestMapping(value = "/dota2", method = RequestMethod.GET)
    public String dota2() {
        return "/game/DOTA2";
    }

    @RequestMapping(value = "/liuyanban", method = RequestMethod.GET)
    public String liuyanban() {
        return "/liuyanban";
    }
}
