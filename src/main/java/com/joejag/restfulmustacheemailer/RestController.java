package com.joejag.restfulmustacheemailer;

import com.joejag.restfulmustacheemailer.mails.Invite;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.InputStream;

@Controller
public class RestController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody public void sponsorLinkInvite() {
        String body = MustacheCompiler.generate(new Invite(), "invite.mustache");
        EmailSender.send("myemail@here.com", "Welcome to our system!", body);
    }
}
