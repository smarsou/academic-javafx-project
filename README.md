Notre projet de Coding Week

## Installation

Ce projet est auto-suffisant dans le sans où il propose d'utiliser l'outil Gradle (https://gradle.org/) pour construire l'application fournie.
Un simple `./gradlew run` dans un terminal devrait vous télécharger l'outil gradle, télécharger les dépendances nécessaires (JavaFX en autre), lancer la compilation et exécuter le programme. 

Il se peut que vous rencontriez des problèmes. Voici quelques solutions :
- il faut que le script `./gradlew` soit exécutable (un simple `chmod a+x ./gradlew` devrait faire l'affaire)
- Gradle ne supportant pas encore Java 19, il faut utiliser une version 17 ou 18 du Java Development Kit (JDK) (utiliser la commande `java --version` ou un `./gradlew --version` pour vérifier votre version actuelle du JDK.)

Cette configuration peut également être importer dans IntelliJ pour créer un projet fonctionnelle à partir de celle-ci. Pour cela, lors de la création de votre projet IntelliJ, il faut sélectionner le fichier `build.gradle` et non pas uniquement le répertoire du projet.

# Conception DAY 1

Aujourd'hui, nous avons fait une conception globale de l'application pour savoir vers quoi on se dirigera. Nous avons dessiné les croquis de toutes les vues que l'on aimerais avoir, ainsi qu'un diagramme de classe. Nous nous sommes partagés le travail à faire pour la journée.

## Diagramme de classe

Voir gp/classDiag.puml

## Objectif

L'objectif pour aujourd'hui est de créer une application Gradle n'ayant qu'un Menu intéractif.

### Resultat DAY 1

Le résultat est une projet Gradle fonctionnel. Il affiche le menu principal et n'est pour l'instant pas intéractif.

# Conception DAY 2

Aujourd'hui, nous avons commencé par nous partager le travail à faire dans la journée. Pour développer notre application de manière itérative, nous nous sommes organisés pour être capables de rendre une application exécutable à la fin de la journée. Nous commençons par nous partager le travail: nous allons travailler sur 3 vues aujourd'hui: la vue du "menu" et les vues du mode "apprentissage", et nous devons aussi avoir terminé le stockage et la récupération de données en utilisant le format .json.

Beaucoup de problèmes liés au GitLab nous ralentissent durant notre travail, ce qui nous fait perdre du temps. On a fait attention à bien mettre en place le .gitignore gagner en efficacité.

## Objectif

L'objectif pour aujourd'hui est une application qui permet de lire l'ensemble des piles, de lancer une pile et de lire les cartes une par une.

## Resultat DAY 2

Nous avons une application fonctionnelle qui réalise toutes les actions dites précédemment. Cependant, la lecture des cartes ne permet pas encore de s'entrainer car on ne cache pas encore la réponse. Ce sera l'objectif de demain.

