package fastwave.cloud.demo.publisher.controller;

import fastwave.cloud.demo.publisher.domain.AccountDO;
import fastwave.cloud.demo.publisher.domain.TransDO;
import fastwave.cloud.demo.publisher.services.AccountService;
import fastwave.cloud.demo.publisher.services.TransService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    TransService transService;

    @GetMapping("/transfer")
    public String transfer(@RequestParam Map<String, Object> params) throws Exception {

        Integer id1 = Integer.parseInt(params.get("id1").toString());
        Integer id2 = Integer.parseInt(params.get("id2").toString());
        Float amount = Float.parseFloat(params.get("amount").toString());

        return accountService.transfer(id1, id2, amount);
    }
}
