/**
 *   This file is part of Skript.
 *
 *  Skript is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Skript is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with Skript.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright Peter Güttinger, SkriptLang team and contributors
 */
package ch.njol.skript.effects;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.Skript;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.lang.Effect;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;
import ch.njol.util.StringUtils;

@Name("Send Resource Pack")
@Description({"Request that the player's client download and switch resource packs. The client will download ",
		"the resource pack in the background, and will automatically switch to it once the download is complete. ",
		"The URL must be a direct download link.",
		"",
		"The <a href='events.html#resource_pack_request_action'>resource pack request action</a> can be used to check ",
		"status of the sent resource pack request."})
@Examples({"on join:",
		"	send the resource pack from \"URL\" to the player"})
@Since("2.4")
public class EffSendResourcePack extends Effect {

	static {
		Skript.registerEffect(EffSendResourcePack.class, "send [the] resource pack [from [[the] URL]] %string% to %players%");
	}

	@SuppressWarnings("null")
	private Expression<String> url;

	@SuppressWarnings("null")
	private Expression<Player> recipients;

	@SuppressWarnings({"unchecked", "null"})
	@Override
	public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
		url = (Expression<String>) exprs[0];
		recipients = (Expression<Player>) exprs[1];
		return true;
	}

	// Player#setResourcePack(String) is deprecated on Paper
	@SuppressWarnings({"deprecation"})
	@Override
	protected void execute(Event e) {
		assert url != null;
		String address = url.getSingle(e);
		if (address == null) {
			return; // Can't send, URL not valid
		}
		for (Player p : recipients.getArray(e)) {
			try {
				p.setResourcePack(address);
			} catch (Exception ignored) {}
		}
	}

	@Override
	public String toString(@Nullable Event e, boolean debug) {
		return "send the resource pack from " + url.toString(e, debug) + " to " + recipients.toString(e, debug);
	}

}
