package telegram;

import telegram.domain.User;

import java.util.Date;

/**
 * Created on 12/29/2015.
 */
public class HistoryRecord {

    private User user;
    private Date date;

    public User getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public void setUser(User user) {

        this.user = user;
    }

    public void setDate(Date date) {

        this.date = date;
    }
}
