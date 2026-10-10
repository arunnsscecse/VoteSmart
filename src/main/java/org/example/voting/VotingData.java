package org.example.voting;
import java.time.LocalDateTime;
import java.util.*;

public class VotingData {
    public static List<Voter> voters = new ArrayList<>(List.of(
            new Voter(1, "Arun"),
            new Voter(2, "Kumar"),
            new Voter(3, "Priya")
    ));

    public static List<Candidate> candidates = new ArrayList<>(List.of(
            new Candidate(1, "Candidate A", 0),
            new Candidate(2, "Candidate B", 0),
            new Candidate(3, "Candidate C", 0)
    ));
    public static LocalDateTime endTime = LocalDateTime.now().plusMinutes(1);

    public static Voter findVoter(int id) {
        for (Voter v : voters) if (v.getId() == id) return v;
        return null;
    }

    public static boolean isElectionOver() {
        boolean allVoted = voters.stream().allMatch(Voter::hasVoted);
        return allVoted || java.time.LocalDateTime.now().isAfter(endTime);
    }
}