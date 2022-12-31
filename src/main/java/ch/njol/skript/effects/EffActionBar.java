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

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.bukkit.Bukkit;
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
import ch.njol.skript.lang.SkriptParser;
import ch.njol.util.Kleenean;

@Name("Action Bar")
@Description("Sends an action bar message to the given player(s).")
@Examples("send action bar \"Hello player!\" to player")
@Since("2.3")
public class EffActionBar extends Effect {

	private static final String version = "net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().substring(23);
	
	static {
		Skript.registerEffect(EffActionBar.class, "send [the] action[ ]bar [with text] %string% to %players%");
	}

	@SuppressWarnings("null")
	private Expression<String> message;

	@SuppressWarnings("null")
	private Expression<Player> recipients;

	@SuppressWarnings({"unchecked", "null"})
	@Override
	public boolean init(final Expression<?>[] exprs, final int matchedPattern, final Kleenean isDelayed, final SkriptParser.ParseResult parser) {
		message = (Expression<String>) exprs[0];
		recipients = (Expression<Player>) exprs[1];
		return true;
	}

	@Override
	protected void execute(final Event e) {
		String msg = message.getSingle(e);
		assert msg != null;
		
		Constructor<?> constructor;
		Object a, packet = null;
		
		try {
			final Class<?> baseComponentClass = Class.forName(version + ".IChatBaseComponent");
			constructor = Class.forName(version + ".PacketPlayOutChat").getConstructor(baseComponentClass, byte.class);
			a = baseComponentClass.getDeclaredClasses()[0].getMethod("a", String.class).invoke(null, "{\"text\":\"" + msg + "\"}");
			packet = constructor.newInstance(a, (byte) 2);
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException ex) {
			ex.printStackTrace();
		}
		
		for (Player player : recipients.getArray(e)) {
			try {
				final Object entity = player.getClass().getMethod("getHandle").invoke(player);
				final Object playerConnection = entity.getClass().getField("playerConnection").get(entity);
				playerConnection.getClass().getMethod("sendPacket", Class.forName(version + ".Packet")).invoke(playerConnection, packet);
			} catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public String toString(final @Nullable Event e, final boolean debug) {
		return "send action bar " + message.toString(e, debug) + " to " + recipients.toString(e, debug);
	}

}
