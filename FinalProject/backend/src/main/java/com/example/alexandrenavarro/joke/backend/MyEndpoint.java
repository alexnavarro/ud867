/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.alexandrenavarro.joke.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.Random;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "jokerApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.joke.alexandrenavarro.example.com",
                ownerName = "backend.joke.alexandrenavarro.example.com",
                packagePath = ""
        )
)
public class MyEndpoint {

    private String[] jokes = new String[]{"Q: What goes up and down but does not move?\nA: Stairs\n\n",
    "Q: Where should a 500 pound alien go?\nA: On a diet Read\n\n",
    "Q: Why did the Hedgehog cross the road?\nA: To see his Flat Mate.\n\n"};

    /**
     * A simple endpoint method that takes a name and says Hi back
     */
    @ApiMethod(name = "pickupAJoke", httpMethod = ApiMethod.HttpMethod.GET)
    public MyBean pickupAJoke() {
        MyBean response = new MyBean();
        Random rand = new Random();
        response.setData(jokes[rand.nextInt(jokes.length)]);
        return response;
    }
}