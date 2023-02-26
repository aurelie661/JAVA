package fr.delpharm.esacp.jwt;

public class JwtResponse {

    private final Long userId;
    private final String userName;
    private final Long roleID;

    public JwtResponse(Long long1, String userName, Long roleID) {
        this.userId = long1;
        this.userName = userName;
        this.roleID = roleID;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

	public Long getRoleID() {
		return roleID;
	}
    
    
}
