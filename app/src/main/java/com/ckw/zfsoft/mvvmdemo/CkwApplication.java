package com.ckw.zfsoft.mvvmdemo;

import android.app.Application;
import android.content.Context;

import com.ckw.zfsoft.mvvmdemo.model.GithubService;

import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by ckw
 * on 2018/1/15.
 */

public class CkwApplication extends Application {
    private GithubService githubService;
    private Scheduler defaultSubscribeScheduler;

    public static CkwApplication get(Context context){
        return (CkwApplication) context.getApplicationContext();
    }

    public GithubService getGithubService() {
        if (githubService == null) {
            githubService = GithubService.Factory.create();
        }
        return githubService;
    }

    //For setting mocks during testing
    public void setGithubService(GithubService githubService) {
        this.githubService = githubService;
    }

    public Scheduler defaultSubscribeScheduler() {
        if (defaultSubscribeScheduler == null) {
            defaultSubscribeScheduler = Schedulers.io();
        }
        return defaultSubscribeScheduler;
    }

    //User to change scheduler from tests
    public void setDefaultSubscribeScheduler(Scheduler scheduler) {
        this.defaultSubscribeScheduler = scheduler;
    }

}
