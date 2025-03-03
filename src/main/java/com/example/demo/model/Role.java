package com.example.demo.model;

import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
@ToString
public enum Role implements GrantedAuthority {
    /**
     * 👑 KING role: The highest authority in the system.
     * - Has all possible permissions.
     * - Can manage everything, including admins.
     */
    ROLE_KING,

    /**
     * 👨‍💼 ADMIN role: The second highest authority after KING.
     * - Can manage users and system settings.
     * - Cannot override KING’s permissions.
     */
    ROLE_ADMIN,

    /**
     * 🛡 MODERATOR role: Responsible for content and user management.
     * - Can ban users and remove content.
     * - Cannot interfere with ADMIN or KING roles.
     */
    ROLE_MODERATOR,

    /**
     * 👤 USER role: The default role with basic privileges.
     * - Can only view and manage their own data.
     * - Has no administrative permissions.
     */
    ROLE_USER;
    @Override
    public String getAuthority() {
        return name();
    }
}
