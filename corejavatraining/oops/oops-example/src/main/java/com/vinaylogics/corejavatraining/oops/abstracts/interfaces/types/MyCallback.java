package com.vinaylogics.corejavatraining.oops.abstracts.interfaces.types;

public interface MyCallback {

    void onComplete(Object object);
    void onError(Throwable throwable);
    void onNext(Object object);
}
