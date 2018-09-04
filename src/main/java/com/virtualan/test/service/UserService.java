package com.virtualan.test.service;

import java.util.Collection;
import java.util.Collections;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.virtualan.test.model.User;

import io.virtualan.annotation.ApiVirtual;
import io.virtualan.annotation.VirtualService;

/**
 * Spring boot and Apache CXF with virtualan
 * 
 * @author Elan Thangamani
 *
 */
@Component
@VirtualService
public class UserService {
	@Path("/users")
    @GET
    @ApiVirtual
    @Produces({MediaType.APPLICATION_JSON})
    public Collection<User> getUser() {
        return Collections.singletonList(new User("elan.thangmani@virtualan.io", "Elan", "Thangamani"));
    }
}
