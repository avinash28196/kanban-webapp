package com.kanbanBoard.demo.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

@Controller
@Component
public class APIController {

    @RequestMapping(value = "/api/public", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String publicEndpoint() throws JSONException {
        return new JSONObject()
                .put("message", "All good. You DO NOT need to be authenticated to call /api/public.")
                .toString();
    }

    @RequestMapping(value = "/api/private", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String privateEndpoint() throws JSONException {
        return new JSONObject()
                .put("message", "All good. You can see this because you are Authenticated.")
                .toString();
    }

    @RequestMapping(value = "/api/private-scoped", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String privateScopedEndpoint() throws JSONException {
        return new JSONObject()
                .put("message", "All good. You can see this because you are Authenticated with a Token granted the 'read:messages' scope")
                .toString();
    }

}
