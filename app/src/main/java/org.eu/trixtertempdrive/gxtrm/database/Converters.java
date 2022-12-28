package org.eu.trixtertempdrive.gxtrm.database;

import android.util.Log;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.eu.trixtertempdrive.gxtrm.model.Data;
import org.eu.trixtertempdrive.gxtrm.model.Genre;
import org.eu.trixtertempdrive.gxtrm.model.TVShowInfo.Episode;
import org.eu.trixtertempdrive.gxtrm.model.TVShowInfo.Season;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


public class Converters {

    @TypeConverter
    public static Date fromTimestamp(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }


    @TypeConverter
    public static String fromData(Data data) {
        return data.toString();
    }

    @TypeConverter
    public static Data fromStringToData(String string) {
        Gson gson = new Gson();
        Data data = gson.fromJson(string , Data.class);
        return data;
    }

//    @TypeConverter
//    public static Long fromModifiedTime(Date date) {
//        if(date==null) return null;
//        return date.getTime();
//    }
//
//    @TypeConverter
//    public static Date fromLong(Long date) {
//        if(date==null) return null;
//        return new Date(date);
//    }

    @TypeConverter
    public static String fromEpisodes(ArrayList<Episode> episodes) {
        if (episodes == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < episodes.size(); i++) {
            Episode e = episodes.get(i);
            sb.append(e.toString());
            sb.append("\t");
        }
        System.out.println("StringBuilder op" + sb.toString());
        return sb.toString();
    }

    @TypeConverter
    public static ArrayList<Episode> fromStringToEpisodes(String episodesString) {
        if (episodesString == null) {
            return (null);
        }
//        Gson gson = new Gson();
//        "Mon Oct 10 22:07:31 GMT+05:30 2022"
//        Gson gson = new GsonBuilder().setDateFormat("E MMM dd HH:mm:ss 'Z' yyyy").create();
//        SimpleDateFormat df = new SimpleDateFormat("EE MMM dd HH:mm:ss zzzz yyyy");

        Gson gson = new GsonBuilder().setDateFormat("E MMM dd HH:mm:ss z yyyy").create();
//        ObjectMapper om = new ObjectMapper();

//        ObjectMapper gson = new ObjectMapper();
//        SimpleDateFormat df=new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy", Locale.US);
//        gson.setDateFormat(df);

        String[] arr = episodesString.split("\t");
        ArrayList<Episode> episodes = new ArrayList<>();
        try {
            for (String s : arr) {

                Episode episode = gson.fromJson(s ,Episode.class);
//                Episode episode = gson.readValue(s , Episode.class);
//                System.out.println("Episode inside For Loop" + episode);
                episodes.add(episode);
            }
        } catch (Exception e) {
            System.out.println("episodesArr exception" + e);
        }
//        System.out.println("episodesString in Converter" + episodesString);
//        System.out.println("episodesList in Converter" + episodes);
        return episodes;
    }



    @TypeConverter
    public static String fromSeasons(ArrayList<Season> seasons) {
        if (seasons == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seasons.size(); i++) {
            Season s = seasons.get(i);
            sb.append(s.toString());
            sb.append("\t");
        }

        System.out.println("StringBuilder op" + sb.toString());

        return sb.toString();
    }

    @TypeConverter
    public static ArrayList<Season> fromStringToSeasons(String seasonsString) {
        if (seasonsString == null) {
            return (null);
        }
        Gson gson = new Gson();
        String[] arr = seasonsString.split("\t");
        ArrayList<Season> seasons = new ArrayList<>();
        try {
            for (String s : arr) {
//                System.out.println("arr element inside For Loop" + s);
                Season season = gson.fromJson(s , Season.class);
//                System.out.println("Season inside For Loop" + season);
                seasons.add(season);
            }
        } catch (Exception e) {
            Log.i("SeasonJson" , Arrays.toString(arr));
        }
        System.out.println(seasons);
//        System.out.println("seasonString in Converter" + seasonsString);
        return seasons;
    }

    @TypeConverter
    public static String fromGenreList(ArrayList<Genre> genres) {
        if (genres == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < genres.size(); i++) {
            Genre s = genres.get(i);
            sb.append(s.toString());
            sb.append("\t");
        }



        return sb.toString();
    }

    @TypeConverter
    public static ArrayList<Genre> fromStringToGenres(String genresString) {
        if (genresString == null) {
            return (null);
        }
        Gson gson = new Gson();
        String[] arr = genresString.split("\t");
        ArrayList<Genre> genres = new ArrayList<>();

        for (String s : arr) {
            Genre genre = gson.fromJson(s , Genre.class);
            genres.add(genre);
        }
        System.out.println(genres);
        return genres;
    }
}




