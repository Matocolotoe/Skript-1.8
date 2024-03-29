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
package ch.njol.skript.timings;

import org.eclipse.jdt.annotation.Nullable;

import ch.njol.skript.Skript;

/**
 * Static utils for Skript timings.
 */
public class SkriptTimings {

	@Nullable
	public static Object start(String name) {
		return null;
	}
	
	public static void stop(@Nullable Object timing) {
	}
	
	public static boolean enabled() {
		return false;
	}
	
	public static void setEnabled(boolean flag) {
	}
	
	public static void setSkript(Skript plugin) {
	}
	
}
