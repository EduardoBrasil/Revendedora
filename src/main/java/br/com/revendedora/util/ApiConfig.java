package br.com.revendedora.util;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class ApiConfig {


    @NoArgsConstructor(access = PRIVATE)
    public static class Path {

        public static final String ROOT = "/v1/revendedora";
        public static final String RESELLER = "/{reseller}";

        @NoArgsConstructor(access = PRIVATE)
        public static class Contact {

            // MerchantReceivableUnitController
            public static final String CONTACT = "/contacts/{id}";

        }
    }

    @NoArgsConstructor(access = PRIVATE)
    public static class Date {

        public static final String ISO_LOCAL_DATE = "yyyy-MM-dd";
        public static final String ISO_LOCAL_DATE_TIME = "yyyy-MM-dd'T'HH:mm:ss";
    }

    @NoArgsConstructor(access = PRIVATE)
    public static class Header {

        public static final String USERNAME = "username";
    }

}
