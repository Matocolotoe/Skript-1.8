# Skript
Pour visionner la version française du tutoriel, cliquez [ici](https://github.com/Matocolotoe/Skript-1.8/blob/master/README_FR.md).

Looking for the official repository and 1.9+ releases ? Click [here](https://github.com/SkriptLang/Skript/releases).

Skript is a plugin for Paper/Spigot, which allows server owners and other people
to modify their servers without learning Java. It can also be useful if you
*do* know Java; some tasks are quicker to do with Skript, and so it can be used
for prototyping etc.

This GitHub fork of Skript is based on the SkriptLang fork, based on Mirreski's improvements
which was built on Njol's original Skript.

## Requirements
Skript requires **Spigot** to work. You heard it right, Bukkit does *not* work.
Paper is usable but not really recommended for 1.8 or older.

This fork of Skript is only available for Minecraft 1.8. Check above if you're
looking for 1.9+ compatibility.

Also, it doesn't support hooks to FAWE or WorldGuard yet.

## Download
You can find the downloads in the [releases page](https://github.com/Matocolotoe/Skript-1.8/releases).

## Upgrading from an older version to this version
If you're upgrading from Skript 2.2 or older to this plugin, you need to change things in your scripts.

In the case of downgrading from 1.9+ (with an official release) to 1.8 (with this plugin), a big error might appear. If so,
this is because the plugin folder still contains 1.9+ materials. To fix this, do the following :

- backup your scripts, config and .csv files (e.g. copy or download your Skript folder somewhere on your computer not to lose anything)

- stop the server and delete the Skript folder

- start the server and let the plugin load and create its files

- stop the server and upload your scripts, config.sk and .csv files back where they were

- restart the server and everything should be working

## What to change ?
**1. The line separator `||`**

In item lores, this one isn't available anymore, you will have to use a list of texts.

For example, `1st line||2nd line||3rd line` will have to be `"1st line", "2nd line", "3rd line"`.

If you have a lot of lores to update, just use CTRL+F to replace `||` by `", "` in all the files you want.

This is not a complete fix, a lot warnings regarding `"and" missing` might appear.

To disable them, set the `disable variable missing and/or warnings` to `true` in your `config.sk` file.


**2. New aliases system**


The new aliases are available in the [skript-aliases](https://github.com/SkriptLang/skript-aliases) repository.
This fork provides 1.8 aliases for all legacy potions (which changed in 1.9+), see details
[here](https://github.com/Matocolotoe/Skript-1.8/tree/master/skript-aliases/brewing.sk).

Also, if you had custom aliases, backup them and delete your `aliases-english.sk` and `aliases-german.sk`, they aren't used anymore.

To register custom aliases, you'll have to put this at the top of your script which uses them (example below).
```
aliases:
   pvp items = any swords, bow, arrow
```


Data values like `oak log:12` are not available anymore, a new expression as been introduced to support data values.

Most blocks now have aliases like 6-faces logs, for example `oak bark`.

However, if your block/item does not have one, here is a working example : `set event-block to cauldron with data value 1`.

Syntax : `%item type% with (damage|data) [value] %number%` or `%item type% damaged by %number%`


**3. Loading time**


The problem with scripts taking a long time to load is a known issue, especially if you are using items with long and explicit (i.e. without list variables) lores.

## Documentation
Documentation is available [here](https://skriptlang.github.io/Skript) for the
latest version of Skript.

## Issues and other stuff
Since this fork only provides retro-compatibility, issues regarding Skript will have to be posted
on the [official repository](https://github.com/SkriptLang/Skript) of the plugin.

However, don't hesistate to report any problem directly related to the plugin by posting
an issue [here](https://github.com/Matocolotoe/Skript-1.8/issues).

If you need any further help, join our [Discord server](https://discord.gg/yh3Z98m).
