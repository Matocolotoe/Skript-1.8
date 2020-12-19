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
package ch.njol.skript.hooks.biomes;

import java.io.IOException;

import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.Skript;
import ch.njol.skript.hooks.Hook;
import ch.njol.skript.hooks.biomes.BiomeMapUtil.ToBiome;
import ch.njol.skript.util.EnumUtils;

/**
 * Hook for using 1.8 biome names.
 */
public class BiomeHook extends Hook<Skript> {
	
	@SuppressWarnings("null")
	public static BiomeHook instance;
	
	@Nullable
	public static EnumUtils<ToBiome> util;
	
	public static EnumUtils<ToBiome> getUtil() {
		assert util != null;
		return util;
	}

	public BiomeHook() throws IOException {}
	
	@Override
	protected boolean init() {
		instance = this;
		return true;
	}

	@Override
	public String getName() {
		return "Skript";
	}
	
	@SuppressWarnings("null")
	@Override
	protected void loadClasses() throws IOException {
		Skript.getAddonInstance().loadClasses(getClass().getPackage().getName());
		util = new EnumUtils<>(ToBiome.class, "biomes");
	}
	
}
