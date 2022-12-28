package org.eu.trixtertempdrive.gxtrm.utils;

import org.eu.trixtertempdrive.gxtrm.model.tmdbImages.Logo;

import java.util.Comparator;

public class imageVotesComparator implements Comparator<Logo> {
    @Override
    public int compare(Logo o1 , Logo o2) {
        return o2.getVote_count() - o1.getVote_count();
    }
}
