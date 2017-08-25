package hu.schonherz.java.summer.project.web.manangedbeans.request;

import lombok.Data;
import org.primefaces.event.FlowEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value = "productUpdateBean")
@Scope("request")
@Data
public class MBProductUpdate {

    public String onFlowProcess(FlowEvent event) {
        return event.getNewStep();
    }
}
