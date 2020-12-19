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
package ch.njol.skript.bukkitutil;

import org.bukkit.block.Biome;
import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.hooks.biomes.BiomeHook;
import ch.njol.skript.hooks.biomes.BiomeMapUtil.ToBiome;
import ch.njol.skript.util.EnumUtils;

/**
 * 1.8 biome name mappings.
 */
public abstract class BiomeMappings {
	
	private final static EnumUtils<Biome> util = new EnumUtils<>(Biome.class, "biomes");
	
	public static @Nullable Biome parse(final String name) {
		ToBiome mapping = BiomeHook.getUtil().parse(name);
		if (mapping == null) return util.parse(name); // Should not happen - incomplete maps are a mess to work with for programmer
		return mapping.getHandle();
	}
	
	public static String toString(final Biome biome, final int flags) {
		ToBiome mapping = ToBiome.getMapping(biome);
		if (mapping == null) return "";
		return BiomeHook.getUtil().toString(mapping, flags);
	}
	
	public static String getAllNames() {
		return BiomeHook.getUtil().getAllNames();
	}
}