package fastwave.cloud.demo.subscriber.controller;

import fastwave.cloud.demo.subscriber.domain.AccountDO;
import fastwave.cloud.demo.subscriber.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/transfer")
    public String transfer(@RequestParam Map<String, Object> params) throws Exception {

        Integer id1 = Integer.parseInt(params.get("id1").toString());
        Integer id2 = Integer.parseInt(params.get("id2").toString());
        Float amount = Float.parseFloat(params.get("amount").toString());

        return accountService.transfer(id1, id2, amount);
    }
}
