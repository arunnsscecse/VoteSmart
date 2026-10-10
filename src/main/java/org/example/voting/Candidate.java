package org.example.voting;

public class Candidate {
    private int id;
    private String name;
    private int votes;
    public Candidate(int id,String name,int votes){
        this.id=id;
        this.name=name;
        this.votes=votes;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getVotes(){
        return votes;
    }
    public void addVote(){
        votes++;
    }
}
