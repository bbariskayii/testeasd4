/*-
 * LICENSE
 * DiscordSRV
 * -------------
 * Copyright (C) 2016 - 2021 Austin "Scarsz" Shapiro
 * -------------
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * END
 */

package github.scarsz.discordsrv.util;

import github.scarsz.discordsrv.DiscordSRV;
import net.dv8tion.jda.api.entities.Role;
import org.bukkit.ChatColor;

import java.util.List;

public class MessageFormatResolver {

    public static String getMessageFormat(List<Role> selectedRoles, String channel) {
        LangUtil.Message format = !selectedRoles.isEmpty() ? LangUtil.Message.CHAT_TO_MINECRAFT : LangUtil.Message.CHAT_TO_MINECRAFT_NO_ROLE;

        return DiscordSRV.config().getOptionalString(format.getKeyName() + "_" + channel)
                .map(s -> ChatColor.translateAlternateColorCodes('&', s))
                .orElseGet(format::toString);
    }
}
