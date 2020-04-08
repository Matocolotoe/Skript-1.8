# Skript
Cliquez [ici](https://github.com/SkriptLang/Skript/releases) si vous cherchez la version officielle du plugin et les ressources pour la 1.9+ !

Skript est un plugin pour Paper/Spigot, permettant aux admins de serveurs et autres
utilisateurs de modifier leurs serveurs sans apprendre Java. Cela peut également
vous servir si vous *êtes* développeur Java, certaines tâches sont plus rapides
à exécuter via Skript, donc vous pouvez l'utilisez pour faire des prototypes, etc.

Cette fork GitHub de Skript est basée sur celle de SkriptLang, elle-même basée
sur les améliorations faites par Mirreski, elle-même construite sur la version originale
de Njol.

## Pré-requis
Skript a besoin de **Spigot** pour fonctionner. Vous l'avez bien compris, Bukkit ne
fonctionne *pas*. Paper est utilisable mais peu recommandé pour la 1.8 ou moins.

Cette fork de Skript est uniquement disponible pour Minecraft 1.8. Rendez-vous
plus haut si vous recherchez une compatibilité 1.9+.

De plus, les hooks à FAWE ou WorldGuard ne sont pas disponibles pour le moment.

## Téléchargements
Vous pouvez trouver les téléchargements dans la [page des releases](https://github.com/Matocolotoe/Skript-1.8/releases).

## Passer d'une version plus vieille à celle-ci
Si vous vous mettez à jour de Skript 2.2 ou plus ancien vers ce plugin, vous devrez changer des choses dans vos skripts.

Si vous passez de la 1.9+ (avec une version officielle) à la 1.8 (avec ce plugin), une grosse erreur peut apparaître. Si c'est le cas,
c'est parce que le dossier du plugin contient les matériaux de la 1.9+. Pour résoudre ce problème, procédez comme suit :

- sauvegardez vos scripts, fichiers de configuration et fichiers.csv (par exemple, copiez ou téléchargez votre dossier
Skript quelque part sur votre ordinateur pour ne rien perdre)

- arrêtez le serveur et supprimez le dossier Skript

- démarrez le serveur et laissez le plugin se charger et créer ses fichiers

- arrêtez le serveur et téléchargez vos scripts, fichiers config.sk et.csv à l'endroit où ils se trouvaient

- redémarrez le serveur et tout devrait fonctionner


**1. Le séparateur de ligne `||` dans les lores n'est plus disponible, vous devrez utiliser une liste de textes.**


Par exemple, `1ère ligne||2ème ligne||3ème ligne` devra être `"1ère ligne", "2ème ligne", "3ème ligne"`.


Si vous avez beaucoup de règles à mettre à jour, utilisez simplement CTRL+F pour remplacer `|||` par `", "` dans tous les fichiers concernés.


Ce n'est pas un correctif complet, beaucoup d'avertissements concernant "et" manquants" peuvent apparaître.

Pour les désactiver, mettez l'option `disable variable missing and/or warnings` sur `true` dans votre fichier `config.sk`.


**2. Un nouveau système d'alias a été mis en place, vous devrez peut-être les modifier.**


Les nouveaux alias sont disponibles dans le repository [skript-aliases](https://github.com/SkriptLang/skript-aliases).
Cette fork possède des alias pour les potions jetables en 1.8 (qui ont changé en 1.9+), plus de détails
[ici](https://github.com/Matocolotoe/Skript-1.8/tree/master/skript-aliases/brewing.sk).

Par ailleurs, si vous aviez des alias personnalisés, sauvegardez-les et supprimez vos
fichiers `aliases-english.sk` et `aliases-german.sk`, ils ne sont plus utilisés.

Pour enregistrer des alias custom, vous devrez les mettre tout en haut de votre skript qui les utilise (exemple ci-dessous).
```
aliases:
   combat items = any swords, bow, arrow
```


Les data values comme `oak log:12` ne sont plus disponibles, une nouvelle expression a été ajoutée pour les supporter.

La plupart des blocs ont maintenant des alias comme les logs à 6 faces, par exemple `oak bark`.

Sinon, si votre bloc/item n'en a pas, voici un exemple fonctionnel : `set event-block to cauldron with data value 1`.

Syntaxe : `%item type% with (damage|data) [value] %number%` ou `%item type% damaged by %number%`


**3. Vos skripts peuvent prendre plus de temps à se charger.**


C'est un problème connu, surtout si vous utiliez des items avec des lores explicites (c'est-à-dire sans variables de type listes) longues.

## Documentation
La documentation est disponible [ici](https://skriptlang.github.io/Skript) pour la dernière version de Skript.

## Bugs et suggestions
Puisque cette fork ne fournit que de la rétro-compatibilité, les bugs et suggestions à propos
de Skript devront être postées sur le [repository officiel](https://github.com/SkriptLang/Skript) du plugin.