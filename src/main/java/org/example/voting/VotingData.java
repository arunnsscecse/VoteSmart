package org.example.voting;

import java.time.LocalDateTime;
import java.util.*;

public class VotingData {

    public static List<Voter> voters = new ArrayList<>(List.of(
            new Voter(1, "AADHIL"),
            new Voter(2, "AADIDEV"),
            new Voter(3, "AALWIN"),
            new Voter(4, "AAVANI"),
            new Voter(5, "ABDUL-WAHAB"),
            new Voter(6, "ABHAY"),
            new Voter(7, "ABHIJITH"),
            new Voter(8, "ABHIRAM"),
            new Voter(9, "ABHISHEK-I-S"),
            new Voter(10, "ABINA"),
            new Voter(11, "ABIRAJ"),
            new Voter(12, "ABOOBACKER"),
            new Voter(13, "ADWAITH"),
            new Voter(14, "AFLAH"),
            new Voter(15, "AKSHAYA-MR"),
            new Voter(16, "AKSHAYA-KS"),
            new Voter(17, "AKSHAYA-S"),
            new Voter(18, "AMALJITH-KP"),
            new Voter(19, "AMARNATH-CN"),
            new Voter(20, "AMARNATH-EMS"),
            new Voter(21, "AMRUTHA"),
            new Voter(44, "AVANISH")
    ));

    public static List<Candidate> candidates = new ArrayList<>(List.of(
            new Candidate(1, "DANISH-ZENIL-CI", 0),
            new Candidate(2, "CICLIA-D-SURESH", 0)
    ));

    public static LocalDateTime endTime = LocalDateTime.now().plusSeconds(15);

    public static Voter findVoter(int id) {
        for (Voter v : voters) {
            if (v.getId() == id) return v;
        }
        return null;
    }

    public static boolean isElectionOver() {
        boolean allVoted = voters.stream().allMatch(Voter::hasVoted);
        return LocalDateTime.now().isAfter(endTime) || allVoted;
    }

}