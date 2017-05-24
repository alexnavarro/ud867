package com.udacity.gradle.builditbigger.net;

import com.udacity.gradle.builditbigger.JokerService;

import javax.inject.Inject;

/**
 * Created by alexandrenavarro on 5/24/17.
 */

public class JokeRepository {

    private JokerService service;

    @Inject
    public JokeRepository(JokerService service) {
        this.service = service;
    }
}