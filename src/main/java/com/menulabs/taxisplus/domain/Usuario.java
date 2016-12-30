package com.menulabs.taxisplus.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false, updatable = false)
    private Long id;
    
    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;

    @Column(name = "PASSWORD_HASH", nullable = false)
    private String passwordHash;

    @Column(name = "ROLE", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	@Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username +
                ", passwordHash='" + passwordHash.substring(0, 10) +
                ", role=" + role +
                '}';
}

}
