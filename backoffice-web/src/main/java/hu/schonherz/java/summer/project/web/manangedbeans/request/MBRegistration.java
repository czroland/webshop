package hu.schonherz.java.summer.project.web.manangedbeans.request;

import hu.schonherz.java.summer.project.service.api.service.AgentService;
import hu.schonherz.java.summer.project.web.manangedbeans.view.MBAgent;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Scope("request")
@Data
public class MBRegistration {

    @Autowired
    private MBAgent agent;

    @Autowired
    private AgentService agentService;

    public void doCreate() {
        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        agent.getAgent()
            .getUser()
            .setPassword(bCryptPasswordEncoder.encode(agent.getAgent()
                .getUser()
                .getPassword()));

        agentService.saveAgent(agent.getAgent());
        agent.init();
    }
}
