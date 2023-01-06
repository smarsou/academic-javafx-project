# Coding Week G9

# Installation

Ce projet est auto-suffisant dans le sans où il propose d'utiliser l'outil Gradle (https://gradle.org/) pour construire l'application fournie.
Un simple `./gradlew run` dans un terminal devrait vous télécharger l'outil gradle, télécharger les dépendances nécessaires (JavaFX en autre), lancer la compilation et exécuter le programme. 

Il se peut que vous rencontriez des problèmes. Voici quelques solutions :
- il faut que le script `./gradlew` soit exécutable (un simple `chmod a+x ./gradlew` devrait faire l'affaire)
- Gradle ne supportant pas encore Java 19, il faut utiliser une version 17 ou 18 du Java Development Kit (JDK) (utiliser la commande `java --version` ou un `./gradlew --version` pour vérifier votre version actuelle du JDK.)

Cette configuration peut également être importer dans IntelliJ pour créer un projet fonctionnelle à partir de celle-ci. Pour cela, lors de la création de votre projet IntelliJ, il faut sélectionner le fichier `build.gradle` et non pas uniquement le répertoire du projet.

# Planning

## Jour 1

Faire une conception partielle de l'application attendu pour le dernier jour.
Préparer le dépot git et mettre en place un environnement Gradle.
Créer une application basique qui affiche sur une seule vue l'ensemble des Pile stocker en JSON.

## Jour 2

Créer la fonctionnalité Apprentissage: sélectionner une Pile dans le menu puis afficher les cartes les unes à la suite des autres en laissant un temps de reflexion.
Mettre en place un module de stockage en JSON.
Créer le Menu et gérer les fonctionnalités du menu.

## Jour 3

Créer la fonctionnalité Création: ouvrir une vue permettant de modifier l'ensemble des caractéristiques de la pile.
Poursuivre la mise en place de la fonctionnalité Apprentissage.

## Jour 4

Améliorer l'experience utilisateur.
Finir les fonctionnalités Apprentissage et Création si besoin.


# Carnet de bord

## Diagramme de classe

Le diagramme de classe correspond à l'application que l'on espère obtenir.

![Diagramme de classe](./gp/classDiagram.png)


## Jour 1

Aujourd'hui, nous avons fait une conception globale de l'application pour savoir vers quoi on se dirigera, c'est notre RoadMap. Nous avons dessiné les croquis de toutes les vues que l'on aimerais avoir, ainsi qu'un diagramme de classe. Nous nous sommes partagés le travail à faire pour la journée. Chacun des membre a commencé à travailler sur une fonctionnalité qui, ensemble, formeront une première version de l'application livrée en fin de journée.

### Resultat jour 1

Le résultat est une projet Gradle fonctionnel. Il affiche le menu principal et n'est pour l'instant pas intéractif.


## Jour 2

Aujourd'hui, nous avons commencé par nous partager le travail à faire dans la journée. Pour développer notre application de manière itérative, nous nous sommes organisés pour être capables de rendre une application exécutable à la fin de la journée. Nous commençons par nous partager le travail: nous allons travailler sur 3 vues aujourd'hui: la vue du "menu" et les vues du mode "apprentissage", et nous devons aussi avoir terminé le stockage et la récupération de données en utilisant le format .json.

Beaucoup de problèmes liés au GitLab nous ralentissent durant notre travail, ce qui nous fait perdre du temps. On a fait attention à bien mettre en place le .gitignore gagner en efficacité.


### Resultat jour 2

Nous avons une application fonctionnelle qui réalise toutes les actions dites précédemment. Cependant, la lecture des cartes ne permet pas encore de s'entrainer car on ne cache pas encore la réponse. Ce sera l'objectif de demain.


## Jour 3

Aujourd'hui, nous avons développé nos fonctionnalités Apprentissage et Création. Nous nous sommes partagés le travail de manière à préparer chaque vue de notre modèle chacun de son côté pour ne pas géner les autres. Notre objectif est de livrer aujourd'hui une application "quasi-finale", à l'expérience utilisateur près (pas de design, ni de tests trop poussés...).

Nous avons encore des problèmes liés au GitLab, mais de moins en moins. Nous avions failli nous mettre à travailler sur des branches différentes mais cette solution semble trop complexe pour mettre en place les "merge" finaux puisque l'on dispose de peu de temps. On s'organise donc plutôt pour commit au "bon" moment, et ne plus effacer le travail des autres par mégarde comme ça a pu être le cas précédemment...


### Resultat jour 3


### reste à corriger:
reglages: on ne peut pas voir les cartes... 
sauvegarder dans json lorsqu'on créé carte dans partie règlage
on peut renommer 1 pile avec 1 nom qui existe déjà -> pas bien
menu jouer: nombre decimal, string... non accepté
-> smartmode: desactiver saisi frequence et 1 par defaut
laisser plus de place pour question reponses/ adapter scene builder
12 cartes restantes
reglages nouvelle pile 
erreur clear serge

l'histoire du refresh dans vueQuestionController qui Carte card = this.model.nexCarte();

