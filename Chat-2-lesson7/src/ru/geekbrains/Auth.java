package ru.geekbrains;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

public class Auth {
    private static final Set<Entry> ent = Set.of(
        new Entry("User1", "l1", "p1"),
        new Entry("User2", "l2", "p2"),
        new Entry("User3", "l2", "p2")
    );
    
    public Optional<Entry> getEntryByCred(String login, String pass){
//        Iterator<Entry> it = ent.iterator();
//        while (it.hasNext()){
//            Entry next = it.next();
//            if (next.getLogin() == login && next.getPass() == pass) {
//                return Optional.of(next);
//            }
//        }
//        return Optional.empty();
        return ent.stream().filter(ent -> ent.getLogin().equals(login) && ent.getPass().equals(pass)).findFirst();
    }

    public static class  Entry {
        private String name;
        private String login;
        private String pass;

        public Entry(String name, String login, String pass) {
            this.name = name;
            this.login = login;
            this.pass = pass;
        }

        public String getName() {
            return name;
        }

        public String getLogin() {
            return login;
        }

        public String getPass() {
            return pass;
        }
    }
}
