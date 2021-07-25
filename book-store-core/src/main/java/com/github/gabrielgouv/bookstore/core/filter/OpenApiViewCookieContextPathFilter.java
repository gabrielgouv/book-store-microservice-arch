package com.github.gabrielgouv.bookstore.core.filter;

import io.micronaut.context.annotation.Requires;
import io.micronaut.context.annotation.Value;
import io.micronaut.core.async.publisher.Publishers;
import io.micronaut.http.HttpMethod;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Filter;
import io.micronaut.http.cookie.Cookie;
import io.micronaut.http.filter.HttpServerFilter;
import io.micronaut.http.filter.ServerFilterChain;
import org.reactivestreams.Publisher;

import java.time.Duration;

import static com.github.gabrielgouv.bookstore.core.filter.OpenApiViewCookieContextPathFilter.CONTEXT_PATH_KEY;

@Requires(property = CONTEXT_PATH_KEY)
@Filter(methods = { HttpMethod.GET, HttpMethod.HEAD }, patterns = { "/**/swagger-ui*" })
public class OpenApiViewCookieContextPathFilter implements HttpServerFilter {

    protected static final String CONTEXT_PATH_KEY = "micronaut.server.context-path";
    private static final String CONTEXT_PATH_COOKIE_NAME = "contextPath";

    private final Cookie contextPathCookie;

    OpenApiViewCookieContextPathFilter(@Value("${" + CONTEXT_PATH_KEY + "}") String contextPath) {
        this.contextPathCookie = Cookie.of(CONTEXT_PATH_COOKIE_NAME, contextPath).maxAge(Duration.ofMinutes(2L));
    }

    @Override
    public Publisher<MutableHttpResponse<?>> doFilter(HttpRequest<?> request, ServerFilterChain chain) {
        return Publishers.map(chain.proceed(request), response -> response.cookie(contextPathCookie));
    }

}
