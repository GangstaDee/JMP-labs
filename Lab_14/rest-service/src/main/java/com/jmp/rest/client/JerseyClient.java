package com.jmp.rest.client;

import com.jmp.rest.entity.User;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import javax.ws.rs.core.MediaType;

/**
 * Created on 3/21/2016.
 */
public class JerseyClient {

    private Client client = Client.create();

    public static void main(String[] args) {

        JerseyClient client = new JerseyClient();
        client.testCreate();
        client.testRead(4);
        client.testUpdate();
        client.testDelete(1);
        client.testRead(1);
    }

    public void testCreate() {

        String userData = "<user>\n" +
                "  <login>dse</login>\n" +
                "  <firstName>dse</firstName>\n" +
                "  <lastName>dse</lastName>\n" +
                "  <email>dse@gmail.com</email>\n" +
                "</user>";
        try {
            WebResource webResource = client
                    .resource("http://localhost:8080/rest-service/rest/user/create");
            ClientResponse response = webResource.accept(MediaType.TEXT_PLAIN)
                    .type(MediaType.APPLICATION_XML)
                    .post(ClientResponse.class, userData);

            System.out.println("Create operation - response from server:");

            if (response.getStatus() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            System.out.println(response.getEntity(String.class));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testRead(int id) {

        try {
            WebResource webResource = client
                .resource("http://localhost:8080/rest-service/rest/user/read/" + id);
            ClientResponse response = webResource.accept(MediaType.TEXT_PLAIN).accept(MediaType.APPLICATION_XML)
                .get(ClientResponse.class);

            System.out.println("Read operation - response from server:");

            if(response.getStatus() == 200) {

                //to fix problem here: instantiate user
                User user = response.getEntity(User.class);
                System.out.println(user.toString());
                return;
            }

            if(response.getStatus() == 201) {
                System.out.println(response.getEntity(String.class));
                return;
            }

            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());

         } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testUpdate() {

        String userData = "{\n" +
                "  \"user\": {\n" +
                "    \"id\": \"1\",\n" +
                "    \"login\": \"dse_upd\",\n" +
                "    \"firstName\": \"selyavko_upd\",\n" +
                "    \"lastName\": \"selyavko_upd\",\n" +
                "    \"email\": \"dse_upd@gmail.com\"\n" +
                "  }\n" +
                "}";
        try {
            WebResource webResource = client
                    .resource("http://localhost:8080/rest-service/rest/user/update");
            ClientResponse response = webResource.accept(MediaType.TEXT_PLAIN)
                    .type(MediaType.APPLICATION_JSON)
                    .put(ClientResponse.class, userData);

            System.out.println("Update operation - response from server:");

            if (response.getStatus() != 200 && response.getStatus() != 201) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            System.out.println(response.getEntity(String.class));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void testDelete(int id) {

        try {
            WebResource webResource = client
                    .resource("http://localhost:8080/rest-service/rest/user/delete/" + id);
            ClientResponse response = webResource.accept(MediaType.TEXT_PLAIN)
                    .delete(ClientResponse.class);

            System.out.println("Delete operation - response from server:");

            if (response.getStatus() != 200 && response.getStatus() != 201) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatus());
            }

            System.out.println(response.getEntity(String.class));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
