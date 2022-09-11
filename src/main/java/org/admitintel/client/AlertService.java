package org.admitintel.client;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import org.admitintel.model.Alert;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
public interface AlertService {

    @POST
    @Path("/alerts")
    @Consumes(MediaType.APPLICATION_JSON)
    void issueAlerts(List<Alert> alerts);



}
