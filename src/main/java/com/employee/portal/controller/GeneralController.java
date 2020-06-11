package com.employee.portal.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.employee.portal.beans.Ticket;
import com.employee.portal.beans.User;
import com.employee.portal.beans.User1;
import com.employee.portal.repository.UserRepository;
import com.employee.portal.service.TicketService;
import com.employee.portal.service.UserService;

@Controller
public class GeneralController {
	
	@Value("${spring.environment}")
	String environment;
	
	private static Logger logger = LoggerFactory.getLogger(GeneralController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	TicketService ticketservice;
	
	
	@GetMapping("/welcome")
   public String WelcomePage()
   {
		logger.info("we are in welcome method");
		System.out.println("In here");
	   return "welcome";
   }
	@GetMapping("/register")
	public String RegisterPage( Model m)
	{
		logger.info("we are in Register method");
		System.out.println("In register");
		
		m.addAttribute("user", new User());
		return "register";
	}
	
	@GetMapping("/validateform")
   public RedirectView validateUser( @RequestParam(name = "email") String email, @RequestParam String password,RedirectAttributes redir)
	{
		logger.debug("we are in valid user method");
		  System.out.println("In validateUser"); 
		  
		  User user= userService.findByEmailAndPassword(email, password);
		  if(user==null) 
		  {
      	  User newUser = new User();
//			m.addAttribute("user", newUser);
//			  return "register";
			  
			  RedirectView redirectView = new RedirectView("register");
			    redir.addFlashAttribute("user",newUser);
			    return redirectView;
		  }
		//  m.addAttribute("user", user);
		 
		//return "redirect:/welcome";
		  
		  RedirectView redirectView = new RedirectView("welcome");
		    redir.addFlashAttribute("user",user);
		    return redirectView;
	}
	
	//@PostMapping("/adduser")
	 @RequestMapping(value= "/add", method=RequestMethod.POST)
	   public String addUser(@ModelAttribute(name="user") User user, Model m)
		{
			logger.info("we are in add user method");
			System.out.println("In add user"); 
			  userService.newUser(user);
			  m.addAttribute("user", user);
			 
			return "welcome";
		}
	 
	 @GetMapping("/view/{email}")
	   public String ViewTicket(@PathVariable(name="email") String email, Model m)
	   {
		 logger.info("we are calling  View ticket method in  {}",GeneralController.class);
			System.out.println("In ViewTicket");
			User user= userService.findByEmail(email);
			m.addAttribute("tickets",ticketservice.findByEmail(email));
			m.addAttribute("user",user);
			
		   return "view-ticket";
	   }
	 
	 
	 @GetMapping("/raise/ticket")
	 public String raiseTicket(Model m)
	 {
		 m.addAttribute("ticket", new Ticket());
		 return "ticket-raise";
	 }
	 
	 @PostMapping("/add/ticket")
	    public String raiseTicket(@ModelAttribute(name="ticket") Ticket ticket, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	   
	            return "ticket-raise";
	        }
	        
	        logger.info("we are in raise ticket method");
	    	System.out.println("In raise ticket");
	    	
	    	ticketservice.saveTicket(ticket);
			User user= userService.findByEmail(ticket.getEmailAddress());
			model.addAttribute("tickets",ticketservice.findByEmail(ticket.getEmailAddress()));
			model.addAttribute("user",user);
			
		   
	        return "view-ticket";
	    }
	 
	 
	 @PostMapping("/update/ticket/{id}")
	    public String updateTicket(@ModelAttribute(name="ticket") Ticket ticket, @PathVariable String id, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	   
	            return "ticket-raise";
	        }
	        logger.info("we are in  updateTicket method");
	    	System.out.println("In update ticket");
	    	ticket.setId(Integer.parseInt(id));
	    	
	    	ticketservice.updateTicket(ticket);
			User user= userService.findByEmail(ticket.getEmailAddress());
			model.addAttribute("tickets",ticketservice.findByEmail(ticket.getEmailAddress()));
			model.addAttribute("user",user);
			
		   
	        return "view-ticket";
	    }
	 
	 @GetMapping("/delete/ticket/{id}")
	    public String deleteUser(@PathVariable("id") int id, Model model) {
		 
		 logger.info("we are in delete user method");
	        Ticket ticket = ticketservice.findById(id);
	        ticketservice.deleteTicket(ticket);
	        
	        User user= userService.findByEmail(ticket.getEmailAddress());
			model.addAttribute("tickets",ticketservice.findByEmail(ticket.getEmailAddress()));
			model.addAttribute("user",user);
			
		   
	        return "view-ticket";
	    }
	  @GetMapping("/edit/ticket/{id}")
	    public String updateTicket(@PathVariable("id") int id, Model model) {

		  Ticket ticket = ticketservice.findById(id);
	        //ticketservice.deleteTicket(ticket);
	        
	       // User user= userService.findByEmail(ticket.getEmailAddress());
			model.addAttribute("ticket",ticket);
			//model.addAttribute("user",user);
			
		   
	        return "ticket-update";
	    }
	  
	  @GetMapping("/env")
	  public @ResponseBody String checkEnv()
	  {
		  return environment;
	  }
	    
}
