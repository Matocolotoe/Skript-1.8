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
 *
 * Copyright Peter Güttinger, SkriptLang team and contributors
 */
package ch.njol.skript.util.visual;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.skript.lang.SyntaxElement;
import ch.njol.util.Kleenean;
import ch.njol.yggdrasil.YggdrasilSerializable;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.eclipse.jdt.annotation.Nullable;

import java.util.Objects;

public class VisualEffect implements SyntaxElement, YggdrasilSerializable {

	private VisualEffectType type;

	@Nullable
	private Object data;

	public VisualEffect() {}
	
	@SuppressWarnings({"null", "ConstantConditions"})
	@Override
	public boolean init(Expression<?>[] exprs, int matchedPattern, Kleenean isDelayed, ParseResult parseResult) {
		type = VisualEffects.get(matchedPattern);

		if (exprs.length > 4 && exprs[0] != null) {
			data = exprs[0].getSingle(null);
		}

		return true;
	}

	public void play(@Nullable Player[] ps, Location l, @Nullable Entity e, int count, int radius) {
		assert e == null || l.equals(e.getLocation());

		if (type.isEffect()) {
			Effect effect = type.getEffect();
			Object data = type.getData(this.data, l);

			if (ps == null) {
				l.getWorld().playEffect(l, effect, data, radius);
			} else {
				for (Player p : ps)
					p.playEffect(l, effect, data);
			}

		} else if (type.isEntityEffect()) {
			if (e != null)
				e.playEffect(type.getEntityEffect());

		} else {
			throw new IllegalStateException();
		}
	}

	public VisualEffectType getType() {
		return type;
	}

	@Override
	public String toString() {
		return toString(0);
	}
	
	public String toString(int flags) {
		return type.getName().toString(flags);
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, data);
	}

	@Override
	public boolean equals(@Nullable Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		VisualEffect that = (VisualEffect) o;
		return type == that.type && Objects.equals(data, that.data);
	}
	
}
