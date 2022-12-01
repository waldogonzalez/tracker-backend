package com.inendev.tracker.security;

import com.inendev.tracker.domain.CustomUserDetails;
import com.inendev.tracker.domain.User;
import com.inendev.tracker.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByName(userName);

        user.orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return user.map(CustomUserDetails::new).get();
    }

}
