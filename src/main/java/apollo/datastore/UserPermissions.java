package apollo.datastore;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class UserPermissions {

    @Id
    private String userId;
    private long userPermissions;
    private long sessionPermissions;
    private long sessionLogPermissions;

    private UserPermissions() { }

    public UserPermissions(String userId, long userPermissions, long sessionPermissions, long sessionLogPermissions) {
        this.userId = userId;
        this.userPermissions = userPermissions;
        this.sessionPermissions = sessionPermissions;
        this.sessionLogPermissions = sessionLogPermissions;
    }

    public String getUserId() {
        return userId;
    }

    public long getUserPermissions() {
        return userPermissions;
    }

    public void setUserPermissions(long userPermissions) {
        this.userPermissions = userPermissions;
    }

    public long getSessionPermissions() {
        return sessionPermissions;
    }

    public void setSessionPermissions(long sessionPermissions) {
        this.sessionPermissions = sessionPermissions;
    }

    public long getSessionLogPermissions() {
        return sessionLogPermissions;
    }

    public void setSessionLogPermissions(long sessionLogPermissions) {
        this.sessionLogPermissions = sessionLogPermissions;
    }
}
