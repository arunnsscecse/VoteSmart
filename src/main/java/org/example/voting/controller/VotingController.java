package org.example.voting.controller;
import java.util.*;
import jakarta.servlet.http.HttpSession;
import org.example.voting.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class VotingController {

    @GetMapping("/vote")
    public String votePage(HttpSession session, Model model) {
        Voter voter = (Voter) session.getAttribute("voter");
        if (voter == null) return "redirect:/voter-login";
        if (voter.hasVoted()) return "redirect:/already-voted";
        model.addAttribute("voter", voter);
        model.addAttribute("candidates", VotingData.candidates);
        return "vote";
    }

    @PostMapping("/vote")
    public String submitVote(@RequestParam int candidateId, HttpSession session) {
        Voter voter = (Voter) session.getAttribute("voter");
        if (voter == null) return "redirect:/voter-login";
        if (voter.hasVoted()) return "redirect:/already-voted";

        for (Candidate c : VotingData.candidates) {
            if (c.getId() == candidateId) {
                c.addVote();
                voter.markVoted();
                break;
            }
        }
        session.setAttribute("voterName", voter.getName());
        session.removeAttribute("voter");
        return "redirect:/thank-you";
    }

    @GetMapping("/results")
    public String results(Model model) {
        boolean over = VotingData.isElectionOver();
        model.addAttribute("over", over);
        if (over) {
            List<Candidate> sorted = new ArrayList<>(VotingData.candidates);
            sorted.sort((a, b) -> b.getVotes() - a.getVotes());
            int total = 0;
            for (Candidate c : sorted) total += c.getVotes();
            model.addAttribute("candidates", sorted);
            model.addAttribute("total", total);
            model.addAttribute("winner", sorted.get(0));
        }
        return "results";
    }

    @GetMapping("/thank-you")
    public String thankYou(HttpSession session, Model model) {
        String name = (String) session.getAttribute("voterName");
        if (name == null) return "redirect:/";
        model.addAttribute("voterName", name);
        session.invalidate();
        return "thank-you";
    }

    @GetMapping("/already-voted")
    public String alreadyVoted() {
        return "already-voted";
    }
}