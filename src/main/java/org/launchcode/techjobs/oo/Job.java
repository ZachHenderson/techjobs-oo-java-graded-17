package org.launchcode.techjobs.oo;


import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    private static final String emptyMessage = "Data not available";

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.
    public Job() {
        this.id = nextId;
        nextId++;
    }

    public Job(String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        String newLine = System.lineSeparator();

//       *** Using reflection
//            Job job = new Job();
//            Field[] fields = job.getClass().getDeclaredFields();
//            for (Field f : fields) {
//               f.setAccessible(true);
//               try {
//                   if (f.get(this) == null) {
//                       System.out.println(newLine + f +": Data not available");
//                   }
//               } catch (IllegalAccessException e) {
//
//               }
//
//            }

//        Job job1 = new Job();
//        new Job() {
//            public void checkForEmptyField() {
//                if (Objects.equals(job1.getName(), "")) {
//                    job1.setName("Data not available");
//                }
//            }
//        };


//        Second attempt
        return String.format(newLine + "ID: %s\nName: %s\nEmployer: %s\nLocation: %s\nPosition Type: %s\nCore Competency: %s" + newLine,
                id,
                Objects.equals(getName(), "") ? emptyMessage : name,
                Objects.equals(employer.getValue(), "") ? emptyMessage : employer,
                Objects.equals(location.getValue(), "") ? emptyMessage : location,
                Objects.equals(positionType.getValue(), "") ? emptyMessage : positionType,
                Objects.equals(coreCompetency.getValue() , "") ? emptyMessage : coreCompetency);

//        Original, working
//        return newLine + "ID: " + id + newLine + "Name: " + name + newLine + "Employer: " + employer + newLine + "Location: " + location + newLine + "Position Type: " + positionType + newLine + "Core Competency: " + coreCompetency + newLine;
    }

    public static void main(String[] args) {
        Job testjob = new Job("Product Tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        System.out.println(testjob);
    }
}
