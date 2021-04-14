# Mise à jour depuis Skript v2.2
Si vous passez de la version 2.2 de Skript ou d'une version antérieure à ce plugin, vous devez modifier plusieurs éléments de vos scripts.

## Changement à partir de Minecraft 1.9+
Dans le cas d'un changement de version à partir de Minecraft 1.9+, une erreur conséquente peut apparaître.
Si c'est le cas, sauvegardez votre dossier `scripts`, supprimez-le et démarrez votre serveur, puis restaurez son contenu.
Cela permettra au fichier `materials.json` de correctement se générer.

## Que faut-il changer ?

Si vous passez uniquement d'une vieille version de Skript à celle-ci, vous devrez suivre les instructions ci-dessous.

### Séparateur de ligne

Dans les lores d'items, on ne peut plus séparer les lignes par des `||`. Vous devrez utiliser une liste de textes.

Exemple : vous devrez remplacer `"1ère ligne||2ème ligne||3ème ligne"` par `"1ère ligne", "2ème ligne" and "3ème ligne"`.

Si vous avez beaucoup de fichiers à mettre à jour, il suffit d'utiliser CTRL+F pour remplacer `||` par `", "` dans les fichiers concernés.

### Nouveau système d'alias

Les nouveaux alias sont disponibles dans le repository [skript-aliases](https://github.com/SkriptLang/skript-aliases).

Ce fork fournit des alias pour toutes les potions de la 1.8 (qui ont changé en 1.9+), plus de détails
[ici](https://github.com/Matocolotoe/Skript-1.8/tree/master/skript-aliases/brewing.sk).

Les anciens fichiers d'alias, tels que `aliases-english.sk` ne sont plus utilisés. Si vous utilisiez des alias personnalisés, sauvegardez-les et supprimez ces fichiers.

Voici comment vous pouvez désormais enregistrer des aliases personnalisés :
```
aliases:
   pvp items = any sword, bow, arrow
```

Les data values comme "oak log:12" ne sont plus disponibles, une nouvelle expression a été introduite pour supporter les valeurs de données.

La plupart des items à data values ont maintenant des alias. Cependant, si le vôtre n'en a pas, utilisez l'expression [damaged item](https://skriptlang.github.io/Skript/expressions.html#ExprDamagedItem).

### Temps de chargement

Le problème des scripts qui prennent beaucoup de temps à se charger est connu et survient depuis la mise à jour 2.3 de Skript.
Il arrive généralement si vous utilisez des items avec des lores longues et explicites (c'est-à-dire sans variables "listes").
