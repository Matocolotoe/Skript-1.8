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
package ch.njol.skript.expressions;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.bukkit.event.Event;
import org.bukkit.inventory.meta.ItemMeta;
import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.Skript;
import ch.njol.skript.aliases.ItemType;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.expressions.base.PropertyExpression;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser.ParseResult;
import ch.njol.util.Kleenean;

@Name("Unbreakable Items")
@Description("Creates unbreakable copies of given items.")
@Examples("unbreakable iron sword #Creates unbreakable iron sword")
@Since("2.2-dev13b")
public class ExprUnbreakable extends PropertyExpression<ItemType, ItemType> {
	
	static {
		Skript.registerExpression(ExprUnbreakable.class, ItemType.class, ExpressionType.PROPERTY, "unbreakable %itemtypes%");
	}
	
	@SuppressWarnings({"unchecked", "null"})
	@Override
	public boolean init(final Expression<?>[] exprs, final int matchedPattern, final Kleenean isDelayed, final ParseResult parseResult) {
		setExpr((Expression<? extends ItemType>) exprs[0]);
		return true;
	}
	
	@Override
	protected ItemType[] get(final Event e, final ItemType[] source) {
		return get(source, itemType -> {
			ItemType clone = itemType.clone();
			ItemMeta meta = clone.getItemMeta();
			
			try {
				final Method spigot = ItemMeta.class.getDeclaredMethod("spigot");
				spigot.setAccessible(true);
				
				final Object instance = spigot.invoke(meta);
				final Class<?> c = instance.getClass();
				final Method setUnbreakable = c.getDeclaredMethod("setUnbreakable", boolean.class);
				
				setUnbreakable.setAccessible(true);
				setUnbreakable.invoke(instance, true);
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException ex) {
				ex.printStackTrace();
			}
			
			clone.setItemMeta(meta);
			return clone;
		});
	}
	
	@Override
	public Class<? extends ItemType> getReturnType() {
		return ItemType.class;
	}
	
	@Override
	public String toString(@Nullable Event e, boolean debug) {
		if (e == null)
			return "unbreakable items";
		return "unbreakable " + Arrays.toString(getExpr().getAll(e));
	}
}