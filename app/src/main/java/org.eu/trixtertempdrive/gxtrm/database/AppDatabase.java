package org.eu.trixtertempdrive.gxtrm.database;

import androidx.room.AutoMigration;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import org.eu.trixtertempdrive.gxtrm.model.IndexLink;
import org.eu.trixtertempdrive.gxtrm.model.Movie;
import org.eu.trixtertempdrive.gxtrm.model.ResFormat;
import org.eu.trixtertempdrive.gxtrm.model.TVShowInfo.Episode;
import org.eu.trixtertempdrive.gxtrm.model.TVShowInfo.TVShow;
import org.eu.trixtertempdrive.gxtrm.model.TVShowInfo.TVShowSeasonDetails;

@Database(entities = {ResFormat.class, Movie.class, IndexLink.class, TVShow.class, TVShowSeasonDetails.class, Episode.class},
        version = 30, autoMigrations = { @AutoMigration(from = 23, to = 24),@AutoMigration(from = 24, to = 25),@AutoMigration(from = 25, to = 26),@AutoMigration(from = 26, to = 27),@AutoMigration(from = 27, to = 28),@AutoMigration(from = 28, to = 29),@AutoMigration(from = 29, to = 30)})
@TypeConverters({Converters.class})


public abstract class AppDatabase extends RoomDatabase {

    public abstract ResFormatDao resFormatDao();
    public abstract MovieDao movieDao();
    public abstract TVShowDao tvShowDao();
    public abstract EpisodeDao episodeDao();
    public abstract TVShowSeasonDetailsDao tvShowSeasonDetailsDao();
    public abstract IndexLinksDao indexLinksDao();


}
