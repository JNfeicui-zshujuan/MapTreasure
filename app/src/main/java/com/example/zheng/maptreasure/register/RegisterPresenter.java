package com.example.zheng.maptreasure.register;

import android.os.AsyncTask;

import com.hannesdorfmann.mosby.mvp.MvpNullObjectBasePresenter;

/**
 * Created by zhengshujuan on 2016/7/13.
 */
public class RegisterPresenter extends MvpNullObjectBasePresenter<RegisterView> {

    public void register() {
        new registerTask().execute();
    }

    private final class registerTask extends AsyncTask<Void, Void, Integer> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            getView().showProgress();
        }

        @Override
        protected Integer doInBackground(Void... params) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return 0;
            }
            return 1;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            if (integer == 0) {
                getView().showMessage();
                getView().hideProgress();
                return;
            }
            getView().EnterHomeActivty();
            getView().hideProgress();
        }
    }
}
