package org.surfnet.oaaas.auth;

import javax.servlet.Filter;
import javax.servlet.ServletRequest;

import org.apache.commons.lang3.StringUtils;

/**
 * Shared functionality of the different authorization and userconsent Filters
 *
 */
public abstract class AbstractFilter implements Filter {

    /**
     * Constant to get the return uri when the control should be returned to the
     * implementor
     */
    public static final String RETURN_URI = "RETURN_URI";

    /**
     * The constant used to keep 'session' state when we give flow control to the
     * authenticator filter. Part of the contract with the authenticator Filter is
     * that we expect to get the value back when authentication is done.
     */
    public static final String AUTH_STATE = "AUTH_STATE";

    /**
     * Get the attribute value that serves as session state.
     * @param request the HttpServletRequest
     */
    public final String getAuthStateValue(ServletRequest request) {
        String authStateValue = (String) request.getAttribute(AUTH_STATE);
        if (StringUtils.isEmpty(authStateValue)) {
            authStateValue = request.getParameter(AUTH_STATE);
        }
        return authStateValue;
    }

    public final String getReturnUri(ServletRequest request) {
        String returnUri = (String) request.getAttribute(RETURN_URI);
        if (StringUtils.isEmpty(returnUri)) {
            returnUri = request.getParameter(RETURN_URI);
        }

        return returnUri;
    }

    protected final void setAuthStateValue(ServletRequest request, String authState) {
        request.setAttribute(AUTH_STATE, authState);
    }
}
