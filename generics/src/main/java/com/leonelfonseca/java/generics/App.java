package com.leonelfonseca.java.generics;

public interface App {

    class Message<T>{
        T payload;

        void payload(T payload) {
            this.payload = payload;
        }

        T payload(){
            return payload;
        }

        public static void main(String... args) {

        }
    }

}
