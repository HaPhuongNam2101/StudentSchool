package model;

public class Student {

        private int id;
        private String name;
        private int age;
        private double score;

        private static int idIncrement = 1;
        public Student( String name, int age, double score) {
            this.id = idIncrement;
            this.name = name;
            this.age = age;
            this.score = score;
            idIncrement ++;
        }

        public Student(int id, String name, int age, double score) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.score = score;
    }

    public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "Id học sinh: " + id + " | Học sinh có tên là: " + name + " | Tuổi  " + age + " | Điểm: " + score;
        }
    }


