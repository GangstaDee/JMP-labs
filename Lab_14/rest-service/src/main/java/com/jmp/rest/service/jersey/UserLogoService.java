package com.jmp.rest.service.jersey;

import com.jmp.rest.entity.FileRepository;
import com.jmp.rest.entity.UserStorage;
import com.sun.jersey.core.header.ContentDisposition;
import com.sun.jersey.multipart.BodyPartEntity;
import com.sun.jersey.multipart.MultiPart;

import javax.imageio.ImageIO;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created on 3/23/2016.
 */
@Path("/logo")
public class UserLogoService {

    @POST
    @Consumes("multipart/mixed")
    public Response uploadLogo(@QueryParam("id") int id, MultiPart multiPart) {

        if(id <=0) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid ID").build();
        }

        if(UserStorage.readUser(id) == null) {
            return Response.status(Response.Status.NO_CONTENT).entity("No users found").build();
        }

        String name = multiPart.getBodyParts().get(0).getEntityAs(String.class);
        BodyPartEntity logo = (BodyPartEntity) multiPart.getBodyParts().get(1).getEntity();

        try {
            File file = new File(name);
            BufferedImage buf = ImageIO.read(logo.getInputStream());
            ImageIO.write(buf, "jpg", file);  //wrong

            FileRepository.putLogo(id, file);
            return Response.ok("Uploaded successfully").build();

        } catch (Exception e) {
            return Response.serverError().entity(e).build();
        }

    }

    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response downloadLogo(@QueryParam("id") int id) {

        if(id <=0) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid ID").build();
        }

        File image = FileRepository.getLogoByUserID(id);
        if(image == null) {
            return Response.status(Response.Status.NO_CONTENT).entity("No logo found").build();
        }

        try {
            final InputStream input = new FileInputStream(image);

            StreamingOutput stream = new StreamingOutput() {

                    public void write(OutputStream out) throws IOException{
                        try {
                            int read = 0;
                            byte[] bytes = new byte[1024];

                            while ((read = input.read(bytes)) != -1) {
                                out.write(bytes, 0, read);
                            }
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                };


            ContentDisposition contentDisposition = ContentDisposition
                    .type("attachment")
                    .fileName(image.getName())
                    .size(image.length())
                    .build();


            return Response.ok().entity(stream)
                    .type(MediaType.APPLICATION_OCTET_STREAM_TYPE)
                    .header("Content-Disposition", contentDisposition)
                    .build();

        } catch (Exception e) {
            return Response.serverError().entity(e).build();
        }



    }
}
