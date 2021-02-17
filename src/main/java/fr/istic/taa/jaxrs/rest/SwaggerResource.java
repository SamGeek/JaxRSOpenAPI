package fr.istic.taa.jaxrs.rest;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/api")
public class SwaggerResource {

    private static final Logger logger = Logger.getLogger(SwaggerResource.class.getName());

    @GET
    public byte[] Get1() {
        try {
        	//System.out.println(FileSystems.getDefault().get("src/main/webapp/swagger/index.html"));
        	
        	
        	String resourceName = "src/main/webapp/swagger/index.html";
        	
        	File file = new File(resourceName);
        	String absolutePath = file.getAbsolutePath();
        	System.out.println(absolutePath);
        	
        	return Files.readAllBytes(FileSystems.getDefault().getPath(absolutePath));
           
        	//return Files.readAllBytes(FileSystems.getDefault().getPath("src/main/webapp/swagger/index.html"));
        } catch (IOException e) {
            return null;
        }
    }

    @GET
    @Path("{path:.*}")
    public byte[] Get(@PathParam("path") String path) {
        try {
            return Files.readAllBytes(FileSystems.getDefault().getPath("src/main/webapp/swagger/"+path));
        } catch (IOException e) {
            return null;
        }
    }

}