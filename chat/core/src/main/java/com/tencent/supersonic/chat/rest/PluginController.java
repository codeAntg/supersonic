package com.tencent.supersonic.chat.rest;

import com.tencent.supersonic.auth.api.authentication.pojo.User;
import com.tencent.supersonic.auth.api.authentication.utils.UserHolder;
import com.tencent.supersonic.chat.api.pojo.request.PluginQueryReq;
import com.tencent.supersonic.chat.plugin.Plugin;
import com.tencent.supersonic.chat.service.PluginService;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/chat/plugin")
public class PluginController {

    private PluginService pluginService;

    public PluginController(PluginService pluginService) {
        this.pluginService = pluginService;
    }

    @PostMapping
    public boolean createPlugin(@RequestBody Plugin plugin,
                      HttpServletRequest httpServletRequest,
                      HttpServletResponse httpServletResponse) {
        User user = UserHolder.findUser(httpServletRequest, httpServletResponse);
        pluginService.createPlugin(plugin, user);
        return true;
    }

    @PutMapping
    public boolean updatePlugin(@RequestBody Plugin plugin,
                                HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse) {
        User user = UserHolder.findUser(httpServletRequest, httpServletResponse);
        pluginService.updatePlugin(plugin, user);
        return true;
    }

    @DeleteMapping("/{id}")
    public boolean deletePlugin(@PathVariable("id") Long id) {
        pluginService.deletePlugin(id);
        return true;
    }

    @RequestMapping("/getPluginList")
    public List<Plugin> getPluginList() {
        return pluginService.getPluginList();
    }

    @PostMapping("/query")
    List<Plugin> query(@RequestBody PluginQueryReq pluginQueryReq) {
        return pluginService.queryWithAuthCheck(pluginQueryReq);
    }

}