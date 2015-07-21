package worksap.co.jp.discount.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Crime implements Serializable{

    private UUID uuid;
    private String title;
    private Date date;
    private boolean solved;


    public Crime() {
        this.uuid = UUID.randomUUID();
        this.date = new Date();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isSolved() {
        return solved;
    }

    public void setSolved(boolean solved) {
        this.solved = solved;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
