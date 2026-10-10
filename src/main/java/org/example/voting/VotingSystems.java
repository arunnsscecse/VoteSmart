

package org.example.voting;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class VotingSystems {
    private final List<Voter> voters = new ArrayList<>();
    private final List<Candidate> candidates = new ArrayList<>();

    public VotingSystems() {
        voters.add(new Voter(1, "AADHIL"));
        candidates.add(new Candidate(101, "Candidate A", 0));
        candidates.add(new Candidate(102, "Candidate B", 0));
    }

    public List<Candidate> getCandidates() { return candidates; }
    public List<Voter> getVoters() { return voters; }

    public String vote(int voterId, int candidateId) {
        for (Voter voter : voters) {
            if (voter.getId() == voterId) {
                if (voter.hasVoted()) {
                    return "Voter has already voted.";
                }
                for (Candidate candidate : candidates) {
                    if (candidate.getId() == candidateId) {
                        candidate.addVote();
                        voter.markVoted();
                        return "Vote successfully added.";
                    }
                }
                return "Candidate not found.";
            }
        }
        return "Voter not found.";
    }
}