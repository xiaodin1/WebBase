package com.fibbery.ticket.bean;

import java.io.Serializable;

/**
 * Created by jiangnenghua on 2016/8/26.
 */
public class LeftTicketDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String Train_date;

    private String From_station;

    private String To_station;

    private String Prupose_code;

    public String getTrain_date() {
        return Train_date;
    }

    public void setTrain_date(String train_date) {
        Train_date = train_date;
    }

    public String getFrom_station() {
        return From_station;
    }

    public void setFrom_station(String from_station) {
        From_station = from_station;
    }

    public String getTo_station() {
        return To_station;
    }

    public void setTo_station(String to_station) {
        To_station = to_station;
    }

    public String getPrupose_code() {
        return Prupose_code;
    }

    public void setPrupose_code(String prupose_code) {
        Prupose_code = prupose_code;
    }
}
