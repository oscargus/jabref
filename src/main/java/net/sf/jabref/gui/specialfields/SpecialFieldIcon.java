package net.sf.jabref.gui.specialfields;

import javax.swing.Icon;

import net.sf.jabref.gui.IconTheme;
import net.sf.jabref.logic.specialfields.SpecialField;
import net.sf.jabref.specialfields.Printed;
import net.sf.jabref.specialfields.Priority;
import net.sf.jabref.specialfields.Quality;
import net.sf.jabref.specialfields.Rank;
import net.sf.jabref.specialfields.ReadStatus;
import net.sf.jabref.specialfields.Relevance;

public class SpecialFieldIcon {

    public static Icon getRepresentingIcon(SpecialField field) {
        if (Printed.getInstance().equals(field)) {
            return IconTheme.JabRefIcon.PRINTED.getSmallIcon();
        } else if (Priority.getInstance().equals(field)) {
            return IconTheme.JabRefIcon.PRIORITY.getSmallIcon();
        } else if (Quality.getInstance().equals(field)) {
            return IconTheme.JabRefIcon.QUALITY.getSmallIcon();
        } else if (Rank.getInstance().equals(field)) {
            return IconTheme.JabRefIcon.RANKING.getSmallIcon();
        } else if (ReadStatus.getInstance().equals(field)) {
            return IconTheme.JabRefIcon.READ_STATUS.getSmallIcon();
        } else if (Relevance.getInstance().equals(field)) {
            return IconTheme.JabRefIcon.RELEVANCE.getSmallIcon();
        }
        return null;
    }
}
