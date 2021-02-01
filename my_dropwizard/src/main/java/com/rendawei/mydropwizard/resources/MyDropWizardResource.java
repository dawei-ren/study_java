package com.rendawei.mydropwizard.resources;

import com.rendawei.mydropwizard.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.atomic.AtomicLong;

@Path("/my-drop-wizard")
public class MyDropWizardResource {

  private final String template;
  private final AtomicLong counter;

  public MyDropWizardResource(String template) {
    this.template = template;
    this.counter = new AtomicLong();
  }
  /*
  *
  * http://localhost:8080/my-drop-wizard/hello?name=123
  * */
  @GET
  @Path("/hello")
  @Produces(MediaType.APPLICATION_JSON)
  public Response sayHello(@QueryParam("name") String name) {
    return Response.ok(new Saying(counter.incrementAndGet(), template + name)).build();
  }

  /*
  *
  * http://localhost:8080/my-drop-wizard/health
  * */
  @GET
  @Path("/health")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getHealth(){
    return Response.ok(new Health()).build();
  }


  /*
  *
  * http://localhost:8080/my-drop-wizard/rdw/data
  * */

  @GET
  @Path("/{name}/data")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getPeople(@PathParam("name") String name){

    return Response.ok(new Person(name)).build();
  }



  /*
  *
  * http://localhost:8080/my-drop-wizard/error
  *
  * */
  @GET
  @Path("/error")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getError(){
    return Response.status(Response.Status.NOT_FOUND).build();
  }


  /*
   *
   * http://localhost:8080/my-drop-wizard/vue/news
   * */

  @GET
  @Path("/vue/news")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getTestVueHomeNews(){

    return Response.ok(new TestVueHomeNews()).build();
  }

  /*
   *
   * http://localhost:8080/my-drop-wizard/vue/data
   * */

  @GET
  @Path("/vue/data")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getTestVueHomeData(){

    return Response.ok(new TestVueHomeData()).build();
  }
}