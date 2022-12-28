package org.eu.trixtertempdrive.gxtrm;

import java.util.Random;

public class Constants {
    public static final String TMDB_GET_REQUEST_BASE_URL ="https://api.themoviedb.org/3/search/movie?api_key=";
    public static final String TMDB_BASE_URL = "https://api.themoviedb.org/3/";
    public static final String TMDB_IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500";
    public static final String TMDB_BACKDROP_IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w1280";
    public static final String FANART_IMAGE_BASE_URL = "https://webservice.fanart.tv/v3/";
    public static final String TMDB_API_KEY = "e19abfdd681e9585d77469f1fca13e49";
    public static final String SIMPLE_PROGRAM_DOWNLOAD_API = "https://geolocation.zindex.eu.org/generate.json?id=";
    public static final String CF_CACHE_TOKEN = "";

    public static String getFanartApiKey(){
        final String[] KEYS = {
                "304916f0120b03e1dfa0576e1c7bc959",
                "261aec4c152ddfc1bf884cdacf62d743",
                "72f8e3373f005ff1266d557ca2a994cf"};
        Random random = new Random();
        int index = random.nextInt(KEYS.length);
        return KEYS[index];
    }



}
