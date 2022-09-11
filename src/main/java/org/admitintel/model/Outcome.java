package org.admitintel.model;

import lombok.Data;

@Data
public class Outcome {

    private String alertName;
    private String alertType;
    private String recommendedAction;
    private String triggers;
    private String severity;
    private String category;

}
