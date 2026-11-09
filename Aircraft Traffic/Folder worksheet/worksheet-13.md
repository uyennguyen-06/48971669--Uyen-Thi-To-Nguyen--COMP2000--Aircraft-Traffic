# COMP2000 Worksheet 2 — Final Submission

**Student name:*Thi To Uyen Nguyen*

**GitHub repo URL:** (your own fork of your team's repository, not your team's URL)

My own fork of team's repository: https://github.com/uyennguyen-06/COMP2000-Assignment-TheDefaults

My individual project: https://github.com/uyennguyen-06/48971669--Uyen-Thi-To-Nguyen--COMP2000--Aircraft-Traffic

---

## 1. Design Patterns

Don't forget to submit a pdf file which shows a diagram of your pattern implemenation to supplement this text description.

**1.1.** Which design pattern(s) did you implement? Name them and state where each appears in your codebase.





**1.2.** For each pattern, paste a code snippet showing the key interaction between participants.





**1.3.** For each pattern, explain why you chose it over an alternative. What trade-off did you make?





---

## 2. Streams / Lambdas / Parallelism

**2.1.** List every file in your project that uses lambda expressions or the Streams API.

LAMBDA:
- In Main.java

    SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Airport Simulation");

                frame.setDefaultCloseOperation(
                    JFrame.EXIT_ON_CLOSE
                );
    .... <the rest of the code>
    });

- In AirportJPanel.java

    Timer timer = new Timer(30, event -> {
        for (Plane plane : airport.getPlanes()) {
            plane.updateMovement(
                airport.getRunway(),
                airport.getRunwayEntrance(),
                airport.getRunwayExit()
            );
        }
        repaint();
    });

STREAMS API 
- In AirportJPanel.java

    List<Plane> boardPlanes = airport.getPlanes()
        .stream()
        .filter(plane -> !plane.isFinished())
        .sorted(
            (plane1, plane2) ->
                plane1.getPlaneID().compareTo(
                    plane2.getPlaneID()
                )
        )


**2.2.** For the most sophisticated use, paste the code and explain: what does it do, and why was a stream/lambda better than a loop?

LAMBDA:
In Main.java

    SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame("Airport Simulation");
                frame.setDefaultCloseOperation(
                    JFrame.EXIT_ON_CLOSE
                );
    .... <the rest of the code>
    });

- This is better suited because Swing needs yo provide a piece of code to run later when an event happens. The "for" loop cannot do that because it only repeats codes. This lambda represents an action that Swing can store and execute at the correct time. 

In AirportJPanel.java

    Timer timer = new Timer(30, event -> {
        for (Plane plane : airport.getPlanes()) {
            plane.updateMovement(
                airport.getRunway(),
                airport.getRunwayEntrance(),
                airport.getRunwayExit()
            );
        }
        repaint();
    });

- A normal "for" loop could repeat operations, but it could not act as a callback for these events. This code tell java to run the code whenver the timer fires. A loop alone cannot listen for timer events and the lambda is the timer's event handler. A lambda also make the code shorter and easier to read. 

STREAMS API:
In AirportJPanel.java

    List<Plane> boardPlanes = airport.getPlanes()
        .stream()
        .filter(plane -> !plane.isFinished())
        .sorted(
            (plane1, plane2) ->
                plane1.getPlaneID().compareTo(
                    plane2.getPlaneID()
                )
        )

- This code processes the planes like:
.stream(): create a stream from plane list
.filter(): removes the plane that got out of the runway
.sorted(): arranges the remaining planes alphabetically by plane ID
.toList(): collects the results into a new list
- The stream filters out planes that have finished their routes and sorts the remaining planes by their plane IDs. This approach expresses each processing step and creates a new result list without changing the airport’s original list. Lambda expressions provide the filtering condition and comparison logic used by the stream.


**2.3.** Did you use parallel streams, custom collectors, or the Fork/Join framework? If yes, how did you ensure thread safety? If no, where could parallelism be introduced?

- No, this project does not use parallel streams, custom collectors, or the Fork/Join framework. The flight board uses a sequential stream to filter unfinished planes and sort them by plane ID. A sequential stream was appropriate because the number of planes in the simulation is small, so parallel processing would add unnecessary complexity and overhead. Additionally, the simulation uses Swing, whose interface components should be updated on the Event Dispatch Thread.

- Parallelism could theoretically be introduced when processing a very large number of planes, such as calculating independent routes or preparing flight-board data. 
- For example, parallelStream() could process planes concurrently as below:

List<Plane> boardPlanes = airport.getPlanes()
    .parallelStream()
    .filter(plane -> !plane.isFinished())
    .sorted(
        (plane1, plane2) ->
            plane1.getPlaneID().compareTo(plane2.getPlaneID())
    )
    .toList();

---

## 3. Uniqueness and Creativity

**3.1.** What did you add to your simulation that went beyond the in-class activities? Describe the feature and what inspired it.

- I used a lot of JPanel drawing for this project that I haven't used in any other courses. I overrode paintComponent to draw the runway, taxiway, gates, nodes, planes, and flight board. I also used a Swing Timer to update and repaint the moving planes. This was inspired by airport ground-control maps and allowed users to visually follow each plane’s movement and route.


**3.2.** Paste a code snippet or describe a design decision that demonstrates emergent behaviour, non-trivial complexity, or a genuinely surprising outcome.

- A design decision that shows emergent behaviour is connecting each gate to multiple airport-path nodes and using BFS to find a route. 
- The neighbouring nodes are shuffled when a plane leaves a gate, allowing planes to select different paths. Combined with node reservation, planes can independently choose routes while waiting if another plane occupies the next node. This creates movement patterns that are not manually scripted and can differ each time the simulation runs.

    ArrayList<Node> neighbours =
        new ArrayList<>(currentNode.getNeighbours());

    if (isGateNode(currentNode)) {
        Collections.shuffle(neighbours);
    }

    for (Node neighbour : neighbours) {
        if (!previousNode.containsKey(neighbour)) {
            previousNode.put(neighbour, currentNode);
            nodesToCheck.add(neighbour);
        }
    }


**3.3.** If you had another 6 weeks, what would you add or change?

- If I had another six weeks, I would add automatic plane spawning so new aircraft appear after others depart. I would also improve the route-finding system to consider traffic congestion instead of only finding an available path. 

- Other improvements would include arrival routes, smoother turning animations, different aircraft speeds, and a more detailed flight board showing destinations and departure times. Finally, I would add automated tests for route finding, node reservations, and runway access to ensure planes cannot collide.


---

## 4. Log Book and Final Reflection

**4.1.** Attach or link your log book entries for Weeks 7–13.





**4.2.** Reflect on the semester:

- What was the most important concept you learned?

- What design trade-off did you face, and how did you resolve it?

- If you started over, what would you do differently?

- What feedback from the Week 7 submission did you act on?
