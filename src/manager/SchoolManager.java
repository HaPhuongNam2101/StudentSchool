package manager;

import model.School;
import model.Student;

import java.util.ArrayList;

public class SchoolManager implements IManager<School> {
    ArrayList<School> listScool;
    public SchoolManager() {
        this.listScool = new ArrayList<>();
    }
    public ArrayList<School> findByNameContain(String name){
        ArrayList<School> listSearch = new ArrayList<>();
        for(School item : this.listScool){
            if (item.getName().toLowerCase().contains(name.toLowerCase())){
                listSearch.add(item);
            }
        }
        return listSearch;
    }

    @Override
    public void add(School school) {
        listScool.add(school);
    }

    @Override
    public void remove(int id) {
        int index =findIndexById(id);
        listScool.remove(index);
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < listScool.size(); i++) {
            if (listScool.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void update(int id, School school) {
        int index = findIndexById(id);
        if (index >= 0) {
            this.listScool.set(index, school);
        }
    }

    @Override
    public ArrayList<School> findAll() {
        return this.listScool;
    }
}
