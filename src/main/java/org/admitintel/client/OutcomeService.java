package org.admitintel.client;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.admitintel.model.Outcome;

@RegisterRestClient
public interface OutcomeService {

    @POST
    @Path("/outcomes")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    void issueOutcome(List<Outcome> outcome);
}
