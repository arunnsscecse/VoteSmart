package org.example.voting;

public class Voter {
    private int id;
    private String name;
    private boolean voted;

    public Voter(int id, String name) {
        this.id = id;
        this.name = name;
        this.voted = false;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public boolean hasVoted() { return voted; }
    public void markVoted() { voted = true; }
}