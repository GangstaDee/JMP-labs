package com.jmp.event;

/**
 * Created on 31.01.2016.
 */
public class Event {

    private int eventID;
    private EventType type;
    private EventStatus status;
    private long processingTime;

    public Event(int eventID, EventType type, EventStatus status, long processingTime) {

        this.eventID = eventID;
        this.type = type;
        this.status = status;
        this.processingTime = processingTime;
    }

    public int getEventID() {

        return eventID;
    }

    public void setEventID(int eventID) {

        this.eventID = eventID;
    }

    public EventType getType() {

        return type;
    }

    public void setType(EventType type) {

        this.type = type;
    }

    public EventStatus getStatus() {

        return status;
    }

    public void setStatus(EventStatus status) {

        this.status = status;
    }

    public long getProcessingTime() {

        return processingTime;
    }

    public void setProcessingTime(long processingTime) {

        this.processingTime = processingTime;
    }
}
