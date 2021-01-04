package com.cai.high.studGame.model;

/**
 * @author Cai
 * @time 2020-10-07-9:41
 */
public class Player {
    private boolean status = true;
    private String position = "N";
    private Card[] card = new Card[58];
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setCard(Card[] card) {
        this.card = card;
    }

    public boolean isStatus() {
        return status;
    }

    public String getPosition() {
        return position;
    }

    public Card[] getCard() {
        return card;
    }
}
