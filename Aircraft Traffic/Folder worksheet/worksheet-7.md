# COMP2000 Worksheet 1 — Mid-Semester Submission

**Student name: Thi To (Uyen) Nguyen**

**Student ID: 48971669**

**GitHub repo URL:**

---

## 1. Version Control

**1.1.** Paste the first 10 lines of the output of `git log --graph --oneline --all` from your repository:

```
![](images/gitlog.png)
![](images/gitlog2.png)


```

**1.2.** Describe your workflow. Did you use branches? Pull requests?





**1.3.** Estimate the percentage of commits you contributed relative to the total in your repository.

- I've contributed around 20-30% in group work beause we have 5-7 members discussing our assignments in class as well as explaining to each other why we use the functions in our code before push it to the repository. 
- Personally in my own repository, I've contributed around 80% because I have come up with my own Airport design for my simulation, hence why my movement is a lot different from what my teammate's work might be. 
- We work as a team in class but off-class, we all come up with our own ideas based on our creativies. Which explains why some part of my code are borrowed from my group's work but some are my own. And vice versa, my teammate can borrow some of my code and put it in their work then come up with additional ideas for their simulations. 

---

## 2. Program Design

**2.1.** List every class in your project and write 1–2 sentences describing its responsibility.

Classes and responsibilities (alphabetical)

Airport: Build the base for airport by including all of its object in it. Used to allocate the position of each node to determine where the plane should move. 

AirportJPanel: Used to draw the panel of the airport, including runway, taxiway, planes, gates and paths. 

AirportPath: Is the parent class, determines every route in the airport, include pathID and length in meters. 

AirwayGate: This class is responsible for the function of the gate where planes is parked. It tells what plane is currently at the gate and status of the gate: If it's closed or opened. 

Bus: Responsible for buses to take passengers to the plane. Or deliver suitcases and package from terminal to the plane (Used for future project, not in this one).

BusLane: Shows the road  where bus is moving on (Used for future project, not this one).

CargoPlane: Is a child object of Plane class, which is responsible for plane used to deliver packages or carry freight, not passengers. 

CommercialPlane: Also a child object to Plane class. Used to differentiate from CargoPlane. This plane is used for transportation of passengers (carrying people). 

Main: Used to set up the whole program. 

Moveable: Set the plane position as it started to move. Used to set a variable in Plane class, allowing planes to move towards a target or change its target (changeTarget()/ moveTowards()).

Node: Is used to set point position for the route. Made up by Vector2 to create the route of the planes. 

Plane: Is the parent class, used to build the base of a plane and set its movement with speed, set its vector and movement targets and update plane movement. 

Position: Used to set X and Y position. 

Route: Contains an ArrayList of Node class, used to make up a whole route for moving planes. 

Runway: The actual road for plane to use during take off. Is a child to Airport Path. 

RunwayOccupiedException: Used to run exception. 

Taxiway: Is a child object to AirportPath, the path used to connect runway with regular paths to help plane move to runway. 

Vector2:  Set up vector2 for Node class. Used to determine waypoint for object to move. 

**2.2.** Identify any inheritance relationships. For each parent–child pair, list what the child inherits and what it overrides.

Plane- Parent object: CargoPlane, CommercialPlane- child objects. 
- Child object inherits the basic build of a basic plane object. But each type of planes override a displayInfo(), so when information is displayed, it will let you know which plane is commercial plane with its capacity and which plane is a cargo plane with its weight. 

AirportPath- Parent object: Runway, Taxiway- child objects 
- Child object inherits the length of an overall path,  while each typr of path has its own function, where taxiway is the path connecting regular paths with runway for planes to take off. 

**2.3.** Pick the class that you think has the best design. Explain why.

- Personally, i think Plane class has the best design, it contains the basic function of a plane and deliver its movement through updateMovement method. 

- Plane class contains details of each plane specifically including the rules for planes to move. For example, each runway can only have one plane at a time, so whenever a plane is moving towards runway with another plane in it, it will have to wait and request entry through requestEntry method and then make an attempt to enter the runway through attemptRunwayEntry method. 

- Each plane at different gate would have different route and setRoute method is used for this. 


**2.4.** Paste one code snippet that demonstrates your use of polymorphism or encapsulation.  Include an explanation of _how_ this demonstrates polymorphim or encapsulation.  Give a reference to a provided reading that talks about this type of polymorphism or encapsulation.



---

## 3. Generics and Exceptions

**3.1.** List every place your code uses generics (e.g. `ArrayList<Actor>`, `Optional<Cell>`, `HashMap<String, Team>`). If you deliberately used none, explain why.





**3.2.** List every place your code handles exceptions (try/catch, throws, custom exception classes). What error is each protecting against?

- Custom exception class: 
public class RunwayOccupiedException extends Exception {
    public RunwayOccupiedException(String message) {
        super(message);
    }
}

- try/catch block: 
public boolean attemptRunwayEntry(Runway runway) {
    try {
            runway.requestEntry(this);
            return true;
    } catch (RunwayOccupiedException exception) {
            setStatus("WAITING");
            return false;
        }
    }

- throws block: 
public void requestEntry(Plane plane)
        throws RunwayOccupiedException {

    if (currentPlane != null && currentPlane != plane) {
        throw new RunwayOccupiedException(
            "The runway is occupied by another plane."
        );
    }
    currentPlane = plane;
    }

- This prevends the program to crash when there's more than a plane in the runway as runway can only allow one plane at a time. So the custom class will print out a message and then decide if it should let the plan enter the runway or not. 
- If there are planes on the runway, the program will print out a "WAITING" message and plane will wait at the runway until the other plane has completely exited the path. 
- If there are no planes on the runway, the moving plane will continue entering the runway without any obstacles. 


**3.3.** Paste a code snippet showing either a generic class/method or a try/catch block.

Boolean method of try/catch block 

public boolean attemptRunwayEntry(Runway runway) {
    try {
            runway.requestEntry(this);
            return true;
    } catch (RunwayOccupiedException exception) {
            setStatus("WAITING");
            return false;
        }
    }

---

## 4. Log Book

**4.1.** Attach or link your log book entries for Weeks 1–6.

[View my logbook](COMP2000-48971669-LogBook.pdf) 

Logbook is also included in repository (inside worksheet folder)


**4.2.** Which week's activity taught you the most? What did you learn?

- Week2 taught me the most because it helped me build a base knowledge for this unit and it also showed me how git commands is used in git bash which is a new thing to me at that time. 

- And these has helped me throughout 7 weeks of this unit where i can learn how to do my work, and then share it with my teammates and then update my work by pulling their adjustments onto my repository. 

---

## 5. Uniqueness and Creativity

**5.1.** List everything you added to the project that was not part of the in-class activities.

- I have created 2 new classes for my future (ideally week13 submission), which is Bus.java and BusLane.java. 
- I also removed unused files or classes in my teammate's work and adjust it so it could fit into my personal project. 
- I help my teammate with the design layout but i've also build my own layout of the individual project which is completely different from my teammate's colorful design. My design includes a simple drawing of the airport from above, which contains simple drawing on a blank board. 

**5.2.** Which feature required the most independent research or problem-solving? What did you learn from it?

- Figuring out how to set the plane movement and set route for each planes is the most difficult task for me. Since i have to find out a way for plane to move on the path without crashing but also have to find a way to make the code more accessable rather than picking each route for each planes spawning. 
- I'm still trying to find a way to do it, and i've learnt from my group's work on how to start building it and hopefully in the future i can fully implement this. 

**5.3.** Paste one code snippet that you are especially proud of. Explain why it goes beyond what was done in class.

