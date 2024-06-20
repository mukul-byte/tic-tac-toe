package models;

public class User {
    private String name;
    private String email;
    private String photo;

    private User(UserBuilder userBuilder){
        this.name = userBuilder.name;
        this.email = userBuilder.email;
        this.photo = userBuilder.photo;
    }

    public static class UserBuilder{
        private String name;
        private String email;
        private String photo;

        public UserBuilder(){}

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder setPhoto(String photo) {
            this.photo = photo;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}
