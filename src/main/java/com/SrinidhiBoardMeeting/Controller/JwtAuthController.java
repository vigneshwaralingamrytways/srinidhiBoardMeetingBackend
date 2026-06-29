package com.SrinidhiBoardMeeting.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SrinidhiBoardMeeting.Service.JwtUserDetailsService;
import com.SrinidhiBoardMeeting.Service.RefreshTokenService;
import com.SrinidhiBoardMeeting.dto.JwtResponse;
import com.SrinidhiBoardMeeting.dto.LoginDto;
import com.SrinidhiBoardMeeting.dto.TokenDto;
import com.SrinidhiBoardMeeting.model.RefreshToken;
import com.SrinidhiBoardMeeting.security.JwtTokenUtil;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class JwtAuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
	private RefreshTokenService refreshTokenService;

	@Autowired
	private TokenDto tokenDto;

	/*
	 * @PostMapping("/signin") public ResponseEntity<?>
	 * createAuthenticationToken(@RequestBody LoginDto authenticationRequest) throws
	 * Exception { authenticate(authenticationRequest.getUsername(),
	 * authenticationRequest.getPassword());
	 * 
	 * final UserDetails userDetails = userDetailsService
	 * .loadUserByUsername(authenticationRequest.getUsername());
	 * 
	 * 
	 * final String token = jwtTokenUtil.generateToken(userDetails);
	 * tokenDto.setToken(token); return ResponseEntity.ok(tokenDto); }
	 */

	@PostMapping("/signin")
	public JwtResponse createAuthenticationToken(@RequestBody LoginDto authenticationRequest) throws Exception {

		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		if (authentication.isAuthenticated()) {
			RefreshToken refreshToken = refreshTokenService.createRefreshToken(authenticationRequest.getUsername());

			return JwtResponse.builder().accessToken(jwtTokenUtil.generateToken(userDetails))
					.token(refreshToken.getToken()).roleId(tokenDto.getRoleId()).userId(tokenDto.getUserId())
					.userName(tokenDto.getPersonName()).machineName(tokenDto.getMachineName())
					.userType(tokenDto.getUserType()).departments(tokenDto.getDepartments())
					.departmentIds(tokenDto.getDepartmentIds()).timeOut(tokenDto.getTimeOut()).build();
		} else {
			throw new UsernameNotFoundException("invalid user request !");
		}
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
