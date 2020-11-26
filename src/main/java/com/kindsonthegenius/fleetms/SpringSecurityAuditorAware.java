package com.kindsonthegenius.fleetms;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SpringSecurityAuditorAware  implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		
		Authentication authent =  SecurityContextHolder.getContext().getAuthentication();
		
		String name= authent.getName();
		return Optional.ofNullable(name).filter(s -> !s.isEmpty());
	}

}
