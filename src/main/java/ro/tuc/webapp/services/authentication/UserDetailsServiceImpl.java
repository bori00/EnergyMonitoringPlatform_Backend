package ro.tuc.webapp.services.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ro.tuc.common.entities.Admin;
import ro.tuc.common.entities.Client;
import ro.tuc.common.entities.User;
import ro.tuc.common.repositories.AdminRepository;
import ro.tuc.common.repositories.ClientRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * A Service which allows SPring Security to find a user by their username.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Admin> optAdmin = adminRepository.findByUserName(username);
        if (optAdmin.isPresent()) {
            return new UserDetailsImpl(optAdmin.get());
        }
        Optional<Client> optClient = clientRepository.findByUserName(username);
        if (optClient.isPresent()) {
            return new UserDetailsImpl(optClient.get());
        }
        throw new UsernameNotFoundException("User Not Found with username: " + username);
    }

    /**
     * A class holding the details of a user in the format requested by SPring Security.
     */
    public static class UserDetailsImpl implements UserDetails {

        private final User user;
        private final Collection<GrantedAuthority> authorities;

        public enum Authorities {
            ADMIN,
            CLIENT
        }

        public UserDetailsImpl(Admin admin) {
            this.user = admin;
            this.authorities = List.of(new SimpleGrantedAuthority(Authorities.ADMIN.toString()));
        }

        public UserDetailsImpl(Client client) {
            this.user = client;
            this.authorities = List.of(new SimpleGrantedAuthority(Authorities.CLIENT.toString()));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String getPassword() {
            return user.getPassword();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String getUsername() {
            return user.getUserName();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
