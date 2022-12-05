# mailsorter

Séance du 9/11 matin: choix du scénario et de l'architecture du système distribué
- scénario de la gestion d'un mel (ex. de système de ticketing, hotline,...): Sur la base de l'analyse du sujet du mel, le système va déterminer automatiquement la personne (collaborateur de l'entreprise) la plus à même de traiter le mel;
- architecture et technologies: se focaliser sur le système d'IA distribuée (distribution des données, distribution des traitements/algos de l'IA). Il est retenu que les algos d'IA ne sont pas à implémenter car il est attendu d'utiliser des composants d'IA - apprentissage (librairies, packages,...) existants et disponibles sur internet. Une partie de l'IA distribuée reposera sur le langage Java, une autre sur le langage Python. Les composants de l'IA seront déployés sous forme de services REST. Les composants de gestion des données du SI utilisent Redis et une base de données de type SQL (PostgreSQL). Les entités du système seront déployées dans des conteneurs Docker.


## TO USE DOCKER

To start containers : 
```bash 
docker-compose up
```

To stop containers : 
```bash
docker-compose down
```

To stop containers and destroy volumes: 
```bash
docker-compose down -v
```
