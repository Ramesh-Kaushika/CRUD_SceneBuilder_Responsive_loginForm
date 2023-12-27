package com.example.projectone.services;

import javafx.concurrent.Task;

public class ProgressTask extends Task<Integer> {
    @Override
    protected Integer call() throws Exception {

        updateProgress(10.0,100.0);
        Thread.sleep(1000);
        updateProgress(40.0,100.0);
        Thread.sleep(1000);
        updateProgress(65.0,100.0);
        Thread.sleep(1000);
        updateProgress(90.0,100.0);
        Thread.sleep(1000);
        updateProgress(100.0,100.0);


        return 100;

    }
}
