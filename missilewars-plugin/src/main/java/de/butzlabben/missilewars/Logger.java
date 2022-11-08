/*
 * This file is part of MissileWars (https://github.com/Butzlabben/missilewars).
 * Copyright (c) 2018-2021 Daniel Nägele.
 *
 * MissileWars is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * MissileWars is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with MissileWars.  If not, see <https://www.gnu.org/licenses/>.
 */

package de.butzlabben.missilewars;

import org.bukkit.Bukkit;

/**
 * @author Butzlabben
 * @since 01.01.2018
 */
public enum Logger {

    BOOT("[MW] Boot | "),
    BOOTDONE("[MW] Boot | "),
    NORMAL("[MW] Info | "),
    SUCCESS("[MW] Success | "),
    WARN("[MW] Warn | "),
    ERROR("[MW] Error | "),
    DEBUG("[MW] Debug | ");

    private final String prefix;

    Logger(String prefix) {
        this.prefix = prefix;
    }

    public void log(String msg) {
        if (this == DEBUG && !Config.debug()) return;

        if (this == BOOTDONE) msg = msg + " [§aDONE§r]";
        Bukkit.getConsoleSender().sendMessage(prefix + msg);
    }
}
