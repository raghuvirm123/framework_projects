package org.jforce.voteApp.controller;

import java.util.Optional;

import org.jforce.voteApp.model.candidateDetails;
import org.jforce.voteApp.model.candidateDetails1;
import org.jforce.voteApp.model.candidateDetails2;
import org.jforce.voteApp.model.candidateDetails3;
import org.jforce.voteApp.model.userDetails;
import org.jforce.voteApp.model.votingDetails;
import org.jforce.voteApp.repository.candidate2Repository;
import org.jforce.voteApp.repository.candidate3Repository;
import org.jforce.voteApp.repository.candidate4Repository;
import org.jforce.voteApp.repository.candidateRepository;
import org.jforce.voteApp.repository.userRepository;
import org.jforce.voteApp.repository.voterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class user_candidate_controller {

	@Autowired
	private userRepository userrepo;

	@Autowired
	private voterRepo voterrepo;

	//--------------------------------------
	@Autowired
	private candidateRepository canrepo;
	
	@Autowired
	private candidate2Repository canrepo1;

	@Autowired
	private candidate3Repository canrepo2;

	@Autowired
	private candidate4Repository canrepo3;

	@GetMapping({ "/list-voting", "/" })
	public ModelAndView getvote() {
		ModelAndView mav = new ModelAndView("list-voting");
		mav.addObject("votings", canrepo.findAll());

		return mav;
	}

	@GetMapping({ "/list-voting1", "/" })
	public ModelAndView getvote2() {
		ModelAndView mav = new ModelAndView("list-voting1");
		mav.addObject("votings2", canrepo1.findAll());

		return mav;
	}

	@GetMapping({ "/list-voting2", "/" })
	public ModelAndView getvote3() {
		ModelAndView mav = new ModelAndView("list-voting2");
		mav.addObject("votings3", canrepo2.findAll());

		return mav;
	}

	@GetMapping({ "/list-voting3", "/" })
	public ModelAndView getvote4() {
		ModelAndView mav = new ModelAndView("list-voting3");
		mav.addObject("votings4", canrepo3.findAll());

		return mav;
	}

//	@GetMapping({"/list-voting2"})
//	public ModelAndView getvote2() {
//		ModelAndView mav1=new ModelAndView("list-voting2");
//		mav1.addObject("votings2",canrepoo.findAll());
//		
//		return mav1;
//	}

	// login
	@GetMapping("/login")
	public String Login(Model model) {
		userDetails user = new userDetails();
		model.addAttribute(user);

		votingDetails voter = new votingDetails();
		model.addAttribute(voter);
		return "login";
	}

	// register
	@GetMapping("/register")
	public String crateRegister() {
		return "register";
	}

	// adminpage
	@GetMapping("/adminPage")
	public String Daminp() {
		return "adminPage";
	}

	// voting page
	@GetMapping("/voting")
	public String vote() {

		return "voting";
	}

	// wrong details page
	@GetMapping("/weongDetails")
	public String wrongdetails() {
		return "weongDetails";
	}

	// for user/admin login
	@PostMapping("/userLogin")
	public String loginUser(@ModelAttribute userDetails user, @ModelAttribute votingDetails voter) {

		String username = user.getUsername();
		String password = user.getPassword();

		String username1 = voter.getUsername();
		String password1 = voter.getPassword();
		Optional<userDetails> userdata = userrepo.findById(username);
//			Optional<userDetails> userdata2 = userrepo.findById(password);

		Optional<votingDetails> userdata1 = voterrepo.findById(username);
		votingDetails canD = voterrepo.save(voter);
		try {
			try {
				if (voter.getPassword().equals(userdata1.get().getPassword())
						&& (!username.equals("admin") && !password.equals("admin"))) {
					return "reVote";
				}

				if (user.getPassword().equals(userdata.get().getPassword())) {

					return "voting";

				} else if (username.equals("admin") && password.equals("admin")) {
					return "adminPage";
				}

				else {
					return "redirect:/weongDetails";
				}

			} catch (Exception e) {
				if (user.getPassword().equals(userdata.get().getPassword())) {

					return "voting";

				} else
					return "voting";
			}
		} catch (Exception e) {
			return ("redirect:/weongDetails");

		}

	}

	// for save votes
//		@PostMapping("/voting/login")
//		public String createCandidate(candidateDetails candidate,@ModelAttribute votingDetails voter) 
//		{
//			votingDetails canD1 = voterrepo.save(voter);
//			candidateDetails canD = canrepo.save(candidate);
//     		return "login";
//			
//		}

	// for save votes
	@PostMapping("/voting")
	public String createCandidate(candidateDetails candidate, candidateDetails1 can1, candidateDetails2 can2,
			candidateDetails3 can3) {

		candidateDetails canD = canrepo.save(candidate);
		candidateDetails1 canE = canrepo1.save(can1);
		candidateDetails2 canF = canrepo2.save(can2);
		candidateDetails3 canG = canrepo3.save(can3);
		return "reVote";
	}

	// for user registration
	@PostMapping("/createUSer")
	public String createUSe(@ModelAttribute userDetails user1) {
		// userDetails userD=userrepo .save(user1);
		// return "login";

		String username1 = user1.getUsername();
		String password1 = user1.getPassword();
		Optional<userDetails> userdata1 = userrepo.findById(username1);
		Optional<userDetails> userdata2 = userrepo.findById(password1);
		userDetails userD = userrepo.save(user1);

		try {

			if (username1.equals(userdata1.get().getUsername())) {

				return "reRegister";

			} else {
				return "redirect:/login";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "registerSuccess";
		}
	}


}
