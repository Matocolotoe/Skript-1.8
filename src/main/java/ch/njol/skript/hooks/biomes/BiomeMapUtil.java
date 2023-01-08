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

import org.bukkit.block.Biome;
import org.eclipse.jdt.annotation.Nullable;

/**
 * Hooks to provide MC 1.8 support.
 */
public class BiomeMapUtil {
	
	public enum ToBiome {
		SWAMP("SWAMPLAND"),
		FOREST("FOREST"),
		TAIGA("TAIGA"),
		DESERT("DESERT"),
		PLAINS("PLAINS"),
		NETHER("HELL"),
		THE_END("SKY"),
		OCEAN("OCEAN"),
		RIVER("RIVER"),
		MOUNTAINS("EXTREME_HILLS"),
		FROZEN_OCEAN("FROZEN_OCEAN"),
		FROZEN_RIVER("FROZEN_RIVER"),
		SNOWY_TUNDRA("ICE_PLAINS"),
		SNOWY_MOUNTAINS("ICE_MOUNTAINS"),
		MUSHROOM_FIELDS("MUSHROOM_ISLAND"),
		MUSHROOM_FIELD_SHORE("MUSHROOM_SHORE"),
		BEACH("BEACH"),
		DESERT_HILLS("DESERT_HILLS"),
		WOODED_HILLS("FOREST_HILLS"),
		TAIGA_HILLS("TAIGA_HILLS"),
		MOUNTAIN_EDGE("SMALL_MOUNTAINS"),
		JUNGLE("JUNGLE"),
		JUNGLE_HILLS("JUNGLE_HILLS"),
		JUNGLE_EDGE("JUNGLE_EDGE"),
		DEEP_OCEAN("DEEP_OCEAN"),
		STONE_SHORE("STONE_BEACH"),
		SNOWY_BEACH("COLD_BEACH"),
		BIRCH_FOREST("BIRCH_FOREST"),
		BIRCH_FOREST_HILLS("BIRCH_FOREST_HILLS"),
		DARK_FOREST("ROOFED_FOREST"),
		SNOWY_TAIGA("COLD_TAIGA"),
		SNOWY_TAIGA_HILLS("COLD_TAIGA_HILLS"),
		GIANT_TREE_TAIGA("MEGA_TAIGA"),
		GIANT_TREE_TAIGA_HILLS("MEGA_TAIGA_HILLS"),
		WOODED_MOUNTAINS("EXTREME_HILLS_PLUS"),
		SAVANNA("SAVANNA"),
		SAVANNA_PLATEAU("SAVANNA_PLATEAU"),
		BADLANDS("MESA"),
		WOODED_BADLANDS_PLATEAU("MESA_PLATEAU_FOREST"),
		BADLANDS_PLATEAU("MESA_PLATEAU"),
		SUNFLOWER_PLAINS("SUNFLOWER_PLAINS"),
		DESERT_LAKES("DESERT_MOUNTAINS"),
		FLOWER_FOREST("FLOWER_FOREST"),
		TAIGA_MOUNTAINS("TAIGA_MOUNTAINS"),
		SWAMP_HILLS("SWAMPLAND_MOUNTAINS"),
		ICE_SPIKES("ICE_PLAINS_SPIKES"),
		MODIFIED_JUNGLE("JUNGLE_MOUNTAINS"),
		MODIFIED_JUNGLE_EDGE("JUNGLE_EDGE_MOUNTAINS"),
		SNOWY_TAIGA_MOUNTAINS("COLD_TAIGA_MOUNTAINS"),
		SHATTERED_SAVANNA("SAVANNA_MOUNTAINS"),
		SHATTERED_SAVANNA_PLATEAU("SAVANNA_PLATEAU_MOUNTAINS"),
		ERODED_BADLANDS("MESA_BRYCE"),
		MODIFIED_WOODED_BADLANDS_PLATEAU("MESA_PLATEAU_FOREST_MOUNTAINS"),
		MODIFIED_BADLANDS_PLATEAU("MESA_PLATEAU_MOUNTAINS"),
		TALL_BIRCH_FOREST("BIRCH_FOREST_MOUNTAINS"),
		TALL_BIRCH_HILLS("BIRCH_FOREST_HILLS_MOUNTAINS"),
		DARK_FOREST_HILLS("ROOFED_FOREST_MOUNTAINS"),
		GIANT_SPRUCE_TAIGA("MEGA_SPRUCE_TAIGA"),
		GRAVELLY_MOUNTAINS("EXTREME_HILLS_MOUNTAINS"),
		MODIFIED_GRAVELLY_MOUNTAINS("EXTREME_HILLS_PLUS_MOUNTAINS"),
		GIANT_SPRUCE_TAIGA_HILLS("MEGA_SPRUCE_TAIGA_HILLS");
		
		public static @Nullable ToBiome getMapping(Biome biome) {
			for (ToBiome value : values()) {
				if (value.getHandle().equals(biome)) {
					return value;
				}
			}
			return null;
		}
		
		private final Biome handle;

		ToBiome(String name) {
			this.handle = Biome.valueOf(name);
		}
		
		public Biome getHandle() {
			return this.handle;
		}

	}

}
