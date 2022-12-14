package org.admitintel.api;

import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.admitintel.client.AlertService;
import org.admitintel.client.OutcomeService;
import org.admitintel.model.HealthData;
import org.admitintel.rewards.HealthDataService;

@Path("/healthRules")

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HealthDataResource {

    private final Logger log = LoggerFactory.getLogger(HealthDataResource.class);

    @Inject
    HealthDataService healthService;

    @Inject
    @RestClient
    OutcomeService outcomeService;

    @Inject
    @RestClient
    AlertService alertService;

    @POST
    public List<HealthData> processHealthData(List<HealthData> data) {

        healthService.processRules(data);

        data.stream()
                .filter(val -> !val.getOutcomes().isEmpty())
                .forEach(result -> log.info("Outcomes "+ result.getOutcomes()));

        try {
            for (HealthData healthInstance : data) {
                if (healthInstance.getOutcomes() != null) {
                    outcomeService.issueOutcome(healthInstance.getOutcomes());

                }
            }
        }catch(Exception e){
            log.error("Failed to post outcomes ",e);
        }
        data.stream()
                .filter(val -> !val.getAlerts().isEmpty())
                .forEach(result -> log.info("Alerts "+ result.getAlerts()));

        for(HealthData healthInstance : data) {
            if(healthInstance.getAlerts() !=null) {
                alertService.issueAlerts(healthInstance.getAlerts());
            }
        }

        return data;

    }

}
