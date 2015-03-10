package org.nodcloud.web.rest;

import java.util.List;

import org.nodcloud.persistent.entity.KeyPair;
import org.nodcloud.web.controller.AbstractController;
import org.nodcloud.web.service.KeypairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.nodcloud.web.common.NodCloudConstruct.DASHBORD_URL_MAP_REST_ROOT;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
@RequestMapping(value = KeyPairRestful.URL_MAPPING)
public class KeyPairRestful extends AbstractController {

    public static final String URL_MAPPING = DASHBORD_URL_MAP_REST_ROOT + "keypairs";

    @Autowired
    private KeypairService keypairService;

    @ResponseBody
    @RequestMapping(method = GET)
    public List<KeyPair> getUserKeyPairs() {

        return keypairService.getAllKeyPair(getCurrentUserId(), getCurrentZone());

    }

}
