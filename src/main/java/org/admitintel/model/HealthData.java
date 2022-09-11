package org.admitintel.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class HealthData {


    private String patientType;
    private String county;
    private String eventType;

    private List<Outcome> outcomes = new ArrayList<>();
    private List<Alert> alerts = new ArrayList<>();

    public void addOutcome(Outcome outcome) {
        outcomes.add(outcome);
    }

    public void addAlert(Alert alert){
        alerts.add(alert);
    }
}
