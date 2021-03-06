package com.example.marko.areyou4real.fragments;

import java.util.ArrayList;

public class Event {
    private String name;
    private String activity;
    private String eventDescription;
    private double time;
    private int latitude;
    private int langitude;
    private int usersNeeded;
    private int usersEntered;
    private String eventId;
    private String idOfTheUserWhoCreatedIt;
    private ArrayList<String> listOfUsersParticipatingInEvent = new ArrayList<>();

    public ArrayList<String> getListOfUsersParticipatingInEvent() {
        return listOfUsersParticipatingInEvent;
    }

    public void setListOfUsersParticipatingInEvent(ArrayList<String> listOfUsersParticipatingInEvent) {
        this.listOfUsersParticipatingInEvent = listOfUsersParticipatingInEvent;
    }

    public String getIdOfTheUserWhoCreatedIt() {
        return idOfTheUserWhoCreatedIt;
    }

    public void setIdOfTheUserWhoCreatedIt(String idOfTheUserWhoCreatedIt) {
        this.idOfTheUserWhoCreatedIt = idOfTheUserWhoCreatedIt;
    }

    public Event() {

    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Event(String idOfTheUserWhoCreatedIt, String name, String activity, double time, int latitude, int langitude, int usersNeeded, String eventDescription) {
        this.idOfTheUserWhoCreatedIt = idOfTheUserWhoCreatedIt;
        this.name = name;
        this.activity = activity;
        this.time = time;
        this.latitude = latitude;
        this.langitude = langitude;
        this.usersNeeded = usersNeeded;
        this.eventDescription = eventDescription;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLangitude() {
        return langitude;
    }

    public void setLangitude(int langitude) {
        this.langitude = langitude;
    }

    public int getUsersNeeded() {
        return usersNeeded;
    }

    public void setUsersNeeded(int usersNeeded) {
        this.usersNeeded = usersNeeded;
    }

    public int getUsersEntered() {
        return usersEntered;
    }

    public void setUsersEntered(int usersEntered) {
        this.usersEntered = usersEntered;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public void addUsersToArray(String userId) {
        listOfUsersParticipatingInEvent.add(userId);
        usersEntered += 1;

    }
    public void addCreatorUserToArray(String userId){
        listOfUsersParticipatingInEvent.add(userId);
    }

    public void removeUserFromEvent(String userIdToBeRemoved) {
        listOfUsersParticipatingInEvent.remove(userIdToBeRemoved);
        usersEntered -= 1;
    }
}
