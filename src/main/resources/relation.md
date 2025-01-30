### OneToMany

// Un utilisateur peut avoir PLUSIEURS voitures
// Une voiture appartient à UN SEUL utilisateur

@OneToMany (côté "One") : Un utilisateur → Plusieurs voitures
@ManyToOne (côté "Many") : Plusieurs voitures → Un utilisateur

Pour déterminer quelle annotation utiliser, pose-toi ces questions :

"Est-ce qu'UN X peut avoir PLUSIEURS Y ?" → OneToMany
"Est-ce que PLUSIEURS Y appartiennent à UN X ?" → ManyToOne

### ManyToMany

// Un étudiant peut suivre PLUSIEURS cours
// Un cours peut avoir PLUSIEURS étudiants
Etudiant (@ManyToMany) ←→ Cours (@ManyToMany)

// Un livre peut avoir PLUSIEURS catégories
// Une catégorie peut contenir PLUSIEURS livres
Livre (@ManyToMany) ←→ Categorie (@ManyToMany)


### OneToOne

// Une personne a UN SEUL passeport
// Un passeport appartient à UNE SEULE personne
Personne (@OneToOne) ←→ Passeport (@OneToOne)



#### Il est toujours conseillé d'avoir uniquement des relations unidirectionnelles et pas bidirectionnelles
#### mais on fera ici abstraction de cette règle afin de pouvoir joué avec le tout.

Dans une relation bidirectionnelle (quand les deux entités se connaissent mutuellement), il y a toujours :

Un côté propriétaire de la relation : c'est lui qui contient la clé étrangère en base de données
Un côté inverse : il fait référence au propriétaire via le mappedBy

La règle est simple :

Le côté "Many" est TOUJOURS le propriétaire de la relation
Le côté "One" utilise TOUJOURS le mappedBy

````java
@Entity // Car est le côté "Many" donc c'est le propriétaire
public class Car {
    @ManyToOne
    @JoinColumn(name = "user_id")  // Définit la clé étrangère
    private User user;
}

@Entity // User est le côté "One" donc il utilise mappedBy
public class User {
    @OneToMany(mappedBy = "user")  // Fait référence au champ "user" dans Car
    private List<Car> cars;
}
````


#####


Pour ManyToMany :

N'importe quel côté peut être propriétaire
L'autre côté doit utiliser mappedBy
Une table de jointure est créée automatiquement

````java
// Côté propriétaire
@Entity
public class Student {
    @ManyToMany
    @JoinTable(name = "student_course")  // Table de jointure
    private List<Course> courses;
}

// Côté inverse
@Entity
public class Course {
    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
}
````
En résumé : le côté "Many" est propriétaire et utilise @JoinColumn, 
le côté "One" est inverse et utilise mappedBy.


#####


Pour OneToOne, la détermination du côté propriétaire est plus flexible que pour OneToMany/ManyToOne. Tu peux choisir n'importe quel côté comme propriétaire, mais il faut suivre la même logique :

Le côté propriétaire aura la clé étrangère et utilisera @JoinColumn
Le côté inverse utilisera mappedBy

````java
// Côté propriétaire (j'ai choisi Passeport arbitrairement)
@Entity
public class Passport {
    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;
}

// Côté inverse 
@Entity
public class Person {
    @OneToOne(mappedBy = "person")
    private Passport passport;
}
````

On aurait pu faire l'inverse :
````java
// Côté propriétaire
@Entity
public class Person {
    @OneToOne
    @JoinColumn(name = "passport_id")
    private Passport passport;
}

// Côté inverse
@Entity
public class Passport {
    @OneToOne(mappedBy = "passport")
    private Person person;
}
````
Le choix du côté propriétaire dépend souvent de la logique métier :

Quelle entité ne peut pas exister sans l'autre ?
Quelle entité est la plus "importante" ?
Est-ce que l'une des relations peut être nullable ?

Par exemple, si un passeport ne peut pas exister sans personne, il est logique de mettre la clé étrangère côté Passport.