package finalexam.task2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PaperFactory {
    private List<Person> staff = new ArrayList<>();

    public void addPerson(Person p) {
        staff.add(p);
    }

    public boolean deletePerson(Person p) {
        return staff.remove(p);
    }

    public void saveStaffToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(staff);
            System.out.println("Staff list saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadStaffFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            staff = (List<Person>) ois.readObject();
            System.out.println("Staff list loaded from " + filename);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Getters and setters (if needed)
    public List<Person> getStaff() {
        return staff;
    }

    public void setStaff(List<Person> staff) {
        this.staff = staff;
    }
}

