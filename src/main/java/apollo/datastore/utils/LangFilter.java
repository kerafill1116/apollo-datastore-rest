package apollo.datastore.utils;

import java.io.IOException;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.NewCookie;

public class LangFilter implements ContainerRequestFilter, ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext)
            throws IOException {

        boolean setCookie = false;
        String language = SupportedLocales.DEFAULT_LANGUAGE;

        if(containerRequestContext.getMethod().equals(HttpMethod.GET)) {
            language = containerRequestContext.getUriInfo().getQueryParameters().getFirst(QueryVariable.LANG.getName());
            if(language != null) {
                language = language.toLowerCase();
                if(!SupportedLocales.LANGUAGES.contains(language))
                    language = SupportedLocales.DEFAULT_LANGUAGE;
                setCookie = true;
            }
        }

        if(!setCookie) {
            Cookie langCookie = containerRequestContext.getCookies().get(CookieVariable.LANG.getName());
            if(langCookie != null)
                language = langCookie.getValue().toLowerCase();
            if(!SupportedLocales.LANGUAGES.contains(language))
                language = SupportedLocales.DEFAULT_LANGUAGE;
        }

        containerRequestContext.setProperty(RequestPropertyVariable.SET_COOKIE.getName(), setCookie);
        containerRequestContext.setProperty(RequestPropertyVariable.LANG.getName(), language);
        containerRequestContext.setProperty(RequestPropertyVariable.DEFAULT_LANG.getName(), SupportedLocales.DEFAULT_LANGUAGE);
        containerRequestContext.setProperty(RequestPropertyVariable.SUPPORTED_LANGUAGES_ARRAY.getName(), SupportedLocales.LANGUAGES.toArray(new String[0]));
        containerRequestContext.setProperty(RequestPropertyVariable.SUPPORTED_LANGUAGES_TEXT_ARRAY.getName(), SupportedLocales.LANGUAGES_TEXT.toArray(new String[0]));
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext)
            throws IOException {

        boolean setCookie = (boolean)containerRequestContext.getProperty(RequestPropertyVariable.SET_COOKIE.getName());
        String language = (String)containerRequestContext.getProperty(RequestPropertyVariable.LANG.getName());

        if(setCookie) {
            NewCookie newLangCookie = new NewCookie(CookieVariable.LANG.getName(), language, CookieVariable.LANG_PATH, null, null, CookieVariable.MAX_AGE, false);
            containerResponseContext.getHeaders().add(HttpHeaders.SET_COOKIE, newLangCookie);
        }
    }
}
