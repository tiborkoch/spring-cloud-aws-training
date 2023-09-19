package cloud.training.aws.oauth2.resourceserver.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthenticatedUserDetails {

    private String name;

    private String role;

    public AuthenticatedUserDetails() {
    }

    public AuthenticatedUserDetails(UserDetails user) {
        this.name = user.getUsername();
        this.role = findRole(user);
    }

    private String findRole(UserDetails user) {
        String role = null;
        List<GrantedAuthority> roles = user.getAuthorities().stream()
                .filter(authority -> authority.getAuthority().startsWith("ROLE_"))
                .collect(Collectors.toList());
        if (!roles.isEmpty()) {
            role = roles.get(0).getAuthority();
        }

        return role;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}
