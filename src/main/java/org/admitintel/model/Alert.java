package org.admitintel.model;

import lombok.Data;

@Data
public class Alert {

    private String alertName;
    private String alertType;
    private String channels;
    private String severity;
    private String triggers;
    private String category;

}
