package manager;

import model.Student;

import java.util.ArrayList;

public class StudentManager implements IManager<Student> {
    ArrayList<Student> listStudents;
    public StudentManager() {
        this.listStudents = new ArrayList<>();
    }
    public ArrayList<Student> findByAgeRange(int from, int to){
        ArrayList<Student> listSearch = new ArrayList<>();
        for(Student item : this.listStudents){
            if(item.getAge() >= from && item.getAge() <= to){
                listSearch.add(item);
            }
        }
        return listSearch;
    }

    public ArrayList<Student> findByScore(double from, double to){
        ArrayList<Student> listSeach = new ArrayList<>();
        for(Student item : this.listStudents){
            if(item.getScore() >= from && item.getScore() <= to){
                listSeach.add(item);
            }
        }
        return listSeach;
    }

    public ArrayList<Student> findBynameContain(String name){
        ArrayList<Student> listSeach = new ArrayList<>();
        for(Student item : this.listStudents){
            if (item.getName().toLowerCase().contains(name.toLowerCase())){
                listSeach.add(item);
            }
        }
        return listSeach;
    }

    @Override
    public void add(Student student) {
        this.listStudents.add(student);
    }

    @Override
    public void remove(int id) {
        int index = findIndexById(id);
        if (index >= 0) {
            this.listStudents.remove(index);
        }
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < listStudents.size(); i++) {
            if (listStudents.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void update(int id, Student student) {
        int index = findIndexById(id);
        if (index >= 0) {
            this.listStudents.set(index, student);
        }
    }

    @Override
    public ArrayList<Student> findAll() {
        return this.listStudents;
    }
}
