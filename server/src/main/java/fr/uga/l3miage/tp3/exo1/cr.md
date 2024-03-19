## Compte rendu TP3
###     1. Avez-vous remarqué quelque-chose avec les fonctions par interpolation ?
Les fonctions d'interpolations sont d'une grande aide, elles permettent d'écrire très facilement des requêtes sql tout en restant intelligibles.
De plus, grâce à la syntaxe du nom de la fonction (find/all, attributs, spécification), une requête est contruite automatiquement, tout est géré derrière par Spring.

###     2. A votre avis, quelle est la manière la plus efficace pour récupérer et mettre en relation plusieurs éléments entre eux ?
Je pense que la manière la plus efficace de récupérer des entités est le mode lazy loading, où les associations ne sont pas chargées immédiatement,ce qui permet d'éviter une surcharge de la mémoire, et les requêtes 
par interpolation qui permettent un gain de temps considérable lorsque l'on a besoin d'intéragir avec la base de données.

###     3. Ici, Les components renvoient directement les entités, pensez-vous que cela soit une bonne chose ? Sinon, quelle serait la bonne méthode ?
Je ne pense pas que ce soit une bonne chose car si l'on se trouve sur un grand projet, par exemple une application comprenant beaucoup d'attributs 
et de méthodes dans ces composants, cela peut créer une surcharge alors que certains éléments ne sont pas nécessaires.
On pourait choisir une méthode DTO, qui consiste à renvoyer une entité directement depusis le composant.

###     4. Si je supprime un artiste, que se passe-t-il ?
En plus d'un problème de contraintes d'intégrité référentielle, une exception sera levée lorsque l'on essaiera de charger un artiste présent dans les autres tables (exemple : dans la table song).

###     5. Si je récupère une playlist, est-ce que toute l'entité est chargée ?
Cela depend de la "stratégie" de chargement, le noyau de l'entité est toujours chargé 
contrairement aux associations qui sont chargées seulement en eager loading et non en lazy loading.