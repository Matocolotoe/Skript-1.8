# Upgrading from Skript v2.2
If you're upgrading from Skript 2.2 or an older version to this plugin, you need to change several things in your scripts.

## Changing from Minecraft 1.9+
In the case of changing versions from Minecraft 1.9+, a big error might appear.
If so, backup your `scripts` folder, delete it and start your server, then restore its contents.

## What to change ?

If you're only upgrading from an old version of Skript, you'll have to follow the instructions below.

### Line separator

In item lores, you can't separate lines with `||` anymore. You will have to use a list of texts.

Example : you'll need to replace `1st line||2nd line||3rd line` by `"1st line", "2nd line" and "3rd line"`.

If you have a lot of lores to update, just use CTRL+F to replace `||` by `", "` in the involved files.

### New aliases system

The new aliases are available in the [skript-aliases](https://github.com/SkriptLang/skript-aliases) repository.

This fork provides 1.8 aliases for all legacy potions (which changed in 1.9+), see details
[here](https://github.com/Matocolotoe/Skript-1.8/tree/master/skript-aliases/brewing.sk).

Old aliases files, such as `aliases-english.sk` aren't used anymore. If you used custom ones, backup them and delete these files.

This is how you can register custom aliases now :
```
aliases:
   pvp items = any sword, bow, arrow
```

Data values like `oak log:12` are not available anymore, a new expression has been introduced to support data values.

Most valued items now have aliases. However, if yours doesn't have one, use the [damaged item expression](https://skriptlang.github.io/Skript/expressions.html#ExprDamagedItem).

### Loading time

The problem of scripts taking a long time to load is a known issue which was introduced in Skript v2.3.
It happens especially if you are using items with long and explicit (i.e. without list variables) lores.
