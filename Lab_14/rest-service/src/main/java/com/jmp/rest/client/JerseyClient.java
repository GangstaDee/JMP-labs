package com.jmp.rest.client;

import com.jmp.rest.entity.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.core.InjectParam;
import com.sun.jersey.multipart.MultiPart;

import javax.imageio.ImageIO;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created on 3/21/2016.
 */
public class JerseyClient {

    private Client client = Client.create();

    public void testCreate() {

        String userData = "<user>\n" +
                "  <login>dse</login>\n" +
                "  <firstName>dse</firstName>\n" +
                "  <lastName>dse</lastName>\n" +
                "  <email>dse@gmail.com</email>\n" +
                "</user>";
        try {
            WebResource webResource = client
                    .resource("http://localhost:8080/rest-service/rest/user");
            ClientResponse response = webResource
                    .type(MediaType.APPLICATION_XML)
                    .accept(MediaType.TEXT_PLAIN)
                    .post(ClientResponse.class, userData);

            System.out.println("Create operation - response from server: " + response.getStatus());

            if (Response.Status.CREATED.getStatusCode()!= response.getStatus()
                    && Response.Status.OK.getStatusCode() != response.getStatus() ) {
                throw new RuntimeException("Failed to create user. HTTP error code : "
                        + response.getStatus());
            }

            System.out.println(response.getEntity(String.class));

        } catch (Exception e) {
            throw e;
        }
    }

    public void testRead(int id) {

        try {
            WebResource webResource = client
                .resource("http://localhost:8080/rest-service/rest/user").queryParam("id", String.valueOf(id));
            ClientResponse response = webResource
                    .accept(MediaType.APPLICATION_XML)
                    .accept(MediaType.TEXT_PLAIN)
                    .get(ClientResponse.class);

            System.out.println("Read operation - response from server: " + response.getStatus());

            if(Response.Status.OK.getStatusCode() == response.getStatus()) {
                User user = response.getEntity(User.class);
                System.out.println(user.toString());
                return;
            }

            if(Response.Status.NO_CONTENT.getStatusCode() == response.getStatus()) {
                System.out.println(response.getEntity(String.class));
                return;
            }

            throw new RuntimeException("Failed to read user. HTTP error code : "
                    + response.getStatus());

         } catch (Exception e) {
            throw e;
        }
    }

    public void testUpdate(int id) {

        String userData = "{\n" +
                "  \"user\": {\n" +
                "    \"login\": \"dse_upd\",\n" +
                "    \"firstName\": \"dse_upd\",\n" +
                "    \"lastName\": \"dse_upd\",\n" +
                "    \"email\": \"dse_upd@gmail.com\"\n" +
                "  }\n" +
                "}";
        try {
            WebResource webResource = client
                    .resource("http://localhost:8080/rest-service/rest/user").queryParam("id", String.valueOf(id));
            ClientResponse response = webResource
                    .type(MediaType.APPLICATION_JSON)
                    .accept(MediaType.TEXT_PLAIN)
                    .put(ClientResponse.class, userData);

            System.out.println("Update operation - response from server: " + response.getStatus());

            if (Response.Status.NO_CONTENT.getStatusCode() != response.getStatus()
                    && Response.Status.OK.getStatusCode() != response.getStatus() ) {
                throw new RuntimeException("Failed to update user. HTTP error code : "
                        + response.getStatus());
            }

            System.out.println(response.getEntity(String.class));

        } catch (Exception e) {
            throw e;
        }

    }

    public void testDelete(int id) {

        try {
            WebResource webResource = client
                    .resource("http://localhost:8080/rest-service/rest/user").queryParam("id", String.valueOf(id));
            ClientResponse response = webResource
                    .accept(MediaType.TEXT_PLAIN)
                    .delete(ClientResponse.class);

            System.out.println("Delete operation - response from server: " + response.getStatus());

            if (Response.Status.NO_CONTENT.getStatusCode() != response.getStatus()
                    && Response.Status.OK.getStatusCode() != response.getStatus() ) {
                throw new RuntimeException("Failed to delete user. HTTP error code : "
                        + response.getStatus());
            }

            System.out.println(response.getEntity(String.class));

        } catch (Exception e) {
            throw e;
        }
    }

    public void testUpload(int id) throws IOException {

        try {
            client.setChunkedEncodingSize(1024);
            WebResource webResource = client
                    .resource("http://localhost:8080/rest-service/rest/logo").queryParam("id", String.valueOf(id));

            File image = new File("C:\\#######\\lalala.png");
            Path path = Paths.get(image.getAbsolutePath());
            byte[] data = Files.readAllBytes(path);

            MultiPart object = new MultiPart()
                .bodyPart(image.getName(), MediaType.TEXT_PLAIN_TYPE)
                .bodyPart(data, MediaType.APPLICATION_OCTET_STREAM_TYPE);

            ClientResponse response = webResource
                    .type("multipart/mixed")
                    .post(ClientResponse.class, object);

            System.out.println("Upload status: " + response.getStatus());

            if (Response.Status.NO_CONTENT.getStatusCode() != response.getStatus()
                    && Response.Status.OK.getStatusCode() != response.getStatus() ) {

                Exception ex = response.getEntity(Exception.class);
                throw new RuntimeException("Failed to upload file user. HTTP error code : "
                        + response.getStatus(), ex);
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void testDownload(int id) throws IOException {

        try {
            WebResource webResource = client
                    .resource("http://localhost:8080/rest-service/rest/logo").queryParam("id", String.valueOf(id));

            ClientResponse response = webResource
                    .accept(MediaType.APPLICATION_OCTET_STREAM)
                    .get(ClientResponse.class);

            System.out.println("Download status: " + response.getStatus());

            if (Response.Status.NO_CONTENT.getStatusCode() != response.getStatus()
                    && Response.Status.OK.getStatusCode() != response.getStatus() ) {
                Exception ex = response.getEntity(Exception.class);
                throw new RuntimeException("Failed to download file user. HTTP error code : "
                        + response.getStatus(), ex);
            }

            InputStream logo = response.getEntityInputStream();
            File file = new File("src/main/resources/sample.jpg");
            BufferedImage buf = ImageIO.read(logo);
            ImageIO.write(buf, "jpg", file);

        } catch (Exception e) {
            throw e;
        }
    }

    public static void main(String[] args) throws IOException {

        JerseyClient client = new JerseyClient();
        client.testCreate();
        client.testRead(1);
       // client.testUpdate(1);
        //client.testRead(1);
        //client.testDelete(1);
        //client.testRead(1);
        client.testUpload(1);
        client.testDownload(1);

    }

}
