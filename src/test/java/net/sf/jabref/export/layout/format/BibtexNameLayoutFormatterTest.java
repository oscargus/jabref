/**
 * Copyright (C) 2015 JabRef contributors
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 */
package net.sf.jabref.export.layout.format;

import org.junit.Assert;
import org.junit.Test;

public class BibtexNameLayoutFormatterTest {

    @Test
    public void testFormatStringStringBibtexEntry() {

        NameFormatter l = new NameFormatter();

        Assert.assertEquals("Doe", l.format("Joe Doe", "1@*@{ll}", null));

        Assert.assertEquals("moremoremoremore", l.format("Joe Doe and Mary Jane and Bruce Bar and Arthur Kay",
                "1@*@{ll}@@2@1..1@{ff}{ll}@2..2@ and {ff}{last}@@*@*@more", null));

        Assert.assertEquals("Doe", l.format("Joe Doe",
                "1@*@{ll}@@2@1..1@{ff}{ll}@2..2@ and {ff}{last}@@*@*@more", null));

        Assert.assertEquals("JoeDoe and MaryJ", l.format("Joe Doe and Mary Jane",
                "1@*@{ll}@@2@1..1@{ff}{ll}@2..2@ and {ff}{l}@@*@*@more", null));

        Assert.assertEquals("Doe, Joe and Jane, M. and Kamp, J.~A.", l.format("Joe Doe and Mary Jane and John Arthur van Kamp",
                "1@*@{ll}, {ff}@@*@1@{ll}, {ff}@2..-1@ and {ll}, {f}.", null));

        Assert.assertEquals("Doe Joe and Jane, M. and Kamp, J.~A.", l.format("Joe Doe and Mary Jane and John Arthur van Kamp",
                "1@*@{ll}, {ff}@@*@1@{ll} {ff}@2..-1@ and {ll}, {f}.", null));

    }

    @Test
    public void testFormat() {

        NameFormatter a = new NameFormatter();

        // Empty case
        Assert.assertEquals("", a.format(""));

        String formatString = "1@1@{vv }{ll}{ ff}@@2@1@{vv }{ll}{ ff}@2@ and {vv }{ll}{, ff}@@*@1@{vv }{ll}{ ff}@2..-2@, {vv }{ll}{, ff}@-1@ and {vv }{ll}{, ff}";

        // Single Names
        Assert.assertEquals("Vandekamp Mary~Ann", a.format("Mary Ann Vandekamp", formatString, null));

        // Two names
        Assert.assertEquals("von Neumann John and Black~Brown, Peter", a
                .format("John von Neumann and Black Brown, Peter", formatString, null));

        // Three names
        Assert.assertEquals("von Neumann John, Smith, John and Black~Brown, Peter", a
                .format("von Neumann, John and Smith, John and Black Brown, Peter", formatString, null));

        Assert.assertEquals("von Neumann John, Smith, John and Black~Brown, Peter", a
                .format("John von Neumann and John Smith and Black Brown, Peter", formatString, null));

        // Four names
        Assert.assertEquals("von Neumann John, Smith, John, Vandekamp, Mary~Ann and Black~Brown, Peter", a
                .format("von Neumann, John and Smith, John and Vandekamp, Mary Ann and Black Brown, Peter", formatString, null));
    }

}
