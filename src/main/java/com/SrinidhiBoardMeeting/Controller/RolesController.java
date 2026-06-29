package com.SrinidhiBoardMeeting.Controller;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SrinidhiBoardMeeting.Repo.RoleRepository;
import com.SrinidhiBoardMeeting.Service.RoleService;
import com.SrinidhiBoardMeeting.dto.LoadOptionsDto;
import com.SrinidhiBoardMeeting.model.Roles;



@RestController
@RequestMapping("/roles")
public class RolesController {

	@Autowired
	private RoleRepository roleRepo;
	
private final RoleService roleService;
	
	@Autowired
	public RolesController (RoleService roleService) {
		this.roleService = roleService;
	}
	
	
	@GetMapping("/loadOptions")
	    public ResponseEntity <List<LoadOptionsDto>> loadCustomersOptions(){
		 		 	
		 
		 	List<LoadOptionsDto> customers=roleService.loadRoleOptions();
	       
	        return new ResponseEntity<>(customers,HttpStatus.OK);
	    }
	
	
	 @PostMapping("/create")
	    public ResponseEntity<Roles> createdepartment(@RequestBody Roles roles){
		 
		 	String isSaved = "";
		 
		 	roles = roleService.saveRole(roles);
	       
	        return new ResponseEntity<>(roles,HttpStatus.OK);
	    }
	 
	 @GetMapping("/roles")
	    public ResponseEntity <List<Roles>> listRoles(){
		 
		 
		 
		 	List<Roles> roles=roleRepo.findAll();
	       
	        return new ResponseEntity<>(roles,HttpStatus.OK);
	    }
	 
	 @PostMapping("/searchRole")
	    public ResponseEntity<List<Roles>> searchRoles(@RequestBody Roles role){
		 		
		 		String isSaved = "";
				 	
			 	List<Roles> options = roleService.getRoleDetails(role);
		       
		        return new ResponseEntity<>(options,HttpStatus.OK);

	}
	 
}
