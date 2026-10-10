package org.example.voting.controller;

import jakarta.servlet.http.HttpSession;
import org.example.voting.Voter;
import org.example.voting.VotingData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() { return "login"; }

    @GetMapping("/voter-login")
    public String voterLogin() { return "voter-login"; }

    @GetMapping("/view-result")
    public String viewResult() {
        return "redirect:/results";
    }

    @PostMapping("/voter-login")
    public String doLogin(@RequestParam String voterId, HttpSession session, Model model) {
        try {
            Voter voter = VotingData.findVoter(Integer.parseInt(voterId.trim()));
            if (voter == null) {
                model.addAttribute("error", "Invalid Voter ID");
                return "voter-login";
            }
            session.setAttribute("voter", voter);
            return "redirect:/vote";
        } catch (NumberFormatException e) {
            model.addAttribute("error", "Enter a valid number");
            return "voter-login";
        }
    }
}