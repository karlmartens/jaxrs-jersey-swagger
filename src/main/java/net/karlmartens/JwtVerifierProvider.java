package net.karlmartens;

import javax.annotation.Priority;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Provider
@Priority(Priorities.AUTHORIZATION)
public class JwtVerifierProvider implements ContainerRequestFilter {

    @Context
    private ResourceInfo _resourceInfo;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Method method = _resourceInfo.getResourceMethod();
        if (!filter(requestContext, method)) {
            Class<?> clazz = _resourceInfo.getResourceClass();
            filter(requestContext, clazz);
        }
    }

    private boolean filter(ContainerRequestContext requestContext, AnnotatedElement element) {
        if (element.isAnnotationPresent(PermitAll.class))
            return true;

        if (element.isAnnotationPresent(DenyAll.class)) {
            requestContext.abortWith(Response.status(Response.Status.FORBIDDEN).build());
            return true;
        }

        if (element.isAnnotationPresent(RolesAllowed.class)) {
            RolesAllowed annotation = element.getAnnotation(RolesAllowed.class);
            Set<String> allowedRoles = new HashSet<>(Arrays.asList(annotation.value()));

            return true;
        }

        return false;
    }
}
