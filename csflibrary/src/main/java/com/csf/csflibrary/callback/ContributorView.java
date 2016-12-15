package com.csf.csflibrary.callback;


/**
 *
 */
public interface ContributorView {

    void onLoadContributorStart();

    void onLoadContributorSuccess(String jsonString, String flag);

    void onLoadContributorComplete();

    void onLoadContributorError(String error);
}
