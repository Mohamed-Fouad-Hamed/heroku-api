package alf.api.web.payload.response;

import java.util.List;

import alf.api.web.models.UserPrivilages;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private Long id;
	private String username;
	private String email;
	private String image;
	private String language;
	private List<String> roles;
	private List<UserPrivilages> privilages;

	public JwtResponse(String accessToken, Long id, String username, String email, String image, String language,
			List<String> roles, List<UserPrivilages> privilages) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.email = email;
		this.image = image;
		this.language = language;
		this.roles = roles;
		this.privilages = privilages;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getRoles() {
		return roles;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public List<UserPrivilages> getPrivilages() {
		return privilages;
	}

	public void setPrivilages(List<UserPrivilages> privilages) {
		this.privilages = privilages;
	}
}
