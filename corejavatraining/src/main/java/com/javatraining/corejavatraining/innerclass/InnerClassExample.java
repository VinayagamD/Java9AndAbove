package com.javatraining.corejavatraining.innerclass;

public class InnerClassExample {

    private String namePrivate = "namePrivate";
    String nameDefault = "nameDefault";
    private static String nameStaticPrivate = "nameStaticPrivate";
    static String nameStaticDefault = "nameStaticDefault";

    public static void main(String[] args) {
        NonStaticInnerClass nonStaticInnerClass = new InnerClassExample().new NonStaticInnerClass();
        StaticInnerClass staticInnerClass = new StaticInnerClass();
        nonStaticInnerClass.callNonStaticInnerClassMethod();
        staticInnerClass.callStaticInnerClassMethod();
        MethodLocalRunner localRunner = new MethodLocalRunner();
        localRunner.callMethodLocalRunner();
        methodAnon(() -> System.out.println("Test Method"));

    }

    private class NonStaticInnerClass {
        private String namePrivateLocalNonStatic = "namePrivateLocalNonStatic";
        String nameDefaultNonStatic = "nameDefaultNonStatic";
        final String nameFinalLocalNonStatic = "nameFinalNonStatic";
        public static final String nameStaticFinalNonStatic = "nameStaticFinalNonStatic";

        public void callNonStaticInnerClassMethod(){
            System.out.println(nameDefault);
            System.out.println(namePrivate);
            System.out.println(nameStaticPrivate);
            System.out.println(nameStaticDefault);
            System.out.println("Non Static Inner Class");
        }


    }

    private static class StaticInnerClass {

        private String namePrivateLocalStatic = "namePrivateLocalStatic";
        String nameDefaultStatic = "nameDefaultStatic";
        final String nameFinalLocalStatic = "nameFinalStatic";
        public static final String nameStaticFinalStatic = "nameStaticFinalStatic";
        private static String nameStaticLocalPrivate = "nameStaticLocalPrivate";
        static String nameStaticLocalDefault = "nameStaticLocalDefault";
        private void callStaticInnerClassMethod(){
            System.out.println(nameStaticPrivate);
            System.out.println(nameStaticDefault);
            System.out.println("Static Inner Class Method");
        }



        private static void callStaticInnerMethod(){
            System.out.println("Static Inner Method");
        }
    }

    private static class MethodLocalRunner {

        public void callMethodLocalRunner(){
            System.out.println("Method Local Runner");
            class InnerLocalMethod{
                void callInnerLocalMethod(){
                   System.out.println("Inner Class Call");
               }
            }

            InnerLocalMethod  localMethod = new InnerLocalMethod();
            localMethod.callInnerLocalMethod();
        }
    }

    @FunctionalInterface
    public interface CallbackAnon {
        void callAnon();
    }

    public static void methodAnon(CallbackAnon callbackAnon){
        callbackAnon.callAnon();
    }


}
