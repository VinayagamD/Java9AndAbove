package com.vinaylogics.corejavatraining.oops.abstracts.object_creation;

public class Test {
    public static void main(String[] args) {
        CData cData = new CData() {
            @Override
            public void cData() {

            }
        };
        IData iData = new IData() {
            @Override
            public void iData() {

            }
        };

        IData iData1 = ()->{

        };

        // Anonymous Object
        doSurfing(new IData() {
            @Override
            public void iData() {

            }
        });

        doSurfing(() -> {

        });

        doSurfing(new CData() {
            @Override
            public void cData() {

            }
        });
    }

    public static void doSurfing(IData data){
        data.iData();
    }

    public static void doSurfing(CData data){
        data.cData();
    }


}
