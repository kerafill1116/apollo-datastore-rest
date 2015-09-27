package org.surfnet.oaaas.auth.principal;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * {@link Principal} that can contain roles and additional attributes. This is
 * the return Object for AbstractAuthenticator implementations.
 */
public class AuthenticatedPrincipal implements Serializable, Principal {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private final static ObjectMapper mapper = new ObjectMapper().enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
            .enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL)
            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
            .setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

    private String name;

    private Collection<String> roles;

    private Collection<String> groups;

    private boolean adminPrincipal;

    /*
     * Extra attributes, depending on the authentication implementation. Note that we only support String - String attributes as we
     * need to be able to persist the Principal generically
     */
    private Map<String, String> attributes;

    public AuthenticatedPrincipal() {
        super();
    }

    public AuthenticatedPrincipal(String username) {
        this(username, new ArrayList<String>());
    }

    public AuthenticatedPrincipal(String username, Collection<String> roles) {
        this(username, roles, new HashMap<String, String>());
    }

    public AuthenticatedPrincipal(String username, Collection<String> roles, Map<String, String> attributes) {
        this(username, roles, attributes, new ArrayList<String>());
    }

    public AuthenticatedPrincipal(String username, Collection<String> roles, Map<String, String> attributes, Collection<String> groups) {
        this(username, roles, attributes, groups, false);
    }

    public AuthenticatedPrincipal(String username, Collection<String> roles, Map<String, String> attributes, Collection<String> groups, boolean adminPrincipal) {
        this.name = username;
        this.roles = roles;
        this.attributes = attributes;
        this.groups = groups;
        this.adminPrincipal = adminPrincipal;
    }

    /**
     * @return the roles
     */
    public Collection<String> getRoles() {
        return roles;
    }

    /**
     * @return the attributes
     */
    public Map<String, String> getAttributes() {
        return attributes;
    }

    /**
     * Get the given attribute.
     * @param key the attribute key to get.
     * @return String value if attribute found. Null if attribute not found or no attributes at all.
     */
    public String getAttribute(String key) {
        if (attributes == null) {
            return null;
        }
        return attributes.get(key);
    }

    public void addAttribute(String key, String value) {
        if (attributes == null) {
            attributes = new HashMap<String, String>();
        }
        attributes.put(key, value);
    }

    public void addGroup(String name) {
        if (groups == null) {
            groups = new ArrayList<String>();
        }
        groups.add(name);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.security.Principal#getName()
     */
    @Override
    public String getName() {
        return name;
    }

    @JsonIgnore
    public String getDisplayName() {
        return name;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return getClass().getName() + " [name=" + name + ", roles=" + roles + ", attributes=" + attributes + "]";
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(Collection<String> roles) {
        this.roles = roles;
    }

    /**
     * @param attributes the attributes to set
     */
    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public Collection<String> getGroups() {
        return groups;
    }

    public void setGroups(Collection<String> groups) {
        this.groups = groups;
    }

    @JsonIgnore
    public boolean isGroupAware() {
        return !groups.isEmpty();
    }

    public boolean isAdminPrincipal() {
        return adminPrincipal;
    }

    public void setAdminPrincipal(boolean adminPrincipal) {
        this.adminPrincipal = adminPrincipal;
    }

    @JsonIgnore
    public String serialize() {
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Unable to serialize Principal:" + toString(), e);
        }
    }

    @JsonIgnore
    public static AuthenticatedPrincipal deserialize(String json) {
        try {
            return mapper.readValue(json, AuthenticatedPrincipal.class);
        } catch (IOException e) {
            throw new RuntimeException("Unable to serialize Principal:" + json, e);
        }
    }
}
